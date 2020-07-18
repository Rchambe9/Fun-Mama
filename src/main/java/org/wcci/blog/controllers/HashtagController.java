package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Hashtag;

@Controller
public class HashtagController {
    private Hashtag hashtag;


//    public HashtagController() {
//        hashtag = new Hashtag("", "", "", "", "");
//    }

    @RequestMapping("/hashtag")
    public String retrieveHashtag(Model model) {
        model.addAttribute("hashtagToDisplay", hashtag);
        return "hashtag-template";
    }
}

//    @GetMapping("hashtags/{hashtag}")
//    public String showSingleHashtag(@PathVariable String hashtag, Model model) {
//        model.addAttribute("hashtagToDisplay", hashtagRepo.findByHashtag(hashtag));
//        return "hashtag-template";
//    }
//
//    @PostMapping("hashtags/add")
//    public String addHashtag(String hashtag, String postTitle) {
//        Post postToAddHashtag = postStorage.findPostByCategoryName(postTitle);
//        Hashtag hashtagToAdd = new Hashtag(hashtag);
//        hashtagRepo.save(hashtagToAdd);
//        postToAddHashtag.addHashtag(hashtagToAdd);
//        postStorage.save(postToAddHashtag);
//        return "redirect:/posts/" + postTitle;
//    }
//}
//
//


