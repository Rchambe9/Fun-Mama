package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.exceptions.ResourceNotFoundException;
import org.wcci.blog.storage.AuthorStorage;

@Controller
public class AuthorController {
    private AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage){
        this.authorStorage = authorStorage;
    }

    public AuthorStorage getAuthorStorage() {
        return authorStorage;
    }

    @GetMapping("/author/{id}")
    public String showSingleAuthor(@PathVariable Long id, Model model)
        throws ResourceNotFoundException {

        Author author = authorStorage.findAuthorById(id);
        if (author == null){
            throw new ResourceNotFoundException("Author not found");
        }
       model.addAttribute("author", author);
        return "author-template";
    }
    @PostMapping("/author/add")
    public String addAuthor(String firstName, String lastName){
        Author authorToAdd = new Author(firstName, lastName);
        authorStorage.save(authorToAdd);
        return "redirect:/";
    }
    @GetMapping("authors")
    public String showAllAuthors(Model model){
        model.addAttribute("authors",authorStorage.findAllAuthors());
        return "authors-template";
    }
}





