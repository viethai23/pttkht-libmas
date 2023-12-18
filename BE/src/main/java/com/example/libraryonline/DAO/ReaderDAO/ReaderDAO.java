package com.example.libraryonline.DAO.ReaderDAO;

import com.example.libraryonline.Model.User.Account;
import com.example.libraryonline.Model.User.Reader;

import java.util.List;

public interface ReaderDAO {

	List<Reader> getAllReader();
	boolean delete(int readerID);
	Reader edit(int readerID, Reader newReader);
	Reader register(Account acc);

}