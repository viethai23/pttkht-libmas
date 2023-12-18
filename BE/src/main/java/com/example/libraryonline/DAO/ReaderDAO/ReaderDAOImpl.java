package com.example.libraryonline.DAO.ReaderDAO;

import com.example.libraryonline.Model.User.Account;
import com.example.libraryonline.Model.User.Reader;

import com.example.libraryonline.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderDAOImpl implements ReaderDAO {

	@Autowired
	private ReaderRepository readerRepository;

	@Override
	public List<Reader> getAllReader() {
		return readerRepository.findAll();
	}

	@Override
	public boolean delete(int readerId) {
		Optional<Reader> readerOptional = readerRepository.findById(readerId);
		if (readerOptional.isPresent()) {
			readerRepository.delete(readerOptional.get());
			return true;
		}
		return false;
	}

	@Override
	public Reader edit(int readerId, Reader newReader) {
		Optional<Reader> readerOptional = readerRepository.findById(readerId);
		if (readerOptional.isPresent()) {
			Reader existingReader = readerOptional.get();
			existingReader.setAvatar(newReader.getAvatar());
			existingReader.setPhone(newReader.getPhone());
			existingReader.setNickname(newReader.getNickname());
			existingReader.setAccount(newReader.getAccount());
			existingReader.setAddress(newReader.getAddress());
			existingReader.setGender(newReader.getGender());
			existingReader.setName(newReader.getName());
			existingReader.setDob(newReader.getDob());
			readerRepository.save(existingReader);
			return existingReader;
		}
		return null;
	}

	@Override
	public Reader register(Account acc) {
		Reader newReader = new Reader();
		newReader.setAccount(acc);
		newReader.setAvatar("https://static.vecteezy.com/system/resources/previews/009/292/244/original/default-avatar-icon-of-social-media-user-vector.jpg");
		newReader.setPhone("");
		newReader.setNickname("reader");
		newReader.setRole("reader");
		Reader registeredReader = readerRepository.save(newReader);

		return registeredReader;
	}
}