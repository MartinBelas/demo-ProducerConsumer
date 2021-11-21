package org.example.command;

import org.example.repo.UserRepoProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class PrintAll implements Command {

    private static final Logger logger = LoggerFactory.getLogger(PrintAll.class);

    @Override
    public void execute() {

        logger.info("Execute PrintAll...");

        UserRepoProvider.getRepo().getAll().forEach(System.out::println);

        //TODO remove after the db implementation (for the purpose of example only)
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(700,1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Command PrintAll executed.");
    }
}
