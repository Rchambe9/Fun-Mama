package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.blog.entities.Hashtag;
import java.util.Optional;

@Repository
public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    Optional<Hashtag> findByTagName(String tagName);

}

