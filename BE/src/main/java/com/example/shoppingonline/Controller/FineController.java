package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.FineDAO.FineDAO;
import com.example.shoppingonline.DAO.ShippingDAO.ShippingDAO;
import com.example.shoppingonline.DTO.FineResponse;
import com.example.shoppingonline.DTO.ShippingResponse;
import com.example.shoppingonline.Model.Borrow.Borrow;
import com.example.shoppingonline.Model.Borrow.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fine")
@CrossOrigin
public class FineController {
    private final FineDAO fineDAO;

    @Autowired
    public FineController(FineDAO fineDAO) {
        this.fineDAO = fineDAO;
    }

    @PostMapping("/calculateCost")
    public FineResponse calculateCost(@RequestBody Borrow borrow) {
        return fineDAO.calculateCost(borrow);
    }
}
