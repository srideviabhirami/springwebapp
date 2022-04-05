package com.example.springwebapp.controller;

import com.example.springwebapp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authors/list";
    }


}

/*
    Controller annotation is a specialized @Component, that tells Spring that inside it will find @RequestMapping handlers. Those handlers can be used either for returning Json, HTML or for uploading files.
 */