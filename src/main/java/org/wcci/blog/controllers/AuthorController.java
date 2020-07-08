package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.storage.AuthorStorage;

@Controller
public class AuthorController {
    AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage){
        this.authorStorage = authorStorage;
    }

    @GetMapping("authors/{id}")
    public String showSingleAuthor(@PathVariable Long id, Model model){
        model.addAttribute("author", authorStorage.findAuthorById(id));
        return "author-template";
    }
    @PostMapping("authors/add")
    public String addAuthor(String name){
        Author authorToAdd = new Author(name);
        authorStorage.save(authorToAdd);
        return "redirect:/";
    }
}





