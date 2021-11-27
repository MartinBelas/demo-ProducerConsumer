package org.example.repository;

import org.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepositoryProvider {

    private static final Logger logger = LoggerFactory.getLogger(RepositoryProvider.class);

    private static final String REPO_TYPE = "map"; //TODO from properties file

    private static Repository<User> userRepository;

    static {
        logger.info("Repository type: {}", REPO_TYPE);
    }

    private RepositoryProvider() {}

    public static Repository<User> getUserRepository() {

        if (REPO_TYPE.equals(RepositoryType.MAP.name())) {
            userRepository = getUserMapRepository();
        } else if (REPO_TYPE.equals(RepositoryType.JDBC.name())) {
            userRepository = getUserJdbcRepository();
        } else {
            logger.error("Unknown repository type: {}", REPO_TYPE);
            System.exit(-1);
        }

        return userRepository;
    }

    private static Repository<User> getUserMapRepository() {

        if (userRepository == null) {
            userRepository = new UserMapRepository();
        }
        return userRepository;
    }


    private static Repository<User> getUserJdbcRepository() {

        if (userRepository == null) {
            userRepository = new UserJdbcRepository();
        }
        return userRepository;
    }
}
