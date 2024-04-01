package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Concrete command class for exporting the repository to a file.
 */
class ExportCommand implements Command {
    private final Repository repository;

    /**
     * Constructs an ExportCommand object with the given repository.
     *
     * @param repository The repository to export.
     */
    public ExportCommand(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(String[] args) throws IOException, InvalidCommandException {
        if (args.length != 1) {
            throw new InvalidCommandException("Invalid arguments for export command");
        }

        String filePath = args[0];

        // Serialize the repository to JSON and write it to the specified file
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), repository);

        System.out.println("Export command executed. Repository exported to: " + filePath);
    }
}