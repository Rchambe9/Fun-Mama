package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HashtagController {
    import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    public class ReviewController {

        private Hashtag review;

        public ReviewController(){
            review = new Review("Ben's Burgers", "Ben","2013", 5, "This is a good cookbook.");
        }

        @RequestMapping("/review")
        public String retrieveReview(Model model){
            model.addAttribute("reviewToDisplay", review);
            return "review-template";

        }

    }

}
