package com.example.donation.dons.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.donation.dons.dao.entities.Category;

@RequestMapping("/category")
public interface CategoryRest {
    
    //read all dons
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory();

    //read don by id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getByIdCategory(@PathVariable Long id);
    
    //create category
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category requestMap);
    
    //delete category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id);

    /*//update category 
     //update don's category
    @PutMapping("{id}/category")
    public ResponseEntity<Don> updateDonCategory(@PathVariable Long id, @RequestParam Don category); */
}