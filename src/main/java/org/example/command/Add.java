package org.example.command;

import org.example.domain.User;
import org.example.repository.UserRepositoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class Add implements Command {

    private static final Logger logger = LoggerFactory.getLogger(Add.class);

    private final User user;

    public Add(int userId, String userGuid, String userName) {
        this.user = new User(userId, userGuid, userName);
    }

    @Override
    public void execute() {

        logger.info("Execute Add userId: {}, userGuid: {}, userName: {} ...",
                user.getId(), user.getUuid(), user.getName());

        UserRepositoryProvider.getRepo().add(user);

        //TODO remove after the db implementation (for the purpose of example only)
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(200,1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Command Add userId: {}, userGuid: {}, userName: {} executed.", user.getId(), user.getUuid(), user.getName());
    }
}
