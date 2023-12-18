package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.ShippingDAO.ShippingDAO;
import com.example.libraryonline.DTO.ShippingResponse;
import com.example.libraryonline.Model.Borrow.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Shipping")
@CrossOrigin
public class ShippingController {

    private final ShippingDAO shippingDAO;

    @Autowired
    public ShippingController(ShippingDAO shippingDAO) {
        this.shippingDAO = shippingDAO;
    }

    @PostMapping("/calculateCost")
    public ShippingResponse calculateCost(@RequestBody Shipping shipping) {
        return shippingDAO.calculateCost(shipping);
    }
}
