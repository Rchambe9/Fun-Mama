package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Heading;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.HeadingStorage;

@Controller
public class HeadingController {
    private HeadingStorage headingStorage;
    private AuthorStorage authorStorage;

    public HeadingController(HeadingStorage headingStorage, AuthorStorage authorStorage) {
        this.headingStorage = headingStorage;
        this.authorStorage = authorStorage;
    }

    @GetMapping("headings/{headingSubject}")
    public String showSingleHeading(@PathVariable String headingSubject, Model model) {
        model.addAttribute("heading", headingStorage.findHeadingBySubject(headingSubject));
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "heading-template";
    }

    @GetMapping("headings")
    public String showAllHeadings(Model model){
        model.addAttribute("headings", headingStorage.findAllHeading());
        return "home-template";
    }
    @PostMapping("/headings/add")
    public String addNewHeading(String subject, String description) {
        if(headingStorage.headingExists(subject)){
            return "redirect:/";
        }
        Heading headingToAdd = new Heading(subject, description);
        headingStorage.addHeading(headingToAdd);
        return "redirect:/";
    }
}




