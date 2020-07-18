package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.repositories.PostRepository;

@Service
public class PostStorage {

    PostRepository postRepo;

    public PostStorage(PostRepository postRepo)  { this.postRepo = postRepo; }


    public Iterable<Post> findAllPosts() {
        return postRepo.findAll();
    }

    public void save(Post post) {
        postRepo.save(post);
    }

    public void deletePostById(long id) {
        postRepo.deleteById(id);
    }

    public Post findPostById(Long id) {
        return findPostById(id);
    }
}



