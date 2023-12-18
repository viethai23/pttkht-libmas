package com.example.libraryonline.DAO.CategoryDAO;

import com.example.libraryonline.Model.Book.Category;

import java.util.List;

public interface CategoryDAO {

	Category addCategory(Category c);

	Category getCategory(int categoryId);

	boolean deleteCategory(int categoryId);

	List<Category> getListCategory();

	Category editCategory(int categoryId, Category newCategory);

}