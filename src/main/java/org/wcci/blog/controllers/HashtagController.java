package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Hashtag;

@Controller
    public class HashtagController {

        private Hashtag hashtag;

        public HashtagController(){
            hashtag = new Hashtag("", "","", 5, "");
        }

        @RequestMapping("/hashtag")
        public String retrieveHashtag(Model model){
            model.addAttribute("reviewToDisplay", hashtag);
            return "hashtag-template";

        }

    }


