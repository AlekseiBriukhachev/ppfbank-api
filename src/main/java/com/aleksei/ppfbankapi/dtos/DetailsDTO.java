package com.aleksei.ppfbankapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about the transaction details")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record DetailsDTO(
        @Schema(description = "The first detail of the transaction")
        String detail1,

        @Schema(description = "The second detail of the transaction")
        String detail2,

        @Schema(description = "The third detail of the transaction")
        String detail3,

        @Schema(description = "The fourth detail of the transaction")
        String detail4
) {}
