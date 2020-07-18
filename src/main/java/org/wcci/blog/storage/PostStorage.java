package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.repositories.PostRepository;

@Service
public class PostStorage {

    PostRepository postRepo;

    public PostStorage(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Post findPostById(Long id) {
        return findPostById(id);
    }

}
//    public Iterable<Post> findPostById(Long id) {
//        return postRepo.findByPostId(id);
//    }
//
//    @Override
//    public void add(Post postToAdd) {
//        postRepo.save(postToAdd);
//    }

//    public Iterable<Post> findAllPosts{
//        return postRepo.findAll();


//    public Post findPostById(Long id) {
//    }

//    public void save(Post postToAddHashtagTo) {


//    @Override
//    public void deleteById(long id) {
//        postRepo.deleteById(id);
//    }
//
