package org.example.repository;

public class UserRepositoryProvider {

    private static UserRepository repo;

    public static UserRepository getRepo() {

        if (repo == null) {
            repo = new UserRepository();
        }

        return repo;
    }
}
