package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.FineDAO.FineDAO;
import com.example.libraryonline.DTO.FineResponse;
import com.example.libraryonline.Model.Borrow.Borrow;
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
