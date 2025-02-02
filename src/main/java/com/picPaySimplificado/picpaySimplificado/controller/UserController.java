package com.picPaySimplificado.picpaySimplificado.controller;

import com.picPaySimplificado.picpaySimplificado.dto.UserDTO;
import com.picPaySimplificado.picpaySimplificado.model.user.User;
import com.picPaySimplificado.picpaySimplificado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(UserDTO user){


        
    }


}
