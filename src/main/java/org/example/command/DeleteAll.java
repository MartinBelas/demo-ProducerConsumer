package org.example.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAll implements Command {

    private static final Logger logger = LoggerFactory.getLogger(DeleteAll.class);

    @Override
    public void execute() {

        logger.info("execute DeleteAll");

        //TODO
    }
}
