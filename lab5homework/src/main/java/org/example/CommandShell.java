package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a command shell that allows users to interact with the system via commands.
 */
class CommandShell {

    private final Map<String, Command> commandMap;
    private final BufferedReader reader;

    /**
     * Constructs a CommandShell object with a given repository.
     *
     * @param repo The repository to be used by the command shell.
     */
    public CommandShell(Repository repo) {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        commandMap = new HashMap<>();
        commandMap.put("view", new ViewCommand());
        commandMap.put("report", new ReportCommand(repo));
        commandMap.put("export", new ExportCommand(repo));
    }

    /**
     * Runs the command shell, allowing users to enter commands and execute them.
     *
     * @throws IOException If an I/O error occurs while reading user input.
     */
    public void run() throws IOException {
        while (true) {
            System.out.print("Enter command: ");
            String input = reader.readLine();
            String[] parts = input.split(" ");
            String commandName = parts[0];
            String[] commandArgs = Arrays.copyOfRange(parts, 1, parts.length);

            try {
                Command command = commandMap.get(commandName);
                if (command == null) {
                    throw new InvalidCommandException("Invalid command: " + commandName);
                }
                command.execute(commandArgs);
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
