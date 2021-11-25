package org.example.command;

import org.example.repository.UserRepositoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class DeleteAll implements Command {

    private static final Logger logger = LoggerFactory.getLogger(DeleteAll.class);

    @Override
    public void execute() {

        logger.info("Execute DeleteAll...");

        UserRepositoryProvider.getRepo().deleteAll();

        //TODO remove after the db implementation (for the purpose of example only)
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(100, 200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Command DeleteAll executed.");
    }
}
