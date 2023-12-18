package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.BorrowDAO.BorrowDAO;
import com.example.libraryonline.Model.Borrow.*;
import com.example.libraryonline.Model.User.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@CrossOrigin
public class BorrowController {

    @Autowired
    private BorrowDAO borrowDAO;

    @PostMapping("/confirm-borrow")
    public Borrow confirmOrder(@RequestBody Borrow borrow) {
        return borrowDAO.confirmBorrow(borrow);
    }

    @GetMapping("/reader-borrow")
    public List<Borrow> getCustomerBorrow(@RequestBody Reader reader) {
        return borrowDAO.getReaderBorrow(reader);
    }

    @GetMapping("/shipping/{borrowId}")
    public Shipping getShipping(@PathVariable int borrowId) {
        return borrowDAO.getShipping(borrowId);
    }

    @GetMapping("/payment/{borrowId}")
    public Payment getPayment(@PathVariable int borrowId) {
        return borrowDAO.getPayment(borrowId);
    }

    @GetMapping("/reader/{borrowId}")
    public Reader getReader(@PathVariable int borrowId) {
        return borrowDAO.getReader(borrowId);
    }

    @GetMapping("/cart/{borrowId}")
    public Cart getCart(@PathVariable int borrowId) {
        return borrowDAO.getCart(borrowId);
    }
}
