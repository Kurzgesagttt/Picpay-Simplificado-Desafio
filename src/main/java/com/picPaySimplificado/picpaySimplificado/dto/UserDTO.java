package com.picPaySimplificado.picpaySimplificado.dto;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document,
                      String email, String password , BigDecimal balance) {
    



}
