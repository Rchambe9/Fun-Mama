package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
import org.wcci.blog.entities.Hashtag;
import org.wcci.blog.entities.Post;
import org.wcci.blog.storage.repositories.AuthorRepository;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.repositories.PostRepository;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    PostRepository postRepo;
    @Autowired
    AuthorRepository authorRepo;

    @Override
    public void run(String... args) throws Exception {
        Category activitiesAndCrafts = new Category("Activities and Crafts");
        Category childDevelopment = new Category("Child Development");
        Category resourceGuide = new Category("Resource Guide");
        categoryRepo.save(activitiesAndCrafts);
        categoryRepo.save(childDevelopment);
        categoryRepo.save(resourceGuide);

        Author author1 = new Author("Robyn", "Chambers");
        Author author2 = new Author("David", "Williams");
        Author author3 = new Author("Paulette", "Nix");
//        Author author4 = new Author("LaNae", "Roberts");
//        Author author5 = new Author("Matthew", "Lewis");
//        Author author6 = new Author("DeQuan", "Freeman");
        authorRepo.save(author1);
        authorRepo.save(author2);
        authorRepo.save(author3);
//        authorRepo.save(author4);
//        authorRepo.save(author5);
//        authorRepo.save(author6);


        Post post1 = new Post("Rock, Paper, Numbers", author2, "2020-03-27", "summary");
        Post post2 = new Post("Color/Paint By Number", author1, "2020-04-02", "summary");
        Post post3 = new Post("Mindful activities for learning", author2, "2020-04-20", "summary");
        Post post4 = new Post("Painted Rainbow Rock Pets", author1, "2020-05-05", "summary");
//        Post post5 = new Post("Great at home summer activities for kids", "author3", "February 19, 2020", "", "Activities & Crafts");
//        Post post6 = new Post("How to host the ultimate kid's birthday party", "author1", "January 15, 2020", "", "Child Development");
//        Post post7 = new Post("Mindful activities for learning", "author2", "March 27, 2020", "", "Resource Guide");
////        Post post8 = new Post("How to host the ultimate kid's birthday party", "author5", "January 27, 2020", "Great ideas for a child's party.");
//        Post post9 = new Post("Make your child fall in love with reading", "author6", "May 26, 2020", "Great ideas for a child's party.");
//        Post post10 = new Post("How to host the ultimate kid's birthday party", "author4", "January 28, 2020", "Great ideas for a child's party.");
//        Post post11 = new Post("How to host the ultimate kid's birthday party", "author5", "June 13, 2020", "Great ideas for a child's party.");
//        Post post12 = new Post("How to host the ultimate kid's birthday party", "author4", "April 1, 2020", "Great ideas for a child's party.");
        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);
        postRepo.save(post4);

//        postRepo.save(post8);
//        postRepo.save(post9);
//        postRepo.save(post10);
//        postRepo.save(post11);
//        postRepo.save(post12);


    }
}


