package com.aleksei.ppfbankapi.controller;

import com.aleksei.ppfbankapi.dtos.TransactionDTO;
import com.aleksei.ppfbankapi.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account/")
@Tag(name = "Transaction Management System")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @Operation(summary = "View a list of transactions for a specific account number")
    @GetMapping("{ownAccountNumber}/transactions")
    public List<TransactionDTO> getTransactionsByOwnAccountNumber(@PathVariable String ownAccountNumber) {
        return transactionService.getTransactionsByOwnAccountNumber(ownAccountNumber);
    }
}
