package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.PublisherDAO.PublisherDAO;
import com.example.libraryonline.Model.Book.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@CrossOrigin
public class PublisherController {
    @Autowired
    private PublisherDAO publisherDAO;

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherDAO.getAllPublishers();
    }
}
