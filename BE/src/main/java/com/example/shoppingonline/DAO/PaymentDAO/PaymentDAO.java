package com.example.shoppingonline.DAO.PaymentDAO;

import com.example.shoppingonline.DTO.PaymentResponse;
import com.example.shoppingonline.Model.Borrow.Cart;
import com.example.shoppingonline.Model.Borrow.Fine;
import com.example.shoppingonline.Model.Borrow.Payment;
import com.example.shoppingonline.Model.Borrow.Shipping;

public interface PaymentDAO {

	PaymentResponse calculateBorrowCost(Shipping sh, Cart cart, Payment p);

	PaymentResponse calculateReturnCost(Shipping sh, Fine fine, Payment p);

	boolean processPayment(Payment p);
}