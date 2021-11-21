package org.example.repo;

public class UserRepoProvider {

    private static UserRepo repo;

    public static UserRepo getRepo() {

        if (repo == null) {
            repo = new UserRepo();
        }

        return repo;
    }
}
