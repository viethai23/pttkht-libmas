package com.example.shoppingonline.DAO.ShippingDAO;

import com.example.shoppingonline.DTO.ShippingResponse;
import com.example.shoppingonline.Model.Borrow.Shipping;

import com.example.shoppingonline.Repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
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