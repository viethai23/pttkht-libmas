package com.example.libraryonline.Repository;

import com.example.libraryonline.Model.Borrow.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByReader_IdAndStatus(int readerId, String status);
}
