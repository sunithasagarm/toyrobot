package com.ssm.toyrobot;

import com.ssm.toyrobot.exception.ToyRobotException;
import com.ssm.toyrobot.simulation.Command;
import com.ssm.toyrobot.simulation.Direction;
import com.ssm.toyrobot.simulation.Position;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class GameCommandPlaceTest extends GameTestCommon {
    public static final String PLACE_COMMAND_WITH_ORIGIN = Command.PLACE.toString() + " 0,0,";


    //Tests to cover public method placeToyRobot
    //Normal Flow tests
    @Test
    public void whenToyRobotPlacedEastForPlaceToyRobot_thenReturnTrue() throws Exception {
        Mockito.when(mockPosition.getDirection()).thenReturn(Direction.EAST);
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        resultAsBoolean = game.placeToyRobot(mockPosition);
        assertTrue(resultAsBoolean);
        verify(mockPosition, times(1)).getDirection();
        verify(mockSquareBoard, times(1)).isValidPosition(mockPosition);
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(1)).setPosition(mockPosition);
    }

    @Test
    public void whenToyRobotPlacedWestForPlaceToyRobot_thenReturnTrue() throws Exception {
        Mockito.when(mockPosition.getDirection()).thenReturn(Direction.WEST);
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        resultAsBoolean = game.placeToyRobot(mockPosition);
        assertTrue(resultAsBoolean);
        verify(mockPosition, times(1)).getDirection();
        verify(mockSquareBoard, times(1)).isValidPosition(mockPosition);
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(1)).setPosition(mockPosition);
    }

    @Test
    public void whenToyRobotPlacedNorthForPlaceToyRobot_thenReturnTrue() throws Exception {
        Mockito.when(mockPosition.getDirection()).thenReturn(Direction.NORTH);
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        resultAsBoolean = game.placeToyRobot(mockPosition);
        assertTrue(resultAsBoolean);
        verify(mockPosition, times(1)).getDirection();
        verify(mockSquareBoard, times(1)).isValidPosition(mockPosition);
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(1)).setPosition(mockPosition);
    }

    @Test
    public void whenToyRobotPlacedSouthForPlaceToyRobot_thenReturnTrue() throws Exception {
        Mockito.when(mockPosition.getDirection()).thenReturn(Direction.SOUTH);
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        resultAsBoolean = game.placeToyRobot(mockPosition);
        assertTrue(resultAsBoolean);
        verify(mockPosition, times(1)).getDirection();
        verify(mockSquareBoard, times(1)).isValidPosition(mockPosition);
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(1)).setPosition(mockPosition);
    }

    //Negative tests,There is a probability that game could be started with an null direction.
    //Ensure the application behaves as expected
    @Test
    public void whenPlacedWithInvalidDirectionForPlaceToyRobot_thenThrowException() {
        Mockito.when(mockPosition.getDirection()).thenReturn(null);
        try {
            resultAsBoolean = game.placeToyRobot(mockPosition);
            assertFalse(true);
        } catch (ToyRobotException e) {
            assertEquals("Invalid direction value", e.getMessage());
        }
        verify(mockPosition, times(1)).getDirection();
        verify(mockSquareBoard, times(0)).isValidPosition(mockPosition);
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(0)).setPosition(mockPosition);
    }

    //Test to cover public method Eval
    //All tests for all commands from origin
    @Test
    public void whenPlaceWithOriginAndEastForEval_thenReturnTrue() throws Exception {
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        command = PLACE_COMMAND_WITH_ORIGIN + Direction.EAST.toString();
        resultAsString = game.eval(command);
        Assert.assertTrue(Boolean.valueOf(resultAsString));
        verify(mockSquareBoard, times(1)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(1)).setPosition(Mockito.any(Position.class));
    }

    @Test
    public void whenPlaceWithOriginAndWestForEval_thenReturnTrue() throws Exception {
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        command = PLACE_COMMAND_WITH_ORIGIN + Direction.WEST.toString();
        resultAsString = game.eval(command);
        Assert.assertTrue(Boolean.valueOf(resultAsString));
        verify(mockSquareBoard, times(1)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(1)).setPosition(Mockito.any(Position.class));
    }

    @Test
    public void whenPlaceWithOriginAndNorthForEval_thenReturnTrue() throws Exception {
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        command = PLACE_COMMAND_WITH_ORIGIN + Direction.NORTH.toString();
        resultAsString = game.eval(command);
        Assert.assertTrue(Boolean.valueOf(resultAsString));
        verify(mockSquareBoard, times(1)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(1)).setPosition(Mockito.any(Position.class));
    }

    @Test
    public void whenPlaceWithOriginAndSouthForEval_thenReturnTrue() throws Exception {
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        command = PLACE_COMMAND_WITH_ORIGIN + Direction.SOUTH.toString();
        resultAsString = game.eval(command);
        Assert.assertTrue(Boolean.valueOf(resultAsString));
        verify(mockSquareBoard, times(1)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).move(mockPosition);
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(1)).setPosition(Mockito.any(Position.class));
    }

}