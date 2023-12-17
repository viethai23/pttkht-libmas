package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Borrow.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}