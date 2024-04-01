package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Creating a Repository
        Repository repository = new Repository("C:\\Users\\dell\\OneDrive\\Desktop\\AdvancedProgramming\\lab05\\compulsory\\src\\master");
        // Displaying repository content
        repository.displayRepositoryContent();

        CommandShell cs = new CommandShell(repository);
        try {
            cs.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}