package org.example.repo;

import org.example.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class UserRepo implements Repo<User>{

    private static Map<Integer, User> repo = new HashMap<>();

    @Override
    public void add(User user) {
        repo.put(user.getId(), user);
    }

    @Override
    public Stream<User> getAll() {
        return repo.values().stream();
    }

    @Override
    public void deleteAll() {
        repo.clear();
    }
}
