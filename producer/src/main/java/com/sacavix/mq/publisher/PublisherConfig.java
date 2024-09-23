package com.sacavix.mq.publisher;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {
	
    @Value("${sacavix.queue1.name}")
    private String cola1;

    @Value("${sacavix.queue2.name}")
    private String cola2;

    @Value("${sacavix.exchange.name}")
    private String exchangeName;

    @Bean
     Queue queue1() {
        return new Queue(cola1, true);
    }

    @Bean
     Queue queue2() {
        return new Queue(cola2, true);
    }

    @Bean
     FanoutExchange exchange() {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    Binding binding1(Queue queue1, FanoutExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange);
    }

    @Bean
    Binding binding2(Queue queue2, FanoutExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange);
    }


    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}
