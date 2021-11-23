package org.example.provider;

import org.example.command.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This provider provides a List of {@link Command} implementation.
 * It can be used for demo purposes.
 */
public class CommandsListProvider {

    private static List<Command> commands = new ArrayList<>();
    {
        commands.add(new Add(1, "a1", "Robert"));
        commands.add(new Add(2, "a2", "Martin"));
        commands.add(new PrintAll());
        commands.add(new DeleteAll());
        commands.add(new PrintAll());
        commands.add(new Quit());
    }

    public static List<Command> get() {
        return commands;
    }
}
