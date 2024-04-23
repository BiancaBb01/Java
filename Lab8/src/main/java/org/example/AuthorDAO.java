package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    public String author;
    private Connection connection;

    public AuthorDAO() {
        try {
            connection = DatabaseManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAuthor(String authorName) {
        String query = "INSERT INTO autor (nume) VALUES (?)";
        try {PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, authorName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> getAllAuthors() {
        List<String> authors = new ArrayList<>();
        String query = "SELECT * FROM autor";
        try {PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String authorName = resultSet.getString("nume");
                authors.add(authorName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }



}
