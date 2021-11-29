package org.example.repository;

import org.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcRepository implements Repository<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserJdbcRepository.class);

    @Override
    public void add(User user) {

        String query = "INSERT INTO SUSERS (USER_ID, USER_GUID, USER_NAME) VALUES (?,?,?)";

        try (Connection con = JdbcDataSource.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, user.getId());
            ps.setString(2, user.getUuid());
            ps.setString(3, user.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't insert record to table.");
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {

        String query = "SELECT * FROM SUSERS";

        List<User> result = new ArrayList<>();

        try (Connection con = JdbcDataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                result.add(new User(rs.getInt("USER_ID"), rs.getString("USER_GUID"), rs.getString("USER_NAME")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void deleteAll() {

        String query = "Truncate table SUSERS";

        try (Connection con = JdbcDataSource.getConnection(); Statement stmt = con.createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
