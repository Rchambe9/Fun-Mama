package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.repositories.HashtagRepository;

import java.util.Collection;

@Controller
public class HashtagController {
    private HashTagRepository hashTagRepo;
    private PostStorage postStorage;

    public HashtagController(HashtagRepository hashtagRepo, PostStorage postStorage) {
        this.hashtagRepo = hashtagRepo;
        this.postStorage = postStorage;
    }

    @GetMapping("hashtags/{hashtag}")
    public String showSingleHashtag(@PathVariable String hashtag, Model model) {
        model.addAttribute("hashtagToDisplay", hashTagRepo.findByHashtag(hashtag));
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "hashtag-template";
    }

    @GetMapping("hashtags/{hashtag}")
    public String showSingleHashtag(@PathVariable String hashtag, Model model) {
        model.addAttribute("hashtagToDisplay", hashtagRepo.findByHashtag(hashtag));
        return "hashtag-template";
    }

    @PostMapping("hashtags/add")
    public String addHashtag(String hashtag, String postTitle) {
        Post postToAddHashtag = postStorage.findPostByCategoryName(postTitle);
        Hashtag hashtagToAdd = new Hashtag(hashtag);
        hashtagRepo.save(hashtagToAdd);
        postToAddHashtag.addHashtag(hashtagToAdd);
        postStorage.save(postToAddHashtag);
        return "redirect:/posts/" + postTitle;
    }
}




