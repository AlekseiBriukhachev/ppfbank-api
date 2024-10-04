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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionDTO> getTransactionsByOwnAccountNumber(String ownAccountNumber) {
        List<Transaction> transactions = transactionRepository.findByOwnAccountNumber(ownAccountNumber);
        return transactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();

        AmountDTO amountDTO = new AmountDTO();
        amountDTO.setCurrency(transaction.getCurrency());
        amountDTO.setValue(transaction.getAmount());
        dto.setAmount(amountDTO);

        CounterPartyAccountDTO counterPartyAccountDTO = new CounterPartyAccountDTO();
        counterPartyAccountDTO.setAccountName(transaction.getCounterPartyAccount().getName());
        counterPartyAccountDTO.setAccountNumber(transaction.getCounterPartyAccount().getNumber());
        counterPartyAccountDTO.setBankCode(transaction.getCounterPartyAccount().getCode());
        dto.setCounterPartyAccount(counterPartyAccountDTO);

        DetailsDTO detailsDTO = new DetailsDTO();
        detailsDTO.setDetail1(transaction.getDetail1());
        detailsDTO.setDetail2(transaction.getDetail2());
        detailsDTO.setDetail3(transaction.getDetail3());
        detailsDTO.setDetail4(transaction.getDetail4());
        dto.setDetails(detailsDTO);

        dto.setBankref(transaction.getBankref());
        dto.setBookingDate(transaction.getBookingDate());
        dto.setCreditDebitIndicator(transaction.getCreditDebitIndicator());
        dto.setId(transaction.getId());
        dto.setOwnAccountNumber(transaction.getOwnAccountNumber());
        dto.setPostingDate(transaction.getPostingDate());
        dto.setProductBankRef(transaction.getProductBankRef());
        dto.setSpecificSymbol(transaction.getSpecificSymbol());
        dto.setStatementNumber(transaction.getStatement().getNumber());
        dto.setStatementPeriod(transaction.getStatement().getPeriod());
        dto.setTransactionId(transaction.getTransactionId());
        dto.setTransactionType(transaction.getTransactionType().getType());
        dto.setTransactionTypeCode(transaction.getTransactionType().getCode());
        dto.setVariableSymbol(transaction.getVariableSymbol());

        return dto;
    }
}
