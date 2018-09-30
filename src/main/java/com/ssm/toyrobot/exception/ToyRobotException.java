package com.ssm.toyrobot.exception;

/**
 * All user defined exceptions are handled using this exception class
 *
 * @author  Sunitha Mudumba
 * @version 1.0
 * @since   2018-09-30
 */

public class ToyRobotException extends Exception{

    public ToyRobotException(String message) {
        super(message);
    }
}
