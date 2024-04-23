package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseManager.getConnection();

        if (connection != null) {
            System.out.println("Conexiunea la baza de date a fost realizată cu succes.");
        } else {
            System.out.println("Eroare la conectarea la baza de date.");
        }

        AuthorDAO authorDAO = new AuthorDAO();
        authorDAO.addAuthor("Ion Creanga");
        authorDAO.addAuthor("Liviu Rebreanu");
        authorDAO.addAuthor("George Coșbuc");
        authorDAO.addAuthor("Marin Preda");
        authorDAO.addAuthor("Tudor Arghezi");


        List<String> authors = authorDAO.getAllAuthors();
        System.out.println("Autorii din baza de date:");
        for (String author : authors) {
            System.out.println(author);
        }
        // Închidem conexiunea cu baza de date
        try {
            DatabaseManager.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }
