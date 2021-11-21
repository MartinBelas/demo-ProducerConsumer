package org.example;

import org.example.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private final BlockingQueue<Command> queue;

    public Consumer(BlockingQueue<Command> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Command command = queue.take();
                logger.info("Executing command: {}", command.getClass().getSimpleName());
                command.execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
