package com.aleksei.ppfbankapi.repository;

import com.aleksei.ppfbankapi.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByOwnAccountNumber(String ownAccountNumber);
}
