package com.tqibank.emprestimo.domain.service;

import com.tqibank.emprestimo.domain.entity.LoanApplication;
import com.tqibank.emprestimo.domain.repository.LoanRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public void create(LoanApplication loanApplication){
        loanRepository.save(loanApplication);
        log.info("Sucess save");
    }

}
