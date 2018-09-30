package com.ssm.toyrobot.simulation;

import com.ssm.toyrobot.exception.ToyRobotException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PositionTest {
    @Test
    public void whenGetNextPositionFromOriginAndNorth_thenResultSameDirectionMoveOnePointUpward() throws Exception {
        Position position = new Position(0, 0, Direction.NORTH);
        Position result = position.getNextPosition();
        assertEquals(result.getDirection(), Direction.NORTH);
        assertEquals(0, result.getX());
        assertEquals(1, result.getY());
    }

    @Test
    public void whenGetNextPositionFromOriginAndSount_thenResultSameDirectionMoveOnePointDownward() throws Exception {
        Position position = new Position(0, 0, Direction.SOUTH);
        Position result = position.getNextPosition();
        assertEquals(result.getDirection(), Direction.SOUTH);
        assertEquals(0, result.getX());
        assertEquals(-1, result.getY());
    }

    @Test
    public void whenGetNextPositionFromOriginAndEast_thenResultSameDirectionMoveOnePointForward() throws Exception {
        Position position = new Position(0, 0, Direction.EAST);
        Position result = position.getNextPosition();
        assertEquals(result.getDirection(), Direction.EAST);
        assertEquals(1, result.getX());
        assertEquals(0, result.getY());
    }

    @Test
    public void whenGetNextPositionFromOriginAndWest_thenResultSameDirectionMoveOnePointBackward() throws Exception {
        Position position = new Position(0, 0, Direction.WEST);
        Position result = position.getNextPosition();
        assertEquals(result.getDirection(), Direction.WEST);
        assertEquals(-1, result.getX());
        assertEquals(0, result.getY());
    }

    @Test
    public void whenDirectionIsNullForGetNextPosition_thenThrowException() {
        Position position = new Position(0, 0, null);

        try {
            Position result = position.getNextPosition();
            Assert.fail();
        } catch (ToyRobotException e) {
            assertEquals("Invalid robot direction", e.getMessage());
        }
    }
}