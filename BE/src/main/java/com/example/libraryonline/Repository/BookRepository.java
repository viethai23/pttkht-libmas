package com.example.libraryonline.Repository;

import com.example.libraryonline.Model.Book.Category;
import com.example.libraryonline.Model.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByCategory(Category category);
    List<Book> findByNameContaining(String name);
}
