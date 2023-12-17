package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Borrow.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
