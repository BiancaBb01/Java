package org.example;

import org.example.Command;
import org.example.InvalidCommandException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * Concrete command class for viewing a document.
 */
class ViewCommand implements Command {
    @Override
    public void execute(String[] args) throws IOException, InvalidCommandException {
        if (args.length != 1) {
            throw new InvalidCommandException("Invalid arguments for view command");
        }

        String documentName = args[0];

        // Assuming the documents are stored in a specific directory
        File documentFile = new File("C:\\Users\\dell\\OneDrive\\Desktop\\AdvancedProgramming\\lab05\\compulsory\\src\\master\\" + documentName);

        // Check if the document exists
        if (!documentFile.exists() || !documentFile.isFile()) {
            throw new InvalidCommandException("Document not found: " + documentName);
        }

        // Open the document using the default application
        Desktop.getDesktop().open(documentFile);
    }
}