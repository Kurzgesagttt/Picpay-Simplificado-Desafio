package com.picPaySimplificado.picpaySimplificado.controller;

import com.picPaySimplificado.picpaySimplificado.dto.UserDTO;
import com.picPaySimplificado.picpaySimplificado.model.user.User;
import com.picPaySimplificado.picpaySimplificado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = service.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = service.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
