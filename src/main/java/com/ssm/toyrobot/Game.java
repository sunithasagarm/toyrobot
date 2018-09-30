package com.ssm.toyrobot;

import com.ssm.toyrobot.exception.ToyRobotException;
import com.ssm.toyrobot.simulation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Game will be started when an instance of this object is executed.
 * It requires a valid Board and a player (ToyRobot) to run.
 *
 * @author Sunitha Mudumba
 * @version 1.0
 * @since 2018-09-30
 */


@Component
public class Game {

    private Board squareBoard;
    private ToyRobot robot;

    @Autowired
    public Game(Board board, ToyRobot robot) {
        this.squareBoard = board;
        this.robot = robot;
    }

    /**
     * Places the robot on the squareBoard  in position X,Y and facing NORTH, SOUTH, EAST or WEST
     *
     * @param position Robot position
     * @return true if placed successfully
     * @throws ToyRobotException if squareBoard or Position or direction are null
     */
    public boolean placeToyRobot(Position position) throws ToyRobotException {

        if (position.getDirection() == null)
            throw new ToyRobotException("Invalid direction value");

        // validate the position
        if (!squareBoard.isValidPosition(position))
            return false;

        // if position is valid then assign values to fields
        robot.setPosition(position);
        return true;

    }

    /**
     * Evaluates and executes a string command.
     *
     * @param inputString command string
     * @return string value of the executed command
     * @throws ToyRobotException if invalid command and invalid number of arguments
     */
    public String eval(String inputString) throws ToyRobotException {
        String[] args = inputString.split(" ");

        // validate command
        Command command;
        Position position;
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new ToyRobotException("Invalid command");
        }
        if (command == Command.PLACE && args.length < 2) {
            throw new ToyRobotException("Invalid command");
        }

        // validate PLACE params
        String[] params;
        int x = 0;
        int y = 0;
        Direction commandDirection = null;
        if (command == Command.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandDirection = Direction.valueOf(params[2]);
            } catch (Exception e) {
                throw new ToyRobotException("Invalid command");
            }
        }

        String output;

        switch (command) {
            case PLACE:
                output = String.valueOf(placeToyRobot(new Position(x, y, commandDirection)));
                break;
            case MOVE:
                //Possibility to issue MOVE without placing the toyRobot
                position = robot.getPosition();
                if (null != position) {
                    Position newPosition = position.getNextPosition();
                    if (!squareBoard.isValidPosition(newPosition))
                        output = String.valueOf(false);
                    else
                        output = String.valueOf(robot.move(newPosition));
                } else {
                    throw new ToyRobotException("Use Place Command and then Move");
                }
                break;
            case LEFT:
                position = robot.getPosition();
                if (null != position) {
                    output = String.valueOf(robot.rotateLeft());
                } else {
                    throw new ToyRobotException("Use Place Command and then Left");
                }
                break;
            case RIGHT:
                position = robot.getPosition();
                if (null != position) {
                    output = String.valueOf(robot.rotateRight());
                } else {
                    throw new ToyRobotException("Use Place Command and then Right");
                }
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new ToyRobotException("Invalid command");
        }
        return output;

    }

    /**
     * Returns the X,Y and Direction of the robot
     */
    private String report() {
        Position position = robot.getPosition();
        if (position == null)
            return "Position not Set";
        return position.getX() + "," + position.getY() + "," + position.getDirection().toString();

    }
}
