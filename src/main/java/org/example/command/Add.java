package org.example.command;

import org.example.domain.User;
import org.example.repository.Repository;
import org.example.repository.RepositoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Add implements Command {

    private static final Logger logger = LoggerFactory.getLogger(Add.class);

    private final Repository<User> repo;
    private final User user;

    public Add(int userId, String userGuid, String userName) {
        this.repo = RepositoryProvider.getUserRepository();
        this.user = new User(userId, userGuid, userName);
    }

    @Override
    public void execute() {
        logger.info("Execute Add user: {} ...", user);
        repo.add(user);
        logger.info("Command Add user: {} executed.", user);
    }
}
