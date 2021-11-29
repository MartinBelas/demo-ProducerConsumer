package org.example.command;

import org.example.domain.User;
import org.example.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Add implements Command {

    private static final Logger logger = LoggerFactory.getLogger(Add.class);

    private final Repository<User> repo;
    private final User user;

    public Add(Repository<User> repo, User user) {
        this.repo = repo;
        this.user = user;
    }

    @Override
    public void execute() {
        logger.info("Execute Add user: {} ...", user);
        repo.add(user);
        logger.info("Command Add user: {} executed.", user);
    }
}
