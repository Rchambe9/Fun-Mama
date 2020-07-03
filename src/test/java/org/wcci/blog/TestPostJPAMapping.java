package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@DirtiesContext
public class TestPostJPAMapping {

    @Autowired
    private EntityManager entityManager;
//    tells Spring to wire automatically to tie functions together
    @Autowired
    private PostRepository postRepository;

    @Test
    public void shouldSaveAndLoadPost() {
        Post postTest = postRepository.save(new Post("Hello World"));
        long postTestId = postTest.getId();

        entityManager.flush();
        entityManager.clear();

        Optional<Post> postOptional = postRepository.findById(postTestId);
        if (postOptional.isPresent()) {
            postTest = postOptional.get();
        }

        assertEquals("Hello World",postTest.getTitle());

    }
}
