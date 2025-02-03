package com.picPaySimplificado.picpaySimplificado.dto;

import com.picPaySimplificado.picpaySimplificado.model.user.UserTypes;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document,
                      String email, String password , BigDecimal balance, UserTypes userTypes) {
    



}
