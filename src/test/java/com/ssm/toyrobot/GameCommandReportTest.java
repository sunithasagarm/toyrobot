package com.ssm.toyrobot;

import com.ssm.toyrobot.simulation.Command;
import com.ssm.toyrobot.simulation.Direction;
import com.ssm.toyrobot.simulation.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class GameCommandReportTest extends GameTestCommon {

    @Before
    public void before(){
        command = Command.REPORT.toString();
    }

    @Test
    //Report without start without start the game or without PLACE Command
    public void whenReportWithoutPlaceForEval_thenMessage() throws Exception {
        Mockito.when(mockToyRobot.getPosition()).thenReturn(null);
            resultAsString = game.eval(command);
            Assert.assertEquals("Position not Set", resultAsString);
        verify(mockToyRobot, times(1)).getPosition();
        verify(mockToyRobot, times(0)).move(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(0)).setPosition(Mockito.any(Position.class));
    }

    @Test
    //Report on Valid
    public void whenValidReportForEval_thenReturnTrue() throws Exception {
        Mockito.when(mockToyRobot.getPosition()).thenReturn(mockPosition);
        Mockito.when(mockPosition.getX()).thenReturn(10);
        Mockito.when(mockPosition.getY()).thenReturn(10);
        Mockito.when(mockPosition.getDirection()).thenReturn(Direction.EAST);
        resultAsString = game.eval(command);
        Assert.assertEquals("10,10,EAST", resultAsString);
        verify(mockToyRobot, times(1)).getPosition();
        verify(mockToyRobot, times(0)).move(Mockito.any(Position.class));
        verify(mockToyRobot, times(0)).rotateLeft();
        verify(mockToyRobot, times(0)).rotateRight();
        verify(mockToyRobot, times(0)).setPosition(Mockito.any(Position.class));
    }

}