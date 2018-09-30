package com.ssm.toyrobot.simulation;

import com.ssm.toyrobot.properties.BoardProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SquareBoardTest {

    @Mock
    BoardProperties mockBoardProperties;

    @InjectMocks
    SquareBoard squareBoard;

    @Mock
    Position mockPosition;

    boolean result;

    @Test
    public void whenIsValidPosition_thenResultIsTrue() {
        result = squareBoard.isValidPosition(mockPosition);
        assertTrue(result);
    }

    @Test
    public void whenInvalidPositionForIsValid_thenResultIsFalse() {
        Mockito.when(mockPosition.getY()).thenReturn(-1);
        Mockito.when(mockPosition.getX()).thenReturn(-1);
        result = squareBoard.isValidPosition(mockPosition);
        assertFalse(false);
    }

    @Test
    public void whenPositionIsOutOfRangeForIsValidWithPosition_thenResultIsFalse() {
        Mockito.when(mockBoardProperties.getColSize()).thenReturn(5);
        Mockito.when(mockBoardProperties.getColSize()).thenReturn(5);
        Mockito.when(mockPosition.getY()).thenReturn(6);
        Mockito.when(mockPosition.getX()).thenReturn(6);
        result = squareBoard.isValidPosition(mockPosition);
        assertFalse(false);
    }
}