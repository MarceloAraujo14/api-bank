package com.tqibank.servico.api.model.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class LoanApplicationResponse {

    private String id;
    private String clientId;
    private BigDecimal value;
    private Integer installments;
    private LocalDateTime createdAt;

}
