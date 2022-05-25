package com.tqibank.emprestimo.domain.repository;

import com.tqibank.emprestimo.domain.entity.LoanApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends MongoRepository<LoanApplication, String> {
}
