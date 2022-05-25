package com.tqibank.servico.api.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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


        @Override
        public String toString() {
                return "{\n" +
                        "  \"clientId\": \"string\",\n" +
                        "  \"value\": 100,\n" +
                        "  \"installments\": 10,\n" +
                        "  \"firstInstallment\": \"2022-04-04\"\n" +
                        "}";
        }
}