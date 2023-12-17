package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.Borrow.Return;
import com.example.shoppingonline.Model.User.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer> {
    List<Return> findByReader(Reader reader);
}
