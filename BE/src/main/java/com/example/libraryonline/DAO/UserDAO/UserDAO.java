package com.example.libraryonline.DAO.UserDAO;

import com.example.libraryonline.Model.User.User;

public interface UserDAO {
	User login(String username, String password);
}