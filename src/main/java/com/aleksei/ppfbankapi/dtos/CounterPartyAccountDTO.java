package com.aleksei.ppfbankapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Details about the counter party account")
public class CounterPartyAccountDTO {
    @Schema(description = "The name of the counter party account")
    private String accountName;

    @Schema(description = "The number of the counter party account")
    private String accountNumber;

    @Schema(description = "The bank code of the counter party account")
    private String bankCode;
}
