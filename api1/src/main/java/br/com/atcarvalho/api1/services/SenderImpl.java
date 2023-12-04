package br.com.atcarvalho.api1.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderImpl implements Sender{


    private RabbitTemplate rabbitTemplate;

    private Queue queue;

    SenderImpl(RabbitTemplate template, Queue queue){
        this.rabbitTemplate = template;
        this.queue = queue;
    }


    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend(this.queue.getName(), message);
        log.info("Send queue for topic {}", this.queue.getName());
    }
}
