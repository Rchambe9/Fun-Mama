package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.storage.HashtagStorage;

@Controller
public class HashtagController {
    private Hashtag hashtag;


    @RequestMapping("/hashtag")
    public String retrieveHashtag(Model model) {
        model.addAttribute("hashtagToDisplay", hashtag);
        return "hashtag";
    }


    @GetMapping("hashtags/{hashtagTagName}")
    public String showSingleHashtag(@PathVariable String hashtagTagName, Model model) {
        Long hashtagId = null;
        HashtagStorage hashtagStorage = null;
        model.addAttribute("hashtagToDisplay", hashtagStorage.findHashtagById(hashtagId));
        return "hashtag";
    }
}




