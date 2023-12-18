package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.ReturnDAO.ReturnDAO;
import com.example.libraryonline.Model.Borrow.*;
import com.example.libraryonline.Model.User.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/return")
@CrossOrigin
public class ReturnController {
    @Autowired
    private ReturnDAO returnDAO;

    @PostMapping("/confirm-return")
    public Return confirmReturn(@RequestBody Return returnn) {
        return returnDAO.confirmReturn(returnn);
    }

    @GetMapping("/reader-return")
    public List<Return> getCustomerReturn(@RequestBody Reader reader) {
        return returnDAO.getReaderReturn(reader);
    }

    @GetMapping("/borrow/{returnId}")
    public Borrow getBorrow(@PathVariable int returnId) {
        return returnDAO.getBorrow(returnId);
    }

    @GetMapping("/shipping/{returnId}")
    public Shipping getShipping(@PathVariable int returnId) {
        return returnDAO.getShipping(returnId);
    }

    @GetMapping("/payment/{returnId}")
    public Payment getPayment(@PathVariable int returnId) {
        return returnDAO.getPayment(returnId);
    }

    @GetMapping("/reader/{returnId}")
    public Reader getReader(@PathVariable int returnId) {
        return returnDAO.getReader(returnId);
    }

    @GetMapping("/fine/{returnId}")
    public Fine getFine(@PathVariable int returnId) {
        return returnDAO.getFine(returnId);
    }
}
