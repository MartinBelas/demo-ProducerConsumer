package org.example.repository;

import org.example.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UserMapRepository implements Repository<User> {

    private static final ConcurrentMap<Integer, User> repo = new ConcurrentHashMap<>();

    @Override
    public void add(User user) {
        repo.put(user.getId(), user);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public void deleteAll() {
        repo.clear();
    }
}
