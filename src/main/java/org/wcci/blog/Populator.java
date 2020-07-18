//package org.wcci.blog;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.wcci.blog.entities.Author;
//import org.wcci.blog.entities.Category;
//import org.wcci.blog.entities.Hashtag;
//import org.wcci.blog.entities.Post;
//import org.wcci.blog.storage.repositories.AuthorRepository;
//import org.wcci.blog.storage.repositories.PostRepository;
//
//@Component
//public class Populator {
//    @Autowired
//    HeadingRepository headingRepo;
//    @Autowired
//    PostRepository postRepo;
//    @Autowired
//    AuthorRepository authorRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Hashtag fun = new Hashtag("Adventure", "Adventure provides opportunity for personal growth, development, " +
//                "learning, and self discovery.");
//        Category parenting = new Category("Parenting", " Gain skills for discipline, boundaries & even self-care! ");
//        Category development = new Category("Development", "Children learn in a variety of ways.");
//        Category spotlight = new Category("Spotlight", "Browse through tons of educational and recreational resources");
//        headingRepo.save(adventure);
//        headingRepo.save(parenting);
//        headingRepo.save(development);
//        headingRepo.save(spotlight);
//
//        Author author1 = new Author("Robyn", "Chambers");
//        Author author2 = new Author("David", "Williams");
//        Author author3 = new Author("Paulette", "Nix");
//        Author author4 = new Author("LaNae", "Roberts");
//        Author author5 = new Author("Matthew", "Lewis");
//        Author author6 = new Author("DeQuan", "Freeman");
//        authorRepo.save(author1);
//        authorRepo.save(author2);
//        authorRepo.save(author3);
//        authorRepo.save(author4);
//        authorRepo.save(author5);
//        authorRepo.save(author6);
//
//
//        Post post1 = new Post("How to host the ultimate kid's birthday party", "January 14, 2020", "adventure", "author5", "author3" );
//        Post post2 = new Post("How to make egg carton butterflies", "February 20, 2020", "development",  "author1");
//        Post post3 = new Post("Fun learning activities for kids", "December 26, 2019", "parenting", "author3");
//        Post post4 = new Post("How to host the ultimate kid's birthday party", "author4", "April 20, 2020", "Great ideas for a child's party.");
//        Post post5 = new Post("Great at home summer activities for kids", "author3", "February 19, 2020", "Great ideas for a child's party.");
//        Post post6 = new Post("How to host the ultimate kid's birthday party", "author1", "January 15, 2020", "Great ideas for a child's party.");
//        Post post7 = new Post("Mindful activities for learning", "author2", "March 27, 2020", "Great ideas for a child's party.");
//        Post post8 = new Post("How to host the ultimate kid's birthday party", "author5", "January 27, 2020", "Great ideas for a child's party.");
//        Post post9 = new Post("Make your child fall in love with reading", "author6", "May 26, 2020", "Great ideas for a child's party.");
//        Post post10 = new Post("How to host the ultimate kid's birthday party", "author4", "January 28, 2020", "Great ideas for a child's party.");
//        Post post11 = new Post("How to host the ultimate kid's birthday party", "author5", "June 13, 2020", "Great ideas for a child's party.");
//        Post post12 = new Post("How to host the ultimate kid's birthday party", "author4", "April 1, 2020", "Great ideas for a child's party.");
//        postRepo.save(post1);
//        postRepo.save(post2);
//        postRepo.save(post3);
//        postRepo.save(post4);
//        postRepo.save(post5);
//        postRepo.save(post6);
//        postRepo.save(post7);
//        postRepo.save(post8);
//        postRepo.save(post9);
//        postRepo.save(post10);
//        postRepo.save(post11);
//        postRepo.save(post12);
//
//
//    }
//}
//
//
