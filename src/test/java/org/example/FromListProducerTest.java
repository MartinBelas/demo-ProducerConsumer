package org.example;

import org.example.command.Add;
import org.example.command.Command;
import org.example.command.DeleteAll;
import org.example.command.PrintAll;
import org.example.domain.User;
import org.example.repository.Repository;
import org.example.repository.RepositoryProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FromListProducerTest {

    Repository<User> repo = RepositoryProvider.getUserRepository();
    CommandsProducer producer;
    BlockingQueue<Command> queue;
    List<Command> commands;

    @BeforeEach
    void setUp() {
        queue = new LinkedBlockingQueue<>();
        commands = getCommands();
        producer = new FromListProducer(queue, commands);
    }

    @Test
    void testRun() {
        producer.run();
        assertEquals(commands.size(), queue.size());
    }

    private List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Add(repo, new User(1, "a1", "Robert")));
        commands.add(new Add(repo, new User(2, "a2", "Martin")));
        commands.add(new PrintAll(repo));
        commands.add(new DeleteAll(repo));
        return commands;
    }
}