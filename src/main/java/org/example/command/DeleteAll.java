package org.example.command;

import org.example.domain.User;
import org.example.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAll implements Command {

    private static final Logger logger = LoggerFactory.getLogger(DeleteAll.class);
    private final Repository<User> repo;

    public DeleteAll(Repository<User> repo) {
        this.repo = repo;
    }

    @Override
    public void execute() {
        logger.info("Execute DeleteAll...");
        repo.deleteAll();
        logger.info("Command DeleteAll executed.");
    }
}
