package com.aleksei.ppfbankapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Details about the transaction")
public class TransactionDTO {
    @Schema(description = "The amount of the transaction")
    private AmountDTO amount;

    @Schema(description = "The bank reference of the transaction")
    private String bankref;

    @Schema(description = "The booking date of the transaction")
    private LocalDate bookingDate;

    @Schema(description = "The counter party account of the transaction")
    private CounterPartyAccountDTO counterPartyAccount;

    @Schema(description = "The credit or debit indicator of the transaction")
    private String creditDebitIndicator;

    @Schema(description = "The details of the transaction")
    private DetailsDTO details;

    @Schema(description = "The ID of the transaction")
    private String id;

    @Schema(description = "The own account number of the transaction")
    private String ownAccountNumber;

    @Schema(description = "The posting date of the transaction")
    private LocalDate postingDate;

    @Schema(description = "The product bank reference of the transaction")
    private String productBankRef;

    @Schema(description = "The specific symbol of the transaction")
    private String specificSymbol;

    @Schema(description = "The number of the statement")
    private String statementNumber;

    @Schema(description = "The period of the statement")
    private String statementPeriod;

    @Schema(description = "The transaction ID")
    private String transactionId;

    @Schema(description = "The type of the transaction")
    private String transactionType;

    @Schema(description = "The code of the transaction type")
    private int transactionTypeCode;

    @Schema(description = "The variable symbol of the transaction")
    private String variableSymbol;
}