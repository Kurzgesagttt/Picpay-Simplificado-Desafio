package com.picPaySimplificado.picpaySimplificado.dto;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long senderId, Long receiverId){

}
