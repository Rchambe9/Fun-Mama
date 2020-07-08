package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.HashtagStorage;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Controller
public class PostController {

    private PostStorage postStorage;
    private HashtagStorage hashtagStorage;
    private AuthorStorage authorStorage;

    public PostController(PostStorage postStorage, HashtagStorage headingStorage, AuthorStorage authorStorage) {
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
        this.authorStorage = authorStorage;
    }
    @GetMapping("posts/{postTitle}")
    public String showSinglePost(@PathVariable String postTitle, Model model) {
        model.addAttribute("postToDisplay", postStorage.findPostByPostTitle(postTitle));
        return "post-template";
    }
    @PostMapping("posts/add")
    public String addPost(String title, String publishDate, String category, String headingSubject, long... authorIds) {
        Heading postHeading = headingStorage.findHeadingBySubject(headingSubject);
        Collection<Author> postAuthors = Arrays.stream(authorIds)
                .mapToObj(id -> authorStorage.findAuthorById(id))
                .collect(Collectors.toSet());
        postStorage.save(new Post(title, publishDate, category, postHeading, postAuthors.toArray(Author[]::new)));
        return "redirect:/headings/" + headingSubject;
    }

    @PostMapping("posts/delete")
    public String deletePost(long postId){
        postStorage.deletePostById(postId);
        return "redirect:/";
    }
}



