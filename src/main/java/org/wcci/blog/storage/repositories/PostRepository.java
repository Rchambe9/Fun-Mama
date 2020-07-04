package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
}
