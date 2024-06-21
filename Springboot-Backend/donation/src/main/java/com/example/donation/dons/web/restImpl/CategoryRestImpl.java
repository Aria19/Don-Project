package com.example.donation.dons.web.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.donation.dons.business.services.CategoryService;
import com.example.donation.dons.dao.entities.Category;
import com.example.donation.dons.web.rest.CategoryRest;

@RestController
public class CategoryRestImpl implements CategoryRest {
    @Autowired
    CategoryService categoryService;

    //create
    @Override
    public ResponseEntity<Category> createCategory(Category requestMap) {
        Category createdCategory = categoryService.addCategory(requestMap);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    //delete
    @Override
    public ResponseEntity<Void> deleteCategory(Long id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Read all
    @Override
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.getAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //Read by id
    @Override
    public ResponseEntity<Category> getByIdCategory(Long id) {
        Category category = categoryService.getCategoryById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        return new ResponseEntity<>(category, HttpStatus.OK);
        
    }
}