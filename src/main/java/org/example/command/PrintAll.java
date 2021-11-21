package org.example.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintAll implements Command {

    private static final Logger logger = LoggerFactory.getLogger(PrintAll.class);

    @Override
    public void execute() {

        logger.info("execute PrintAll");

        //TODO
    }
}
