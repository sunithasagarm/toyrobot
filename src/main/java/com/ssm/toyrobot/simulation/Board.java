package com.ssm.toyrobot.simulation;

/**
 * Interface to find valid position.
 * Any class which validates a position should implement this.
 *
 * @author  Sunitha Mudumba
 * @version 1.0
 * @since   2018-09-30
 */
public interface Board {

   boolean isValidPosition(Position position);

}