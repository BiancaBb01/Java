package Compulsory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DocumentRepository {
    private final File masterDirectory;
    private Map<Person, List<Document>> documents;

    public DocumentRepository(String masterDirectoryPath) {
        this.masterDirectory = new File(masterDirectoryPath);
        this.documents = new HashMap<>();

        // Se verifica daca calea directorului este corecta
        if (!masterDirectory.exists() || !masterDirectory.isDirectory()) {
            throw new IllegalArgumentException("Invalid master directory path: " + masterDirectoryPath);
        }

        loadDocuments();
    }

    private void loadDocuments() {
        File[] files = masterDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    List<Document> documentList = new ArrayList<>();
                    String title = file.getName();
                    String[] parts = title.split("_");
                    // Se verifica daca formatul numelui directorului este corect
                    if (parts.length < 2) {
                        throw new IllegalStateException("Invalid directory name format: " + title);
                    }
                    // Setez implicit numele autorului
                    Person employer = new Person(parts[0], parts[1]); // parts[0] is the ID, parts[1] is the name

                    // Iterez in fisier si adaug documentele
                    File[] employerFiles = file.listFiles();
                    if (employerFiles != null) {
                        for (File employerFile : employerFiles) {
                            if (employerFile.isFile()) { // Verify if it's a file
                                Document document = new Document(employerFile.getName());
                                documentList.add(document);
                            }
                        }
                    }

                    // Adaug documentele in doc
                    documents.put(employer, documentList);
                }
            }
        }
    }

    public void displayRepositoryContent() {
        System.out.println("Documents in repository:");
        for (Map.Entry<Person, List<Document>> entry : documents.entrySet()) {
            System.out.println("Person: " + entry.getKey().name());
            for (Document document : entry.getValue()) {
                System.out.println("File: " + document.name());
            }
        }
    }

    @Override
    public String toString() {
        return "DocumentRepository{" +
                "masterDirectory=" + masterDirectory +
                ", documents=" + documents +
                '}';
    }
}
