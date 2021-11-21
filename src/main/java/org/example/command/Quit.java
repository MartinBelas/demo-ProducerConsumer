package org.example.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Quit implements Command {

    private static final Logger logger = LoggerFactory.getLogger(Quit.class);

    @Override
    public void execute() {
        logger.info("The Application finished correctly.");
    }
}
