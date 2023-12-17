package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Borrow.Borrow;
import com.example.shoppingonline.Model.User.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    List<Borrow> findByReader(Reader reader);
}
