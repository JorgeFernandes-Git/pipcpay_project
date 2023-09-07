package com.pipcpaysimplificado.services;

import com.pipcpaysimplificado.domain.transaction.Transaction;
import com.pipcpaysimplificado.domain.user.User;
import com.pipcpaysimplificado.dtos.TransactionDTO;
import com.pipcpaysimplificado.repositories.TransactionRepository;
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
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public void  createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        if()
    }

    public boolean authorizeTransaction(User sender, BigDecimal value()){
       ResponseEntity<Map> = restTemplate.getForEntity("https://...", Map.class);

       if(authorizationRespoonse.getStatusCode() == HttpStatus.OK && authorizationResponse.get)
    }
}
