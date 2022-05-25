package com.tqibank.emprestimo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanApplicationResponse {

    private String id;
    private String clientId;
    private BigDecimal value;
    private Integer installments;
    private LocalDate firstInstallment;

}
