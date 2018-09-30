package com.ssm.toyrobot.simulation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {
    Direction direction;

    @Before
    public void setUp() throws Exception {
        Direction direction = Direction.EAST;
    }

    @Test
    public void whenChangeDirectionToLeftFromEast_thenResultDirectionIsNorth() {
        direction = Direction.EAST;
        direction = direction.leftDirection();
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    public void whenChangeDirectionToRightFromEast_thenResultDirectionIsSouth() {
        direction = Direction.EAST;
        direction = direction.rightDirection();
        assertEquals(Direction.SOUTH, direction);
    }

    @Test
    public void whenChangeDirectionToRightFromWest_thenResultDirectionIsNorth() {
        direction = Direction.WEST;
        direction = direction.rightDirection();
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    public void whenChangeDirectionToLeftFromWest_thenResultDirectionIsSouth() {
        direction = Direction.WEST;
        direction = direction.leftDirection();
        assertEquals(Direction.SOUTH, direction);

    }

    @Test
    public void whenChangeDirectionToLeftFromNorth_thenResultDirectionIsWest() {
        direction = Direction.NORTH;
        direction = direction.leftDirection();
        assertEquals(Direction.WEST, direction);

    }

    @Test
    public void whenChangeDirectionToRightFromNorth_thenResultDirectionIsEast() {
        direction = Direction.NORTH;
        direction = direction.rightDirection();
        assertEquals(Direction.EAST, direction);
    }

    @Test
    public void whenChangeDirectionToLeftFromSouth_thenResultDirectionIsEast() {
        direction = Direction.SOUTH;
        direction = direction.leftDirection();
        assertEquals(Direction.EAST, direction);

    }

    @Test
    public void whenChangeDirectionToRightFromSouth_thenResultDirectionIsWest() {
        direction = Direction.SOUTH;
        direction = direction.rightDirection();
        assertEquals(Direction.WEST, direction);
    }
}