package org.example;

import org.example.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FromListProducerTest {

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
        commands.add(new Add(1, "a1", "Robert"));
        commands.add(new Add(2, "a2", "Martin"));
        commands.add(new PrintAll());
        commands.add(new DeleteAll());
        return commands;
    }
}