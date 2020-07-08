package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.HashtagStorage;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
public class PostController {

    PostStorage postStorage;

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }
    @GetMapping("posts/{id}")
    public String showSinglePost(@PathVariable String id, Model model) {
        model.addAttribute("postToDisplay", postStorage.findPostById(id));
        return "post-template";
    }
    @PostMapping("posts/add")
    public String addPost(String title, String publishDate, String category, String body, String hashtag, long... authorIds) {
        Collection<Author> postAuthors = Arrays.stream(authorIds)
//                .mapToObj(id -> authorStorage.findAuthorById(id))
//                .collect(Collectors.toSet());
        postStorage.save(new Post(title, publishDate, category, body, postAuthors.toArray(Author[]::new)));
        return "redirect:/hashtag/" + hashtag;
    }

    @PostMapping("posts/delete")
    public String deletePost(long Id){
        postStorage.deletePostById(Id);
        return "redirect:/";
    }
}



