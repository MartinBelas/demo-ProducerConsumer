package org.example;

import org.example.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private static final int QUEUE_SIZE = 100;

    public static void main(String[] args) {

        logger.info("Start the Application");

        List<Command> commands = new ArrayList<>();
        initializeCommands(commands);

        BlockingQueue<Command> queue = new LinkedBlockingDeque<>(QUEUE_SIZE);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new Producer(queue, commands));
        executor.execute(new Consumer(queue));

        executor.shutdown();
    }

    private static void initializeCommands(List<Command> commands) {
        commands.add(new Add(1, "a1", "Robert"));
        commands.add(new Add(2, "a2", "Martin"));
        commands.add(new PrintAll());
        commands.add(new DeleteAll());
        commands.add(new PrintAll());
        commands.add(new Quit());
    }
}
