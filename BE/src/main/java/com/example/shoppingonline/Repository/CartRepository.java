package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Borrow.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByReader_IdAndStatus(int readerId, String status);
}
