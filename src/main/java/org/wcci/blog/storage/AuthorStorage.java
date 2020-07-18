package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Author;
import org.wcci.blog.exceptions.ResourceNotFoundException;
import org.wcci.blog.storage.repositories.AuthorRepository;

import java.util.Optional;

@Service
public class AuthorStorage {
    private AuthorRepository authorRepo;

    public AuthorStorage (AuthorRepository authorRepo){
        this.authorRepo = authorRepo;
    }
    public Author findAuthorById(Long id) {
        Author retrievedAuthor;
        Optional<Author> authorOptional = authorRepo.findById(id);
        if(authorOptional.isPresent()) {
            retrievedAuthor = authorOptional.get();
            return retrievedAuthor;
        }
        throw new ResourceNotFoundException("Author not found.");
    }

    public void save(Author authorToSave) {
        authorRepo.save(authorToSave);
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepo.findAll();
    }
}