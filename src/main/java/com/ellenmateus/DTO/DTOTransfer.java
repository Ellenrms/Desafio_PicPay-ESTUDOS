package com.ellenmateus.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record DTOTransfer (
		@DecimalMin("0.01")
		@NotNull
		BigDecimal value,
		
		@NotNull
		Long payer,
		
		@NotNull
		Long payee
		) {

}
