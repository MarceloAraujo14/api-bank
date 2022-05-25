package com.tqibank.emprestimo.api.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplicationRequest {

        @NotBlank
        private String clientId;
        @NotNull
        private BigDecimal value;
        @NotNull
        private Integer installments;
        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate firstInstallment;


    }