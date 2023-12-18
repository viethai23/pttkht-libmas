package com.example.libraryonline.Repository;

import com.example.libraryonline.Model.Borrow.Return;
import com.example.libraryonline.Model.User.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer> {
    List<Return> findByReader(Reader reader);
}
