package org.example;

import org.example.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private final BlockingQueue<Command> queue;
    private final List<Command> commands;

    public Producer(BlockingQueue<Command> queue, List<Command> commands) {
        this.queue = queue;
        this.commands = commands;
    }

    @Override
    public void run() {

        commands.stream().forEach(c -> {
            logger.info("Producing new command: {}", c.getClass().getSimpleName());
            try {
                queue.put(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}