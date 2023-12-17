package com.example.shoppingonline.DAO.PublisherDAO;

import com.example.shoppingonline.Model.Book.Publisher;
import com.example.shoppingonline.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherDAOImpl implements PublisherDAO{
    @Autowired
    private PublisherRepository publisherRepository;
    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
}
