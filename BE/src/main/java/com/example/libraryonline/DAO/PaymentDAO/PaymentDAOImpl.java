package com.example.libraryonline.DAO.PaymentDAO;

import com.example.libraryonline.DTO.PaymentResponse;
import com.example.libraryonline.Model.Borrow.Cart;
import com.example.libraryonline.Model.Borrow.Fine;
import com.example.libraryonline.Model.Borrow.Payment;
import com.example.libraryonline.Model.Borrow.Shipping;

import com.example.libraryonline.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDAOImpl implements PaymentDAO {
	@Autowired
	private final PaymentRepository paymentRepository;


	@Autowired
	public PaymentDAOImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public PaymentResponse calculateBorrowCost(Shipping sh, Cart cart, Payment p) {
		p.setStatus("borrow");
		p.setAmount(cart.getTotal() + sh.getAmount());
		PaymentResponse pm = new PaymentResponse();
		pm.setAmount(p.getAmount());
		pm.setPaymentMethod(p.getPaymentMethod());
		pm.setPaymentDate(p.getPaymentDate());
		pm.setStatus(p.getStatus());
		return pm;
	}

	@Override
	public PaymentResponse calculateReturnCost(Shipping sh, Fine f, Payment p) {
		p.setStatus("return");
		p.setAmount(f.getAmount() + sh.getAmount());
		PaymentResponse pm = new PaymentResponse();
		pm.setAmount(p.getAmount());
		pm.setPaymentMethod(p.getPaymentMethod());
		pm.setPaymentDate(p.getPaymentDate());
		pm.setStatus(p.getStatus());
		return pm;
	}

	@Override
	public boolean processPayment(Payment p) {
		p.setStatus("successful");
		paymentRepository.save(p);
		return true;
	}
}