package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Heading;
import org.wcci.blog.exceptions.ResourceNotFoundException;
import org.wcci.blog.storage.repositories.HeadingRepository;

import java.util.Optional;

@Service
public class HeadingStorage {
    private HeadingRepository headingRepo;

    public HeadingStorage(HeadingRepository headingRepo) {
        this.headingRepo = headingRepo;
    }

    public Heading findHeadingBySubject(String headingSubject) {
        Heading retrievedHeading;
        Optional<Heading> headingOptional = headingRepo.findBySubject(headingSubject);
        if (headingOptional.isEmpty()) {
            throw new ResourceNotFoundException("Heading named " + headingSubject + " not found.");
        } else {
            retrievedHeading = headingOptional.get();
        }
        return retrievedHeading;
    }

    public Iterable<Heading> findAllHeading() {
        return headingRepo.findAll();
    }

    public void addHeading(Heading heading) {
        headingRepo.save(heading);
    }

    public boolean headingExists(String headingSubject)  {
        return headingRepo.findBySubject(headingSubject).isPresent();
    }
}
