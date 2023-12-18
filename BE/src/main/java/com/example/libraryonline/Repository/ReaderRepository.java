package com.example.libraryonline.Repository;

import com.example.libraryonline.Model.User.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}
