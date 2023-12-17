package com.example.shoppingonline.Controller;

import com.example.shoppingonline.DAO.PaymentDAO.PaymentDAO;
import com.example.shoppingonline.DTO.PaymentResponse;
import com.example.shoppingonline.Model.Borrow.Cart;
import com.example.shoppingonline.Model.Borrow.Fine;
import com.example.shoppingonline.Model.Borrow.Payment;
import com.example.shoppingonline.Model.Borrow.Shipping;
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
