package org.wcci.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.entities.Category;
import org.wcci.blog.storage.AuthorStorage;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.PostStorage;

@Controller
public class CategoryController {

    private final CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage, AuthorStorage authorStorage, PostStorage postStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping({"/categories", "/", ""})
    public String displayCategories(Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "category-view";
    }

    @GetMapping("/categories/{categoryName}")
    public String displaySingleCategory(@PathVariable String categoryName, Model model) {
        Category retrievedCategory = categoryStorage.findCategoryByCategoryName(categoryName);
        model.addAttribute("category", retrievedCategory);

        return categoryName;
    }
}

