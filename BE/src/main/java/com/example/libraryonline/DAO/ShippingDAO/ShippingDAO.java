package com.example.libraryonline.DAO.ShippingDAO;

import com.example.libraryonline.DTO.ShippingResponse;
import com.example.libraryonline.Model.Borrow.Shipping;

public interface ShippingDAO {

	ShippingResponse calculateCost(Shipping s);

}