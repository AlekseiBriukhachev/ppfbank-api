package com.aleksei.ppfbankapi.service;

import com.aleksei.ppfbankapi.dtos.TransactionDTO;
import com.aleksei.ppfbankapi.entities.Transaction;
import com.aleksei.ppfbankapi.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getTransactionsByOwnAccountNumber_returnsTransactions_whenAccountNumberExists() {
        String ownAccountNumber = "123456";
        Transaction transaction = new Transaction();
        transaction.setOwnAccountNumber(ownAccountNumber);
        when(transactionRepository.findByOwnAccountNumber(ownAccountNumber)).thenReturn(List.of(transaction));

        List<TransactionDTO> result = transactionService.getTransactionsByOwnAccountNumber(ownAccountNumber);

        assertEquals(1, result.size());
        assertEquals(ownAccountNumber, result.get(0).ownAccountNumber());
    }

    @Test
    void getTransactionsByOwnAccountNumber_returnsEmptyList_whenAccountNumberDoesNotExist() {
        String ownAccountNumber = "123456";
        when(transactionRepository.findByOwnAccountNumber(ownAccountNumber)).thenReturn(Collections.emptyList());

        List<TransactionDTO> result = transactionService.getTransactionsByOwnAccountNumber(ownAccountNumber);

        assertEquals(0, result.size());
    }

    @Test
    void getTransactionsByOwnAccountNumber_returnsNull_whenAccountNumberIsNull() {
        List<TransactionDTO> result = transactionService.getTransactionsByOwnAccountNumber(null);

        assertNull(result);
    }

}