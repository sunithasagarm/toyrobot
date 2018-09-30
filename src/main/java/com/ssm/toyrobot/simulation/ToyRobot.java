package com.ssm.toyrobot.simulation;

import com.ssm.toyrobot.exception.ToyRobotException;
import org.springframework.stereotype.Component;

/**
 * ToyRobot is the player of the game where current position is held
 * Each time a move is executed, and if the its position
 * is valid on the board, new position is calculated and assigned.
 *
 * @author  Sunitha Mudumba
 * @version 1.0
 * @since   2018-09-30
 */


@Component
public class ToyRobot {

    private Position position;

    public ToyRobot() {
    }

    public ToyRobot(Position position) {
        this.position = position;
    }

    public boolean setPosition(Position position) {
        if (position == null)
            return false;

        this.position = position;
        return true;
    }

    public boolean move() throws ToyRobotException {
        return move(position.getNextPosition());
    }

    /**
     * Moves the robot one unit forward in the direction it is currently facing
     *
     * @return true if moved successfully else false
     */
    public boolean move(Position newPosition) {
        if (newPosition == null)
            return false;

        // change position
        this.position = newPosition;
        return true;
    }

    public Position getPosition() {
        return this.position;
    }

    /**
     * Rotates the robot 90 degrees LEFT
     *
     * @return true if rotated successfully
     */
    public boolean rotateLeft() {
        if (this.position.getDirection() == null)
            return false;

        this.position.setDirection(this.position.getDirection().leftDirection());
        return true;
    }

    /**
     * Rotates the robot 90 degrees RIGHT
     *
     * @return true if rotated successfully
     */
    public boolean rotateRight() {
        if (this.position.getDirection() == null)
            return false;

        this.position.setDirection(this.position.getDirection().rightDirection());
        return true;
    }

}
