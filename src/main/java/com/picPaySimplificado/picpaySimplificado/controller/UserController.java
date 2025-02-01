package com.picPaySimplificado.picpaySimplificado.controller;

import com.picPaySimplificado.picpaySimplificado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping


}
