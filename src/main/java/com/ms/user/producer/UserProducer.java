package com.ms.user.producer;

import com.ms.user.model.dto.EmailDto;
import com.ms.user.model.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessageEmail(User user) {
        var emailDto = new EmailDto();
        emailDto.setUserId(user.getId());
        emailDto.setEmail(user.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(user.getName() + ", seja bem-vindo!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
