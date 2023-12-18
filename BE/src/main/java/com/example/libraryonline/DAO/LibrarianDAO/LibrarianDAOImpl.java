package com.example.libraryonline.DAO.LibrarianDAO;

import com.example.libraryonline.Model.User.Librarian;

import com.example.libraryonline.Repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianDAOImpl implements LibrarianDAO {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Override
    public List<Librarian> getAllLibrarian() {
        return librarianRepository.findAll();
    }
}