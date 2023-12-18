package com.example.libraryonline.DAO.BookDAO;

import com.example.libraryonline.Model.Book.Book;

import java.util.List;

public interface BookDAO {
	List<Book> getListBook();

	List<Book> getBookByName(String s);

	List<Book> getBookByCategory(int categoryId);

	Book addBook(Book book);
	Book editBook(int bookId, Book book);
	boolean deleteBook(int bookId);
}