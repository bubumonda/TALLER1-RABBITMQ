package com.sacavix.mq.dummy;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class DummyController {

	@Autowired
	private DummyService dummyService;
	
	@GetMapping
	public void testSendMessage() {
		while (true){
		Long message =  ( long)ThreadLocalRandom.current().nextInt();
		this.dummyService.sendToRabbit(message);
		makeSlow();
	}
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
