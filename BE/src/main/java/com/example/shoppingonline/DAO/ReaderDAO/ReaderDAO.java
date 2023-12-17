package com.example.shoppingonline.DAO.ReaderDAO;

import com.example.shoppingonline.Model.User.Account;
import com.example.shoppingonline.Model.User.Reader;

import java.util.List;

public interface ReaderDAO {

	List<Reader> getAllReader();
	boolean delete(int readerID);
	Reader edit(int readerID, Reader newReader);
	Reader register(Account acc);

}