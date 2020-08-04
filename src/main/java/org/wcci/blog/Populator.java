package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.entities.Author;
import org.wcci.blog.entities.Category;
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

        authorRepo.save(author1);
        authorRepo.save(author2);
        authorRepo.save(author3);



        Post post1 = new Post("Rock, Paper, Numbers", author3, "2020-01-18", "/images/download (1).jpg", "Rock paper scissors is a game we all played as kids, but now you can play this game with your own kids to teach numbers and counting. What you do:  The game is played like rock, paper, scissors, only instead of rock-paper-or scissors with your two fingers, you can show a number.  On the count of three, you and your child can put up as many fingers as you want. Then ask the kid to count the number of fingers you are showing and how many they have. What kids learn: Counting", childDevelopment);
        Post post2 = new Post("Color/Paint By Number", author2, "2020-03-27", "/images/paint by number.jpg", "As a child, I remember playing connect the dots. What's great to know now is you can use this same game to teach number sequence. Here's how: Print out a few paint-by-number templates, grab some crayons or paint to use for coloring. Pick an easy model, an image with fewer but larger sections that a child can paint easily. Sit with the child and tell him what he needs to do. Show him by coloring a numbered part of the template.  Ask the child to pick a number next and check for the corresponding color on the sheet. Color the template fully.  What they will learn: Number recognition and one-to-one correspondence", childDevelopment);
        Post post3 = new Post("Paper Plate Flowers", author1, "2020-05-20", "/images/PaperPlateFlowers.jpg", "These paper plate flowers are a great way to celebrate summertime fun. Supplies needed: - Paper plates, dessert or regular dinner size - Craft paint in different colors, - Large popsicle sticks, - Green paper for leaves and coordinating colors to match paint colors, - Sequins, buttons and glue. What to do: Start by painting your paper plates different colors.  Once they are dry, flip them over and hand draw some flower petals. Cut around the petals to make different flowers. Paint your large popsicle sticks green and add green paper leaves to either side. Glue to the backside of your painted plates. Cut out coordinating colored circles to add to the center of your flowers.  Add some colored sequins or buttons to the center of your flowers and WALLA!.", activitiesAndCrafts);
        Post post4 = new Post("Painted Rainbow Rock Pets", author1, "2020-06-13", "/images/RainbowRocks.jpg", "This is a fun, low cost activity your kids will love! Supplies needed:- Some rocks, either crafting river rocks or rocks you find outdoors. - Craft paint or outdoor paint if you plan to use these rocks outside.- Googly eyes in a variety of sizes.- Paint brushes, hot glue or some kind of adhesive.- Black Sharpie marker. What to do:  Start by painting your rocks different colors.  For dark rocks, paint them with a coat of white paint before adding your color layer.  Allow the rocks to fully dry.  Then use the hot glue gun attach the googly eyes. Use the black sharpie marker to draw on your different smiley faces to create some fun expressions!", activitiesAndCrafts);

        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);
        postRepo.save(post4);




    }
}


