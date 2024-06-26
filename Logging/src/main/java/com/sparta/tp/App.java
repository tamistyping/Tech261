package com.sparta.tp;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
//        logger.log(Level.INFO, "this is an info message");
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        logger.fine("This is an info message");
        logger.info("This is an info message");
        logger.warning("This is an info message");
    }
}
