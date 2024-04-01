package org.example;

import org.example.Document;
import org.example.Person;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * The Repository class represents a document repository where documents are organized based on persons.
 * It loads documents from a specified directory and organizes them by person.
 */
public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    /**
     * Constructs a Repository object with the specified directory path.
     * It loads documents from the directory during initialization.
     *
     * @param directory the path to the directory containing documents organized by persons
     */
    public Repository(String directory) {
        this.directory = directory;
        loadDocuments();
    }

    /**
     * Loads documents from the specified directory and organizes them by person.
     * It walks through the directory and processes each employee directory found.
     */
    private void loadDocuments() {
        try {
            Files.walk(Paths.get(directory), 1)
                    .filter(Files::isDirectory)
                    .forEach(this::processEmployeeDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes an employee directory, extracts person information, and loads documents associated with that person.
     *
     * @param directory the path to the employee directory
     */
    private void processEmployeeDirectory(Path directory) {
        if (directory.getFileName().compareTo(Path.of("master")) == 0)
            return;

        Person person = extractPersonFromDirectoryName(directory.getFileName().toString());
        List<Document> documentList = new ArrayList<>();
        try {
            Files.walk(directory)
                    .filter(Files::isRegularFile)
                    .forEach(file -> documentList.add(new Document(file.getFileName().toString())));
            documents.put(person, documentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts person information from the directory name.
     * It assumes the directory name follows a specific format like "LastName_ID".
     *
     * @param directoryName the name of the directory containing person information
     * @return a Person object with extracted information
     */
    private Person extractPersonFromDirectoryName(String directoryName) {
        String[] parts = directoryName.split("_");
        return new Person(parts[0], parts[1]);
    }

    /**
     * Displays the content of the repository, including persons and associated documents.
     */
    public void displayRepositoryContent() {
        for (Map.Entry<Person, List<Document>> entry : documents.entrySet()) {
            Person person = entry.getKey();
            List<Document> documentList = entry.getValue();
            System.out.println("Person: " + person);
            System.out.println("Documents:");
            for (Document document : documentList) {
                System.out.println(document);
            }
            System.out.println(); // Just for formatting
        }
    }

    public Map<Person, List<Document>> getDocuments(){
        return documents;
    }
}
