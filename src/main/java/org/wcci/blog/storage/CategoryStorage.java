package org.wcci.blog.storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.entities.Category;
import org.wcci.blog.exceptions.ResourceNotFoundException;
import org.wcci.blog.storage.repositories.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryStorage {
    private CategoryRepository categoryRepo;

    public CategoryStorage(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }
    public Category findCategoryByCategoryName(String categoryName) {
        Category retrievedCategory;
        Optional<Category> categoryOptional = categoryRepo.findByCategoryName(categoryName);
        if (categoryOptional.isEmpty()) {
            throw new ResourceNotFoundException("Category named " + categoryName + "not found.");

        } else {
            retrievedCategory = categoryOptional.get();
        }
        return retrievedCategory;
    }

        public Iterable<Category> findAllCategories() {return categoryRepo.findAll();}

        public void addCategory(Category category){categoryRepo.save(category);}

        public boolean categoryExists(String categoryName){return categoryRepo.findByCategoryName(categoryName).isPresent();

    }

}
