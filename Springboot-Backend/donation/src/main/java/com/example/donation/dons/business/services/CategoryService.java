package com.example.donation.dons.business.services;
import java.util.List;
import java.util.Optional;

import com.example.donation.dons.dao.entities.Category;

public interface CategoryService {
    //Read
    List<Category> getAllCategory();
    Optional<Category> getCategoryById(Long id);

    //create
    Category addCategory(Category category);

    /* //Update
    Category updateDon(Category category, Long id);
 */
    //delete
    void deleteCategoryById(Long id);
}