package com.aleksei.ppfbankapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Details about the amount")
public record AmountDTO(
        @Schema(description = "The currency of the amount")
        String currency,

        @Schema(description = "The value of the amount")
        BigDecimal value) {

}
