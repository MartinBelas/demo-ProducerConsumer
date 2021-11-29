package org.example.repository;

import org.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RepositoryProvider {

    private static final Logger logger = LoggerFactory.getLogger(RepositoryProvider.class);

    private static final String REPO_TYPE;

    private static Repository<User> userRepository;

    static {
        InputStream input = RepositoryProvider.class.getClassLoader().getResourceAsStream("application.properties");
        Properties props = new Properties();

        if (input == null) {
            logger.error("Missing application.properties file.");
            System.exit(-1);
        }

        try {
            props.load(input);
        } catch (IOException e) {
            logger.error("Can't load application.properties .");
            e.printStackTrace();
            System.exit(-1);
        }

        REPO_TYPE = props.getProperty("repo.type");
        logger.info("Repository type: {}", REPO_TYPE);
    }

    private RepositoryProvider() {
    }

    public static Repository<User> getUserRepository() {

        if (REPO_TYPE.equalsIgnoreCase(RepositoryType.MAP.name())) {
            userRepository = getUserMapRepository();
        } else if (REPO_TYPE.equalsIgnoreCase(RepositoryType.JDBC.name())) {
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
