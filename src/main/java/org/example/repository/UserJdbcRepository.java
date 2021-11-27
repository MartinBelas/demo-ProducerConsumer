package org.example.repository;

import org.example.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcRepository implements Repository<User> {

    //TODO from application.properties file
    static final String DB_URL = "jdbc:h2://localhost/";
    static final String USER = "demo";
    static final String PASS = "demo123";

    @Override
    public void add(User user) {

        String query = "INSERT INTO SUSER (USER_ID, USER_GUID, USER_NAME) VALUES (?,?,?)";

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(query)
        ) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUuid());
            ps.setString(3, user.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {

        String query = "SELECT * FROM SUSER";

        List<User> result = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                result.add(new User(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void deleteAll() {

        String query = "Truncate table SUSER";

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = con.createStatement()
        ) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
