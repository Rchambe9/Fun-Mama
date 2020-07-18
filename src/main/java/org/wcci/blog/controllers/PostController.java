package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repositories.HashtagRepository;


@Controller
public class PostController {

    private final PostStorage postStorage;
    private HashtagRepository hashtagRepo;

    public PostController(PostStorage postStorage, HashtagRepository hashtagRepo) {
        this.postStorage = postStorage;
        this.hashtagRepo = hashtagRepo;
    }
    @RequestMapping("/posts/{id}")
    public String displayPost(@PathVariable Long id, Model model){
        Post retrievePost = postStorage.findPostById(id);
        model.addAttribute("post", retrievePost);
        return post-view;
    }
    @GetMapping("posts/{id}")
    public String showSinglePost(@PathVariable String id, Model model) {
//        model.addAttribute("postToDisplay", postStorage.findPostById(id));
        return "post-template";
    }
    @PostMapping("posts/add")
    public String addPost(String title, String publishDate, String category, String body, String hashtag, long... authorIds) {
//        Author postAuthors = Arrays.stream(authorIds)
//                .mapToObj(id -> authorStorage.findAuthorById(id))
//                .collect(Collectors.toSet());
//        postStorage.save(new Post(title, publishDate, category, body, postAuthors.toArray(Author[]::new)));
//        return "redirect:/hashtag/" + hashtag;
        return null;
    }

    @PostMapping("posts/delete")
    public String deletePost(long Id){
        postStorage.deletePostById(Id);
        return "redirect:/";
    }
}



