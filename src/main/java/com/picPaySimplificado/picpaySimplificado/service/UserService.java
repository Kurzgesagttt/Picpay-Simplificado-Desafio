package com.picPaySimplificado.picpaySimplificado.service;

import com.picPaySimplificado.picpaySimplificado.dto.UserDTO;
import com.picPaySimplificado.picpaySimplificado.model.user.User;
import com.picPaySimplificado.picpaySimplificado.model.user.UserTypes;
import com.picPaySimplificado.picpaySimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserTypes.MERCHANT){
            throw new Exception("Usuario do tipo lojista nao pode enviar quantias de dinheiro");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }

    }

    public User findById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("user não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        userRepository.save(newUser);
        return newUser;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
