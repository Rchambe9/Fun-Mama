package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Review;
import org.wcci.blog.ReviewRepository;

@Service
public class ReviewStorage {

    ReviewRepository reviewRepo;

    public ReviewStorage(ReviewRepository reviewRepo){
        this.reviewRepo = reviewRepo;
    }
    public Review findReviewByPostTitle(String postTitle) {
        return reviewRepo.findByPostTitle(postTitle);
    }
    public Iterable<Review> findAllReviews(){
        return reviewRepo.findAll();
    }

    public void save(Review reviewToAddHashtag) {
        reviewRepo.save(reviewToAddHashtag);
    }

    public void deleteReviewById(long reviewId) {
        reviewRepo.deleteById(reviewId);
    }
}



