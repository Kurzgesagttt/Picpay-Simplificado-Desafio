package com.picPaySimplificado.picpaySimplificado.service;

import com.picPaySimplificado.picpaySimplificado.dto.TransactionDTO;
import com.picPaySimplificado.picpaySimplificado.model.transaction.Transaction;
import com.picPaySimplificado.picpaySimplificado.model.user.User;
import com.picPaySimplificado.picpaySimplificado.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private RestTemplate template;


    public Transaction createTransacion(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findById(transaction.senderId());
        User receiver = this.userService.findById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.value());

        if(!isAuthorized){
            throw new Exception("Transação nao autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        return newTransaction;

    }

    public boolean authorizeTransaction(User sender, BigDecimal value){
        ResponseEntity<Map> authorizationResponse = template.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

        if(authorizationResponse.getStatusCode() == HttpStatus.OK){
            String message = (String) authorizationResponse.getBody().get("status");
            return "success".equalsIgnoreCase(message);
        }else return false;
    }

}
