package com.aleksei.ppfbankapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Details about the transaction details")
public class DetailsDTO {
    @Schema(description = "The first detail of the transaction")
    private String detail1;

    @Schema(description = "The second detail of the transaction")
    private String detail2;

    @Schema(description = "The third detail of the transaction")
    private String detail3;

    @Schema(description = "The fourth detail of the transaction")
    private String detail4;
}
