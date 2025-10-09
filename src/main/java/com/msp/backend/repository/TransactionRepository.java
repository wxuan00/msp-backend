package com.msp.backend.repository;

import com.msp.backend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByMerchantId(String merchantId);
    List<Transaction> findByStatus(String status);
    List<Transaction> findByType(String type);
    List<Transaction> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
    List<Transaction> findByReferenceNo(String referenceNo);
}