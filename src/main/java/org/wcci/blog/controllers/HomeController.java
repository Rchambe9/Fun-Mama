package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.HashtagStorage;

@Controller
public class HomeController {

    private final HashtagStorage headingStorage;
    private final AuthorStorage authorStorage;

    public HomeController(HashtagStorage headingStorage, AuthorStorage authorStorage) {
        this.headingStorage = headingStorage;
        this.authorStorage = authorStorage;
    }

    @RequestMapping({"", "/"})
    public String routeToHeadings(Model model) {
        model.addAttribute("headings", headingStorage.findAllHeadings());
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "home-template";
    }
}
