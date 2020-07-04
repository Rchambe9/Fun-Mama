package org.wcci.blog.storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.entities.Heading;

import java.util.Optional;

public interface HeadingRepository extends CrudRepository<Heading, Long> {
 Optional<Heading> findBySubject(String headingSubject);
}
