package com.inn.assignment.second.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.assignment.second.controller.ISecondController;

@RequestMapping(path = "/SecondService")
@RestController
public class SecondControllerImpl implements ISecondController {
	Logger log = LoggerFactory.getLogger(SecondControllerImpl.class);
	@Override
	public String isAlive() {
		log.info("isAlive app 2");
		return "Server 2 is up and Running...";
	}

	@Override
	public String sayGreeting() {
		log.info("I am here app 2");
		return "Hello, ";

	}

}
