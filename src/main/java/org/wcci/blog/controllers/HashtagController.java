package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.HashtagStorage;
import org.wcci.blog.storage.PostStorage;

@Controller
public class HashtagController {
    private HashtagStorage hashtagStorage;
    private PostStorage postStorage;

    public HashtagController(HashtagStorage hashtagStorage, PostStorage postStorage) {
        this.hashtagStorage = hashtagStorage;
        this.postStorage = postStorage;
    }

    @GetMapping("/hashtags/{hashtagId}")
    public String showSingleHashtag(@PathVariable long hashtagId, Model model) {
        model.addAttribute("hashtag", hashtagStorage.findHashtagById(hashtagId));
        return "hashtag";
    }
    @GetMapping("/hashtags/")
    public String showAllHashtags(Model model){
        model.addAttribute("hashtags", hashtagStorage.findAllHashtags());
        return "hashtags-template";
    }
    @PostMapping("/hashtags/")
    public String addHashtag(@RequestParam String hashtagName, @RequestParam long postId){
        Hashtag hashtag = new Hashtag(hashtagName);
        hashtagStorage.save(hashtag);
        Post post = postStorage.findPostById(postId);
        post.addHashtag(hashtag);
        postStorage.add(post);
        return "redirect:/categories/"+post.getCategory().getCategoryName();
    }
}




