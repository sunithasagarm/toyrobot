package com.ssm.toyrobot;

import com.ssm.toyrobot.exception.ToyRobotException;
import com.ssm.toyrobot.simulation.Command;
import com.ssm.toyrobot.simulation.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class GameCommandMoveTest extends GameTestCommon {
    @Before
    public void before(){
        command = Command.MOVE.toString();
    }

    @Test
    //Moving without start the game or without PLACE Command
    public void whenMoveWithoutPlaceForEval_thenThrowException() throws Exception {
        Mockito.when(mockToyRobot.getPosition()).thenReturn(null);
        try {
            resultAsString = game.eval(command);
            Assert.fail();
        } catch (ToyRobotException e) {
           Assert.assertEquals("Use Place Command and then Move", e.getMessage());
        }
        Assert.assertFalse(Boolean.valueOf(resultAsString));
        verify(mockPosition, times(0)).getNextPosition();
        verify(mockSquareBoard, times(0)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(1)).getPosition();
        verify(mockToyRobot, times(0)).move(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(0)).setPosition(Mockito.any(Position.class));
    }

    @Test
    //Moving Invalid Move
    public void whenInvalidMoveForEval_thenReturnFalse() throws Exception {
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(false);
        Mockito.when(mockToyRobot.getPosition()).thenReturn(mockPosition);
        Mockito.when(mockToyRobot.getPosition().getNextPosition()).thenReturn(mockPosition);
        resultAsString = game.eval(command);
        Assert.assertFalse(Boolean.valueOf(resultAsString));
        verify(mockPosition, times(1)).getNextPosition();
        verify(mockSquareBoard, times(1)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).move(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(0)).setPosition(Mockito.any(Position.class));
    }

    @Test
    //Moving Valid Move
    public void whenValidMoveForEval_thenReturnTrue() throws Exception {
        Mockito.when(mockSquareBoard.isValidPosition(Mockito.any(Position.class))).thenReturn(true);
        Mockito.when(mockToyRobot.getPosition()).thenReturn(mockPosition);
        Mockito.when(mockPosition.getNextPosition()).thenReturn(mockPosition);
        Mockito.when(mockToyRobot.move(Mockito.any(Position.class))).thenReturn(true);
        resultAsString = game.eval(command);
        Assert.assertTrue(Boolean.valueOf(resultAsString));
        verify(mockToyRobot, times(1)).getPosition();
        verify(mockSquareBoard, times(1)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(1)).move(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(0)).setPosition(Mockito.any(Position.class));
    }
}