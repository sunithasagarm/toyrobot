package com.ssm.toyrobot.simulation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToyRobotTest {
    ToyRobot toyRobot;
    Position position;

    @Before
    public void  before(){
        toyRobot = new ToyRobot();
        position = new Position(4,5, Direction.EAST);
        toyRobot.setPosition(position);
    }

    @Test
    public void setPosition() {
        assertEquals(4,toyRobot.getPosition().getX());
        assertEquals(5,toyRobot.getPosition().getY());
        assertEquals(Direction.EAST, toyRobot.getPosition().getDirection());
    }

    @Test
    public void move() throws Exception{
        toyRobot.move();
        assertEquals(5, toyRobot.getPosition().getX());
        assertEquals(5, toyRobot.getPosition().getY());
        assertEquals(Direction.EAST, toyRobot.getPosition().getDirection());
    }

    @Test
    public void moveWithPosition() throws Exception{
        toyRobot.move(position);
        assertEquals(4, toyRobot.getPosition().getX());
        assertEquals(5, toyRobot.getPosition().getY());
        assertEquals(Direction.EAST, toyRobot.getPosition().getDirection());
    }

    @Test
    public void rotateLeft() {
        toyRobot.rotateLeft();
        assertEquals(4, toyRobot.getPosition().getX());
        assertEquals(5, toyRobot.getPosition().getY());
        assertEquals( Direction.NORTH, toyRobot.getPosition().getDirection());
    }

    @Test
    public void rotateRight() {
        toyRobot.rotateRight();
        assertEquals(4, toyRobot.getPosition().getX());
        assertEquals(5, toyRobot.getPosition().getY());
        assertEquals( Direction.SOUTH, toyRobot.getPosition().getDirection());

    }
}