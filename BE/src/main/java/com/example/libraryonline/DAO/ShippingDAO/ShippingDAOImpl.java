package com.example.libraryonline.DAO.ShippingDAO;

import com.example.libraryonline.DTO.ShippingResponse;
import com.example.libraryonline.Model.Borrow.Shipping;

import org.springframework.stereotype.Service;

@Service
public class ShippingDAOImpl implements ShippingDAO {

	@Override
	public ShippingResponse calculateCost(Shipping s) {
		s.setAmount(0);
		s.setStatus("wait");
		ShippingResponse sp = new ShippingResponse();
		sp.setAmount(s.getAmount());
		sp.setStatus(s.getStatus());
		sp.setMethod(s.getMethod());
		sp.setShippingAddress(s.getShippingAddress());
		sp.setReceiverPhone(s.getReceiverPhone());
		return sp;
	}
}