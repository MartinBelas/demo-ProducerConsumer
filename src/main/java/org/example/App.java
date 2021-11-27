package org.example;

import org.example.command.*;
import org.example.command.provider.CommandsListProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private static final int QUEUE_SIZE = 100;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {

        logger.info("Start the Application");

        BlockingQueue<Command> queue = new LinkedBlockingDeque<>(QUEUE_SIZE);
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        CommandsProducer producer = new FromListProducer(queue, CommandsListProvider.get());
        CommandsConsumer consumer = new CommandsConsumer(queue);

        executor.execute(producer);
        executor.execute(consumer);

        executor.shutdown();
    }
}
