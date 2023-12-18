package com.example.libraryonline.DAO.PaymentDAO;

import com.example.libraryonline.DTO.PaymentResponse;
import com.example.libraryonline.Model.Borrow.Cart;
import com.example.libraryonline.Model.Borrow.Fine;
import com.example.libraryonline.Model.Borrow.Payment;
import com.example.libraryonline.Model.Borrow.Shipping;

public interface PaymentDAO {

	PaymentResponse calculateBorrowCost(Shipping sh, Cart cart, Payment p);

	PaymentResponse calculateReturnCost(Shipping sh, Fine fine, Payment p);

	boolean processPayment(Payment p);
}