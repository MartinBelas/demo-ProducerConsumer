package org.example.command;

import org.example.domain.User;
import org.example.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintAll implements Command {

    private static final Logger logger = LoggerFactory.getLogger(PrintAll.class);
    private final Repository<User> repo;

    public PrintAll(Repository<User> repo) {
        this.repo = repo;
    }

    @Override
    public void execute() {
        logger.info("Execute PrintAll...");
        repo.getAll().forEach(System.out::println);
        logger.info("Command PrintAll executed.");
    }
}
