package com.inn.assignment.first.external.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.assignment.first.external.service.IFirstExternalService;
import com.inn.assignment.second.controller.ISecondController;
import com.inn.assignment.third.controller.IThirdController;

@Service
public class FirstExternalServiceImpl implements IFirstExternalService {

	Logger log = LoggerFactory.getLogger(FirstExternalServiceImpl.class);

	@Autowired
	IThirdController thirdController;
	
	@Autowired
	ISecondController secondController;

	@Override
	public String sayHello() {
		
		log.info("sayHello");
		return secondController.sayGreeting();
	}

	@Override
	public String helloBuddy(String palyload) {
		log.info("helloBuddy",palyload);
		return thirdController.sayGreeting(palyload);
	}

}
