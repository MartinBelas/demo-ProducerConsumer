package org.example;

import org.example.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * The FromListProducer produces commands provided in a List of commands, {@link Command} and puts them to the provided BlockingQueue buffer.
 */
class FromListProducer implements CommandsProducer {

    private static final Logger logger = LoggerFactory.getLogger(FromListProducer.class);

    private final BlockingQueue<Command> queue;
    private final List<Command> commands;

    public FromListProducer(BlockingQueue<Command> queue, List<Command> commands) {
        this.queue = queue;
        this.commands = commands;
    }

    @Override
    public void run() {

        commands.forEach(c -> {
            logger.info("Producing new command: {}", c.getClass().getSimpleName());
            try {
                queue.put(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}