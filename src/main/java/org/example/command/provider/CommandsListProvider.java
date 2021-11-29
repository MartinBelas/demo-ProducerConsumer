package org.example.command.provider;

import org.example.command.*;
import org.example.domain.User;
import org.example.repository.Repository;
import org.example.repository.RepositoryProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * This provider provides a List of {@link Command} implementation. It can be
 * used for demo purposes.
 */
public class CommandsListProvider {

    private static final Repository<User> repo = RepositoryProvider.getUserRepository();
    private static final List<Command> commands = new ArrayList<>();
    static {
        commands.add(new Add(repo, new User(1, "a1", "Robert")));
        commands.add(new Add(repo, new User(2, "a2", "Martin")));
        commands.add(new PrintAll(repo));
        commands.add(new DeleteAll(repo));
        commands.add(new PrintAll(repo));
        commands.add(new Quit());
    }

    private CommandsListProvider() {
    }

    public static List<Command> get() {
        return commands;
    }
}
