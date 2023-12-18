package com.example.libraryonline.Controller;

import com.example.libraryonline.DAO.ReaderDAO.ReaderDAO;
import com.example.libraryonline.Model.User.Account;
import com.example.libraryonline.Model.User.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reader")
@CrossOrigin
public class ReaderController {
    @Autowired
    private ReaderDAO readerDAO;

    @GetMapping
    public List<Reader> getAllReader() {
        return readerDAO.getAllReader();
    }


    @DeleteMapping("/{readerId}")
    public ResponseEntity<String> delete(@PathVariable int readerId) {
        if (readerDAO.delete(readerId)) {
            return ResponseEntity.ok("reader deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{readerId}")
    public ResponseEntity<Reader> edit(@PathVariable int readerId, @RequestBody Reader newReader) {
        Reader editedReader = readerDAO.edit(readerId, newReader);
        if (editedReader != null) {
            return ResponseEntity.ok(editedReader);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Reader> register(@RequestBody Account acc) {
        Reader registeredReader = readerDAO.register(acc);
        if (registeredReader != null) {
            return ResponseEntity.ok(registeredReader);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
