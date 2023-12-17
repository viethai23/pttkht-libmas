package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.LibrarianDAO.LibrarianDAO;
import com.example.shoppingonline.Model.User.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarian")
@CrossOrigin
public class LibrarianController {

    @Autowired
    private LibrarianDAO librarianDAO;

    @GetMapping
    public List<Librarian> getAllLibrarian() {
        return librarianDAO.getAllLibrarian();
    }

}
