package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Review findByPostTitle(String postTitle);
}


