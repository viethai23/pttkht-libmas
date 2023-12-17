package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.BookDAO.BookDAO;
import com.example.shoppingonline.Model.Book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @GetMapping
    public List<Book> getAllBook() {
        return bookDAO.getListBook();
    }

    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam String keyword) {
        return bookDAO.getBookByName(keyword);
    }

    @GetMapping("/category/{categoryId}")
    public List<Book> getBookByCategory(@PathVariable int categoryId) {
        return bookDAO.getBookByCategory(categoryId);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookDAO.addBook(book);
    }

    @DeleteMapping("/delete/{bookId}")
    public boolean deleteBook(@PathVariable int bookId) {
        return bookDAO.deleteBook(bookId);
    }

    @PutMapping("/add/{bookId}")
    public Book editBook(@PathVariable int bookId, @RequestBody Book book) {
        return bookDAO.editBook(bookId, book);
    }
}
