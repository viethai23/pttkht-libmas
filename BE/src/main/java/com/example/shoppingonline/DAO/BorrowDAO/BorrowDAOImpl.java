package com.example.shoppingonline.DAO.BorrowDAO;

import com.example.shoppingonline.Model.Borrow.*;
import com.example.shoppingonline.Model.User.Reader;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.shoppingonline.Repository.CartRepository;
import com.example.shoppingonline.Repository.BorrowRepository;
import org.springframework.stereotype.Service;

@Service
public class BorrowDAOImpl implements BorrowDAO {

	private BorrowRepository borrowRepository;

	private CartRepository cartRepository;

	public BorrowDAOImpl(BorrowRepository borrowRepository, CartRepository cartRepository) {
		this.borrowRepository = borrowRepository;
		this.cartRepository = cartRepository;
	}

	@Override
	public Borrow confirmBorrow(Borrow borrow) {
		LocalDateTime localDateTime = LocalDateTime.now();
		Date curentTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		borrow.setBorrowDate(curentTime);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curentTime);
		int daysToAdd = borrow.getBorrowDay();
		calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
		Date resultDate = calendar.getTime();

		borrow.setDue(resultDate);
		Cart cart = cartRepository.findById(borrow.getCart().getId()).orElse(null);
		if(cart != null) {
			cart.setStatus("borrowed");
			cartRepository.save(cart);
		}
		borrow.setStatus("borrowed");
		return borrowRepository.save(borrow);
	}

	@Override
	public List<Borrow> getReaderBorrow(Reader reader) {
		return borrowRepository.findByReader(reader);
	}
	
	public Borrow getBorrow(int id) {
		return borrowRepository.findById(id).orElse(null);
	}
	
	@Override
	public Shipping getShipping(int borrowId) {
		return getBorrow(borrowId).getShipping();
	}

	@Override
	public Payment getPayment(int borrowId) {
		return getBorrow(borrowId).getPayment();
	}

	@Override
	public Reader getReader(int borrowId) {
		return getBorrow(borrowId).getReader();
	}

	@Override
	public Cart getCart(int borrowId) {
		return getBorrow(borrowId).getCart();
	}
}