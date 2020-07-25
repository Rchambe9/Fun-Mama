package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Post;
import org.wcci.blog.exceptions.ResourceNotFoundException;
import org.wcci.blog.storage.repositories.PostRepository;

import java.util.Optional;

@Service
public class PostStorage {

    PostRepository postRepo;

    public PostStorage(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Post findPostById(Long id) {
        Post retrievedPost;
        Optional<Post> postOptional = postRepo.findById(id);
        if(postOptional.isPresent()) {
            retrievedPost = postOptional.get();
            return retrievedPost;
        }
        throw new ResourceNotFoundException("Author not found.");
    }

    public void add(Post postToAdd) {
        postRepo.save(postToAdd);
    }

    public Iterable<Post> findAllPosts(){
        return postRepo.findAll();
    }
}



