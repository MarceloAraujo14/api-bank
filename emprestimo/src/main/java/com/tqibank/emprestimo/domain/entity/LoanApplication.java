package com.tqibank.emprestimo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class LoanApplication {

    @Id
    private String id;
    private String clientId;
    private BigDecimal value;
    private Integer installments;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate firstInstallment;


}
