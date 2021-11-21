package org.example.command;

import org.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Add implements Command {

    private static final Logger logger = LoggerFactory.getLogger(Add.class);

    private final User user;

    public Add(int userId, String userGuid, String userName) {
        this.user = new User(userId, userGuid, userName);
    }

    @Override
    public void execute() {

        logger.info("execute Add userId: {}, userGuid: {}, userName: {}", user.getId(), user.getUuid(), user.getName());

        //TODO insert to db
    }
}
