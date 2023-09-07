package com.pipcpaysimplificado.services;

import com.pipcpaysimplificado.domain.user.User;
import com.pipcpaysimplificado.domain.user.UserType;
import com.pipcpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Merchant can't make a transaction!");
        }

        if(sender.getBalance().compareTo(amount)<0){
            throw new Exception("Balance is not enough");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Can not find the user"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
