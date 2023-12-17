package com.example.shoppingonline.DAO.BookDAO;

import com.example.shoppingonline.Model.Book.Category;
import com.example.shoppingonline.Model.Book.Book;

import java.util.Collections;
import java.util.List;

import com.example.shoppingonline.Repository.CategoryRepository;
import com.example.shoppingonline.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDAOImpl implements BookDAO {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Book> getListBook() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getBookByName(String name) {
		return bookRepository.findByNameContaining(name);
	}

	@Override
	public List<Book> getBookByCategory(int categoryId) {
		Category category = categoryRepository.findById(categoryId).orElse(null);
		if (category != null) {
			return bookRepository.findByCategory(category);
		}
		return Collections.emptyList();
	}

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book editBook(int bookId, Book book) {
		Book existingBook = getBook(bookId);
		if (existingBook != null) {
			existingBook.setName(book.getName());
			existingBook.setDes(book.getDes());
			existingBook.setImage(book.getImage());
			existingBook.setStockQuantity(book.getStockQuantity());
			existingBook.setPublisher(book.getPublisher());
			existingBook.setAuthor(book.getAuthor());
			return bookRepository.save(existingBook);
		}
		return null;
	}

	@Override
	public boolean deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
		return true;
	}

	private Book getBook(int bookId) {
		return bookRepository.findById(bookId).orElse(null);
	}
}