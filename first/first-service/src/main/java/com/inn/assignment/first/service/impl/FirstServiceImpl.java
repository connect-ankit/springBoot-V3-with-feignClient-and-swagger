package com.inn.assignment.first.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inn.assignment.first.exception.BuisnessException;
import com.inn.assignment.first.exception.ConnectionFailureException;
import com.inn.assignment.first.external.service.IFirstExternalService;
import com.inn.assignment.first.service.IFirstService;
import com.inn.assignment.third.exceptionHandler.customException.JsonFormatException;

@Service
public class FirstServiceImpl implements IFirstService {

	@Autowired
	IFirstExternalService externalService;

	@Autowired
	RestTemplate restTemplate;

	@Override

	public String sayHello(String value) {
		StringBuilder result = new StringBuilder();
		connectApplication2(result);
		result.append(" ");
		connectApplication3(value, result);
		return result.toString();

	}

	private void connectApplication3(String value, StringBuilder result) {
		try {
			isJsonValid(value);
			result.append(externalService.helloBuddy(value));
		} catch (JsonFormatException e) {
			throw new BuisnessException(e.getLocalizedMessage());
		} catch (Exception e) {
			throw new ConnectionFailureException("Target Application 3 is not running");
		}

	}

	private boolean isJsonValid(String value) {

		try {
			JSONObject payload = new JSONObject(value);
			if (payload.has("name") || payload.has("surname")) {
				return true;
			} else {
				throw new JsonFormatException("Invalid JSON format  Key is missing");
			}
		} catch (Exception e) {
			throw new JsonFormatException(e.getMessage());
		}

	}

	private void connectApplication2(StringBuilder result) {
		String url = "http://localhost:8082/SecondService/sayGreeting2";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		String responseBody = responseEntity.getBody();
		result.append(responseBody);
		

	}

}
