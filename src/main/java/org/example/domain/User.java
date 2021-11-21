package org.example.domain;

public class User {

    int id;
    String guid;
    String name;

    public User(int userId, String userGuid, String userName) {
        this.id = userId;
        this.guid = userGuid;
        this.name = userName;
    }

    public String getUuid() {
        return guid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
