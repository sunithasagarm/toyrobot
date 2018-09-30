package com.ssm.toyrobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring boot starter.
 *
 * @author  Sunitha Mudumba
 * @version 1.0
 * @since   2018-09-30
 */

@SpringBootApplication
public class ToyRobotApplication {

   @Autowired
   StartGame startGame;

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(ToyRobotApplication.class, args);
        ToyRobotApplication tra = context.getBean(ToyRobotApplication.class);
        tra.startup();
    }

    private void startup(){
        startToyRobotGame();
    }

    private void startToyRobotGame(){
        Thread watchThread = new Thread(startGame);
        watchThread.setName("Toy-Robot-Simulator");
        watchThread.start();
    }
}
