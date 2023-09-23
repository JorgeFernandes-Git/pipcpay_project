package com.pipcpaysimplificado.services;

import com.pipcpaysimplificado.domain.user.User;
import com.pipcpaysimplificado.domain.user.UserType;
import com.pipcpaysimplificado.dtos.UserDTO;
import com.pipcpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
