package com.ssm.toyrobot;

import com.ssm.toyrobot.properties.BoardProperties;
import com.ssm.toyrobot.simulation.Position;
import com.ssm.toyrobot.simulation.SquareBoard;
import com.ssm.toyrobot.simulation.ToyRobot;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class GameTestCommon {

    @Mock
    SquareBoard mockSquareBoard;

    @Mock
    ToyRobot mockToyRobot;

    @Mock
    Position mockPosition;

    @Mock
    BoardProperties mockBoardProperties;

    @InjectMocks
    Game game;

    String command;

    String resultAsString;

    boolean resultAsBoolean;
}
