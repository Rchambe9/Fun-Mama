package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;
import org.wcci.blog.storage.repositories.HashtagRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class PostController {

    private PostStorage postStorage;
    private CategoryStorage categoryStorage;
    private AuthorStorage authorStorage;
    private HashtagRepository hashtagRepo;

    public PostController(PostStorage postStorage, CategoryStorage categoryStorage, AuthorStorage authorStorage, HashtagRepository hashtagRepo) {
        this.postStorage = postStorage;
        this.categoryStorage = categoryStorage;
        this.authorStorage = authorStorage;
        this.hashtagRepo = hashtagRepo;
    }

    @RequestMapping("/posts/{id}")
    public String displayPost(@PathVariable Long id, Model model){
        Post retrievedPost = postStorage.findPostById(id);
        model.addAttribute("post", retrievedPost);
        return "post-view";
    }
//    @GetMapping("posts/{postTitle}")
//    public String showSinglePost(@PathVariable String postTitle, Model model) {
//        Long postId = null;
//        model.addAttribute("postToDisplay", postStorage.findPostById(postId));
//        return "post-template";
//    }

//    @PostMapping("posts/add")
//    public String addPost(String title, String Category, String publishDate, String body, long... authorIds) {
//        String categoryName = null;
//        org.wcci.blog.entities.Category postCategory = categoryStorage.findCategoryByCategoryName(categoryName);
//        Collection<Author> postAuthors = Arrays.stream(authorIds)
//                .mapToObj(id->authorStorage.findAuthorById(id))
//                .collect(Collectors.toSet());
//        postStorage.save(new Post(title, authorIds, Category, publishDate));
//        return "redirect:/categories/"+categoryName;

//    @PostMapping("/post/{id}/add-hashtag")
//    public String addHashtagToPost(@RequestParam String String tagName;
//        tagName, @PathVariable Long id) {
//        Hashtag hashtagToAddToPost;
//        Optional<Hashtag> hashTagToAddOption = hashtagRepo.findByTagName(tagName);
//        if (hashTagToAddOption.isEmpty()){
//            hashtagToAddToPost = new Hashtag(tagName);
//            hashtagRepo.save(hashtagToAddToPost);
//        }
//        else {
//            hashtagToAddToPost = hashTagToAddOption.get();
//        }
//        Post postToAddHashtagTo = postStorage.findPostById(id);
//        postToAddHashtagTo.addHashtag(hashtagToAddToPost);
//        postStorage.save(postToAddHashtagTo);
//        return "redirect:/posts/" + id;





}



