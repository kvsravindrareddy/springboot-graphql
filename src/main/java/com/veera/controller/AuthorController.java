package com.veera.controller;

import com.veera.model.Author;
import com.veera.repo.AuthorRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }

}