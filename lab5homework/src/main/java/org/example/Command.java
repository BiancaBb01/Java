package org.example;

import org.example.InvalidCommandException;

import java.io.IOException;

/**
 * Interface representing a command that can be executed.
 */
public interface Command {
    /**
     * Executes the command with the given arguments.
     *
     * @param args The arguments for the command.
     * @throws IOException             If an I/O error occurs.
     * @throws InvalidCommandException If the command or its arguments are invalid.
     */
    void execute(String[] args) throws IOException, InvalidCommandException;
}

