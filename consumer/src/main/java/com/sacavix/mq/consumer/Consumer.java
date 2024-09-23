package com.sacavix.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sacavix.mq.dummy.Data;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

	@Value("${sacavix.queue.name}")
	private String queue;

	@RabbitListener(queues = { "${sacavix.queue.name}" })
	public void receive(@Payload Data message) {

		log.info("Received message from queue: {}", queue.toString());
		log.info("Message: {}", message);


//		makeSlow();

	}

	private void makeSlow() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
