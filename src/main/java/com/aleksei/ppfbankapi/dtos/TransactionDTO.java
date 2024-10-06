package com.aleksei.ppfbankapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Details about the transaction")
public record TransactionDTO(
        @Schema(description = "The amount of the transaction")
        AmountDTO amount,

        @Schema(description = "The bank reference of the transaction")
        String bankref,

        @Schema(description = "The booking date of the transaction")
        LocalDate bookingDate,

        @Schema(description = "The counter party account of the transaction")
        CounterPartyAccountDTO counterPartyAccount,

        @Schema(description = "The credit or debit indicator of the transaction")
        String creditDebitIndicator,

        @Schema(description = "The details of the transaction")
        DetailsDTO details,

        @Schema(description = "The ID of the transaction")
        String id,

        @Schema(description = "The own account number of the transaction")
        String ownAccountNumber,

        @Schema(description = "The posting date of the transaction")
        LocalDate postingDate,

        @Schema(description = "The product bank reference of the transaction")
        String productBankRef,

        @Schema(description = "The specific symbol of the transaction")
        String specificSymbol,

        @Schema(description = "The number of the statement")
        String statementNumber,

        @Schema(description = "The period of the statement")
        String statementPeriod,

        @Schema(description = "The transaction ID")
        String transactionId,

        @Schema(description = "The type of the transaction")
        String transactionType,

        @Schema(description = "The code of the transaction type")
        int transactionTypeCode,

        @Schema(description = "The variable symbol of the transaction")
        String variableSymbol
) {
}