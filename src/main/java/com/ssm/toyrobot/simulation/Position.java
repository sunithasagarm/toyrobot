package com.ssm.toyrobot.simulation;

import com.ssm.toyrobot.exception.ToyRobotException;

/**
 * Class which holds the current position of the robot on the board
 * and also calculates the next position based on the direction.
 * Position x - is used for moving in EAST (move 1 point forward) or WEST (move 1 point backward) Direction
 * Position y - is used to move in NORTH (move 1 point in upward direction) or SOUTH  (move 1 point in downward Direction.
 *
 * @author Sunitha Mudumba
 * @version 1.0
 * @since 2018-09-30
 */

public class Position {
    private int x;
    private int y;
    private Direction direction;

    private Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public Position getNextPosition() throws ToyRobotException {
        if (this.direction == null)
            throw new ToyRobotException("Invalid robot direction");

        // new position to validate
        Position newPosition = new Position(this);
        switch (this.direction) {
            case NORTH:
                newPosition.change(0, 1);
                break;
            case EAST:
                newPosition.change(1, 0);
                break;
            case SOUTH:
                newPosition.change(0, -1);
                break;
            case WEST:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }
}
