package com.aleksei.ppfbankapi.service;

import com.aleksei.ppfbankapi.dtos.AmountDTO;
import com.aleksei.ppfbankapi.dtos.CounterPartyAccountDTO;
import com.aleksei.ppfbankapi.dtos.DetailsDTO;
import com.aleksei.ppfbankapi.dtos.TransactionDTO;
import com.aleksei.ppfbankapi.entities.Transaction;
import com.aleksei.ppfbankapi.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionDTO> getTransactionsByOwnAccountNumber(String ownAccountNumber) {
        if (ownAccountNumber == null) {
            return null;
        }
        return transactionRepository.findByOwnAccountNumber(ownAccountNumber)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        return new TransactionDTO(
                new AmountDTO(transaction.getCurrency(), transaction.getAmount()),
                transaction.getBankref(),
                transaction.getBookingDate(),
                new CounterPartyAccountDTO(
                        transaction.getCounterPartyAccount().getName(),
                        transaction.getCounterPartyAccount().getNumber(),
                        transaction.getCounterPartyAccount().getCode()
                ),
                transaction.getCreditDebitIndicator(),
                new DetailsDTO(
                        transaction.getDetail1(),
                        transaction.getDetail2(),
                        transaction.getDetail3(),
                        transaction.getDetail4()
                ),
                transaction.getId(),
                transaction.getOwnAccountNumber(),
                transaction.getPostingDate(),
                transaction.getProductBankRef(),
                transaction.getSpecificSymbol(),
                transaction.getStatement().getNumber(),
                transaction.getStatement().getPeriod(),
                transaction.getTransactionId(),
                transaction.getTransactionType().getType(),
                transaction.getTransactionType().getCode(),
                transaction.getVariableSymbol()
        );
    }
}
