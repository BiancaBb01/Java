
package com.example.demo.controller;

import com.example.demo.model.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AuthorController {

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        Author author1 = new Author();
        author1.setName("Author 1");
        author1.setBook("Book 1");

        Author author2 = new Author();
        author2.setName("Author 2");
        author2.setBook("Book 2");

        return Arrays.asList(author1, author2);
    }
}
