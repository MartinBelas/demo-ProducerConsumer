package org.example;

/**
 * Every implementation of the <code>CommandsProducer</code> produces commands to a buffer.
 * A producer can produce commands provided from different sources, for example some collection, file, supplier, stream, API,...
 */
public interface CommandsProducer extends Runnable {
}
