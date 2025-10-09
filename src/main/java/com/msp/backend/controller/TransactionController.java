package com.msp.backend.controller;

import com.msp.backend.entity.Transaction;
import com.msp.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.findAll();
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        transaction.setCreatedAt(LocalDateTime.now());
        Transaction savedTransaction = transactionService.save(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        Transaction existingTransaction = transactionService.findById(id);
        if (existingTransaction == null) {
            return ResponseEntity.notFound().build();
        }
        transaction.setId(id);
        Transaction updatedTransaction = transactionService.save(transaction);
        return ResponseEntity.ok(updatedTransaction);
    }
}