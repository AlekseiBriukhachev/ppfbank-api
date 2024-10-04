package com.aleksei.ppfbankapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Details about the amount")
public class AmountDTO {
    @Schema(description = "The currency of the amount")
    private String currency;

    @Schema(description = "The value of the amount")
    private BigDecimal value;
}
