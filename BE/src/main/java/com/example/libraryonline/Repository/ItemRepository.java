package com.example.libraryonline.Repository;

import com.example.libraryonline.Model.Borrow.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findByBook_IdAndCart_Id(int bookId, int cartId);
}
