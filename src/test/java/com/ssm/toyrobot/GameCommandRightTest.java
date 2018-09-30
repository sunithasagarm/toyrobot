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


public class GameCommandRightTest extends GameTestCommon {

    @Before
    public void before(){
        command = Command.RIGHT.toString();
    }

    @Test
    //Moving Right without start the game or without PLACE Command
    public void whenRightWithoutPlaceForEval_thenThrowException() throws Exception {
        Mockito.when(mockToyRobot.getPosition()).thenReturn(null);
        try {
            resultAsString = game.eval(command);
            Assert.fail();
        } catch (ToyRobotException e) {
            Assert.assertEquals("Use Place Command and then Right", e.getMessage());
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
    //Moving Invalid Right
    public void whenInvalidLeftForEval_thenReturnFalse() throws Exception {
        Mockito.when(mockToyRobot.getPosition()).thenReturn(mockPosition);
        Mockito.when(mockToyRobot.rotateRight()).thenReturn(false);
        resultAsString = game.eval(command);
        Assert.assertFalse(Boolean.valueOf(resultAsString));
        verify(mockPosition, times(0)).getNextPosition();
        verify(mockSquareBoard, times(0)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).move(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(1)).rotateRight();
        verify(mockToyRobot, times(0)).setPosition(Mockito.any(Position.class));
    }

    @Test
    //Moving Valid Right
    public void whenValidLeftForEval_thenReturnTrue() throws Exception {
        Mockito.when(mockToyRobot.getPosition()).thenReturn(mockPosition);
        Mockito.when(mockToyRobot.rotateRight()).thenReturn(true);
        resultAsString = game.eval(command);
        Assert.assertTrue(Boolean.valueOf(resultAsString));
        verify(mockToyRobot, times(1)).getPosition();
        verify(mockSquareBoard, times(0)).isValidPosition(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).move(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(1)).rotateRight();
        verify(mockToyRobot, times(0)).setPosition(Mockito.any(Position.class));
    }

}