package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.repositories.PostRepository;

@Service
public class PostStorage {

    PostRepository postRepo;

    public PostStorage(PostRepository postRepo)  { this.postRepo = postRepo; }

    public Post findPostByTitle(String postTitle) {
        return postRepo.findByTitle(postTitle);
    }

    public Iterable<Post> findAllBooks() {
        return postRepo.findAll();
    }

    public void save(Post post) {
        postRepo.save(post);
    }

    public void deletePostById(long postId) {
        postRepo.deleteById(postId);
    }
}



