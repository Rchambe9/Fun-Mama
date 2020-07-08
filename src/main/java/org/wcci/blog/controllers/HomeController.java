package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.HashtagStorage;

@Controller
public class HomeController {

    private final HashtagStorage hashtagStorage;
    private final AuthorStorage authorStorage;

    public HomeController(HashtagStorage hashtagStorage, AuthorStorage authorStorage) {
        this.hashtagStorage = hashtagStorage;
        this.authorStorage = authorStorage;
    }

    @RequestMapping({"", "/"})
    public String routeToHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.findAllHashtags());
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "home-template";
    }
}
