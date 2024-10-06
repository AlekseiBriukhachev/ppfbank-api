package com.aleksei.ppfbankapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about the counter party account")
public record CounterPartyAccountDTO(
        @Schema(description = "The name of the counter party account")
        String accountName,

        @Schema(description = "The number of the counter party account")
        String accountNumber,

        @Schema(description = "The bank code of the counter party account")
        String bankCode
) {}
