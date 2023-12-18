package com.example.libraryonline.DAO.CategoryDAO;

import com.example.libraryonline.Model.Book.Category;

import java.util.List;

import com.example.libraryonline.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category c) {
		return categoryRepository.save(c);
	}

	@Override
	public Category getCategory(int categoryId) {
		return categoryRepository.findById(categoryId).orElse(null);
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		Category category = getCategory(categoryId);
		if (category != null) {
			categoryRepository.delete(category);
			return true;
		}
		return false;
	}

	@Override
	public List<Category> getListCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category editCategory(int categoryId, Category newCategory) {
		Category category = getCategory(categoryId);
		if (category != null) {
			category.setName(newCategory.getName());
			category.setDescription(newCategory.getDescription());
			return categoryRepository.save(category);
		}
		return null;
	}
}