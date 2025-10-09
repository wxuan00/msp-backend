package com.msp.backend.service;

import com.msp.backend.entity.Transaction;
import com.msp.backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    public List<Transaction> findByMerchantId(String merchantId) {
        return transactionRepository.findByMerchantId(merchantId);
    }

    public List<Transaction> findByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }

    public List<Transaction> findByType(String type) {
        return transactionRepository.findByType(type);
    }

    public List<Transaction> findByReferenceNo(String referenceNo) {
        return transactionRepository.findByReferenceNo(referenceNo);
    }

    public List<Transaction> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByCreatedAtBetween(startDate, endDate);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}