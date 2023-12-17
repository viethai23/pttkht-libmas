package com.example.shoppingonline.DAO.ShippingDAO;

import com.example.shoppingonline.DTO.ShippingResponse;
import com.example.shoppingonline.Model.Borrow.Shipping;

public interface ShippingDAO {

	ShippingResponse calculateCost(Shipping s);

}