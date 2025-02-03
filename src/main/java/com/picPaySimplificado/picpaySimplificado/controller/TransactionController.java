package com.picPaySimplificado.picpaySimplificado.controller;

import com.picPaySimplificado.picpaySimplificado.dto.TransactionDTO;
import com.picPaySimplificado.picpaySimplificado.model.transaction.Transaction;
import com.picPaySimplificado.picpaySimplificado.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService tranService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTrans = tranService.createTransacion(transaction);
        return new ResponseEntity<>(newTrans ,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        List<Transaction> newTransaction = tranService.getAllTransaction();
        return new ResponseEntity<>(newTransaction,HttpStatus.OK);
    }

}
