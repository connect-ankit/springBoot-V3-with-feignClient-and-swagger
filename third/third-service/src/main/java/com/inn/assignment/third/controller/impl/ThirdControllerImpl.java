package com.inn.assignment.third.controller.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.assignment.third.controller.IThirdController;
import com.inn.assignment.third.exceptionHandler.customException.JsonFormatException;

@RestController
@RequestMapping(path = "/ThirdService")
public class ThirdControllerImpl implements IThirdController {

	Logger log = LoggerFactory.getLogger(ThirdControllerImpl.class);
	@Override
	public String isAlive() {
		log.info("isAlive app 3");
		return "Server 3 is up and Running...";
	}

	@Override
	public String sayGreeting(String value) {
		
		log.info("inside sayGreeting app 3",value);
		try {
			StringBuilder result = new StringBuilder();
			JSONObject payload = new JSONObject(value);
			if (payload.has("name") || payload.has("surname"))
				return setName(result, payload);
			else {
				throw new JsonFormatException("Invalid JSON format  Key is missing");
			}

		} catch (JSONException e) {
			log.error("inside sayGreeting app 3",e.getLocalizedMessage());
			throw new JsonFormatException(e.getMessage());
		}

	}

	private String setName(StringBuilder result, JSONObject payload) {
		if (payload.has("name")) {
			
			log.info("check name from paylaod",payload.has("name"));
			result.append(payload.getString("name"));
		}
		if (payload.has("surname")) {
			result.append(" ");
			result.append(payload.getString("surname"));
		}
		return result.toString();
	}

}
