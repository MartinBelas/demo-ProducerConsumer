package org.example;

import org.example.command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CommandsConsumerTest {

    CommandsConsumer consumer;
    BlockingQueue<Command> queue;
    Command command = Mockito.mock(Command.class);

    @BeforeEach
    void setUp() {
        initializeQueue();
        consumer = new CommandsConsumer(queue);
    }

    @Test
    void run() throws InterruptedException {

        final int commandsCount = queue.size();

        doNothing().when(command).execute();

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(consumer);
        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);

        assertTrue(queue.isEmpty());
        verify(command, times(commandsCount)).execute();
    }

    private void initializeQueue() {
        queue = new LinkedBlockingQueue<>();
        queue.add(command);
        queue.add(command);
        queue.add(command);
    }
}