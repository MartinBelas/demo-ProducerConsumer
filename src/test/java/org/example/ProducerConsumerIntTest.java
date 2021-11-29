package org.example;

import org.example.command.*;
import org.example.domain.User;
import org.example.repository.Repository;
import org.example.repository.UserMapRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProducerConsumerIntTest {

    List<Command> commands;
    Repository<User> repo;
    BlockingQueue<Command> queue;
    CommandsConsumer consumer;
    CommandsProducer producer;

    @BeforeEach
    void setUp() {
        repo = new UserMapRepository();
        queue = new LinkedBlockingQueue<>();

        commands = new ArrayList<>();
        commands.add(new Add(repo, new User(1, "a1", "Robert")));
        commands.add(new Add(repo, new User(2, "a2", "Martin")));
        commands.add(new PrintAll(repo));
        commands.add(new DeleteAll(repo));
        commands.add(new PrintAll(repo));

        consumer = new CommandsConsumer(queue);
    }

    @Test
    void testFifo_afterFirstTwoCommands() throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        producer = new FromListProducer(queue, commands.subList(0, 3));
        executor.execute(producer);
        executor.execute(consumer);
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        assertEquals(2, repo.getAll().size());
    }

    @Test
    void testFifo_afterAllCommands() throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        producer = new FromListProducer(queue, commands);
        executor.execute(producer);
        executor.execute(consumer);
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        assertTrue(repo.getAll().isEmpty());
    }
}