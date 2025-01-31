package com.picPaySimplificado.picpaySimplificado.repository;

import com.picPaySimplificado.picpaySimplificado.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
