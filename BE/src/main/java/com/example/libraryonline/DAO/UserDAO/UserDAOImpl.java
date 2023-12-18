package com.example.libraryonline.DAO.UserDAO;

import com.example.libraryonline.Model.User.User;
import com.example.libraryonline.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User login(String username, String password) {
		Optional<User> userOptional = userRepository.findByAccount_Username(username);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			if(user.getAccount().getPassword().equals(password))
				return user;
		}

		return null;
	}
}