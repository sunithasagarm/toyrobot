package com.ssm.toyrobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ssm.toyrobot.exception.ToyRobotException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Thread to start an interacting instance of a a Game.
 *
 * @author Sunitha Mudumba
 * @version 1.0
 * @since 2018-09-30
 */

@Component
public class StartGame implements Runnable {
    @Autowired
    Game game;


    @Override
    public void run() {
        BufferedReader bufferInputReader = null;
        try {

            bufferInputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Toy Robot Simulator");
            System.out.println("Enter a valid command from he list below:");
            System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");

            boolean keepReadingInput = true;
            while (keepReadingInput) {
                String inputString = bufferInputReader.readLine();
                if ("EXIT".equals(inputString)) {
                    keepReadingInput = false;
                } else {
                    {
                        try {
                            String outputVal = game.eval(inputString);
                            System.out.println(outputVal);
                        } catch (ToyRobotException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (bufferInputReader != null) {
                try {
                    bufferInputReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}