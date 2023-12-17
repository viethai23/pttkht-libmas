package com.example.shoppingonline.DAO.BorrowDAO;

import com.example.shoppingonline.Model.Borrow.*;
import com.example.shoppingonline.Model.User.Reader;

import java.util.List;

public interface BorrowDAO {

	Borrow confirmBorrow(Borrow borrow);
	List<Borrow> getReaderBorrow(Reader reader);
	Shipping getShipping(int borrowId);
	Payment getPayment(int borrowId);
	Reader getReader(int borrowId);
	Cart getCart(int orderId);
}