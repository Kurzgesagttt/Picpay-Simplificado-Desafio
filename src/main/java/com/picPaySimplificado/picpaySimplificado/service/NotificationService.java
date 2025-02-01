package com.picPaySimplificado.picpaySimplificado.service;

import com.picPaySimplificado.picpaySimplificado.dto.NotificationDTO;
import com.picPaySimplificado.picpaySimplificado.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate template;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email,message);

        ResponseEntity<String> notificationResponse =  template.postForEntity("https://util.devi.tools/api/v1/notify",notificationRequest,String.class);

        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            System.out.println("Erro ao notificar");
            throw new Exception("Servico de notificacao fora do ar");

        }

    }

}
