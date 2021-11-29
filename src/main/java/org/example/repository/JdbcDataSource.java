package org.example.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcDataSource {

    private static final Logger logger = LoggerFactory.getLogger(JdbcDataSource.class);

    private static final HikariDataSource ds;

    static {
        InputStream input = RepositoryProvider.class.getClassLoader().getResourceAsStream("datasource.properties");
        final Properties props = new Properties();

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

        HikariConfig config = new HikariConfig(props);
        config.setJdbcUrl(props.getProperty("dataSource.jdbcUrl"));
        config.setUsername(props.getProperty("dataSource.username"));
        config.setPassword(props.getProperty("dataSource.password"));

        ds = new HikariDataSource(config);

        logger.info("Repository typeDatasource properties loaded, jdbcUrl: {}",
                props.getProperty("dataSource.jdbcUrl"));
    }

    private JdbcDataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
