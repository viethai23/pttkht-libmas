package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.AuthorDAO.AuthorDAO;
import com.example.libraryonline.Model.Book.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
@CrossOrigin
public class AuthorController {

    @Autowired
    private AuthorDAO authorDAO;

    @GetMapping
    public List<Author> getAllCustomers() {
        return authorDAO.getAllAuthor();
    }
}
