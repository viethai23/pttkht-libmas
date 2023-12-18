package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.UserDAO.UserDAO;
import com.example.libraryonline.Model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userDAO.login(username, password);
    }
}