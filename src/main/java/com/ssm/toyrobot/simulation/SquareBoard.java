package com.ssm.toyrobot.simulation;

import com.ssm.toyrobot.properties.BoardProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Square board is the board on which the game will be played
 * it validates the position on the board. Size is defined by the properties injected
 * For example if the the board size is 5 by 5
 * then valid range for rows is between 0 and 5 including 0 and 5
 * then valid range of columns is between 0 and 5 including 0 and 5
 *
 * @author  Sunitha Mudumba
 * @version 1.0
 * @since   2018-09-30
 */

@Component
public class SquareBoard implements Board {

    private int rows;
    private int columns;

    @Autowired
    public SquareBoard(BoardProperties boardProperties) {
        this.rows = boardProperties.getRowSize();
        this.columns = boardProperties.getColSize();
    }

    /**
     * Validates the position on the board
     * @param position Position of the player
     * @return boolean true if valid and false if it is invalid
     */
    @Override
    public boolean isValidPosition(Position position) {
        return !(
                position.getX() > this.columns  || position.getX() < 0 ||
                        position.getY() > this.rows || position.getY() < 0
        );
    }
}
