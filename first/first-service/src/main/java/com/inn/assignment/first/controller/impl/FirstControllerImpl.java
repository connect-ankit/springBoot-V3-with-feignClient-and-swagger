package com.inn.assignment.first.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.assignment.first.controller.IFirstController;
import com.inn.assignment.first.service.IFirstService;

@RequestMapping(path = "/FirstService")
@RestController
public class FirstControllerImpl implements IFirstController {
	
	Logger log = LoggerFactory.getLogger(FirstControllerImpl.class);
	@Override
	public String isAlive() {

	log.info("I am here");
	
		return "Server 1 is up and Running...";
	}

	@Autowired
	IFirstService firstService;

	@Override
	public String sayHello(String value) {
		log.info("I asayHello",value);
		return firstService.sayHello(value);

	}

}
