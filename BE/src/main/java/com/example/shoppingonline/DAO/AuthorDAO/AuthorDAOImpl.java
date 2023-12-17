package com.example.shoppingonline.DAO.AuthorDAO;

import com.example.shoppingonline.Model.Book.Author;
import com.example.shoppingonline.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorDAOImpl implements AuthorDAO {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }
}
