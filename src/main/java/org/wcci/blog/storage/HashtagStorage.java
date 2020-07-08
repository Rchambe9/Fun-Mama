package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.exceptions.ResourceNotFoundException;
import org.wcci.blog.storage.repositories.HashtagRepository;

import java.util.Optional;

@Service
public class HashtagStorage {
    private HashtagRepository hashtagRepo;

    public HashtagStorage(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    public Hashtag findHashtagById(Long id) {
        Optional<Hashtag> hashtagOptional = hashtagRepo.findById(id);
        Hashtag retrievedHashtag;
        if(hashtagOptional.isEmpty()) {
            throw new ResourceNotFoundException("Hashtag not found.");
        }else{
            retrievedHashtag = hashtagOptional.get();
        }
        return retrievedHashtag;
    }

    public void save(Hashtag hashtagToSave) {hashtagRepo.save(hashtagToSave);}

    public Iterable<Hashtag> findAllHashtags() {return hashtagRepo.findAll();}
}


