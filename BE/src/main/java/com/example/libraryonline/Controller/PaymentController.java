package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.PaymentDAO.PaymentDAO;
import com.example.libraryonline.DTO.PaymentResponse;
import com.example.libraryonline.Model.Borrow.Cart;
import com.example.libraryonline.Model.Borrow.Fine;
import com.example.libraryonline.Model.Borrow.Payment;
import com.example.libraryonline.Model.Borrow.Shipping;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class PaymentController {

    private final PaymentDAO paymentDAO;

    @Autowired
    public PaymentController(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @PostMapping("/calculateBorrowCost")
    public PaymentResponse calculateBorrowCost(@RequestBody PaymentCalculate paymentCalculate) {
        return paymentDAO.calculateBorrowCost(paymentCalculate.getShipping(), paymentCalculate.getCart(), paymentCalculate.getPayment());
    }

    @PostMapping("/calculateReturnCost")
    public PaymentResponse calculateReturnCost(@RequestBody PaymentCalculate paymentCalculate) {
        return paymentDAO.calculateReturnCost(paymentCalculate.getShipping(), paymentCalculate.getFine(), paymentCalculate.getPayment());
    }

    @PostMapping("/processPayment")
    public boolean processPayment(@RequestBody Payment payment) {
        return paymentDAO.processPayment(payment);
    }

}

@Data
class PaymentCalculate {
    private Shipping shipping;
    private Payment payment;
    private Fine fine;
    private Cart cart;
}
