package com.sacavix.mq.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sacavix.mq.publisher.Publisher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DummyService {

	@Autowired
	private Publisher publisher;
	
	public void sendToRabbit(Long number) {
		Data d = new Data(number, "Hello World from JAVA");
		log.info("Message '{}' will be send ... ", d);
		this.publisher.send(d);
	}
	
}
