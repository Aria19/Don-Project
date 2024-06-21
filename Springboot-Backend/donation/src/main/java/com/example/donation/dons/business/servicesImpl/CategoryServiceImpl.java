package com.example.donation.dons.business.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.donation.dons.business.services.CategoryService;
import com.example.donation.dons.dao.entities.Category;
import com.example.donation.dons.dao.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    //Read all
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    //Read by id
    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    //create
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    //delete by id
    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
    
}