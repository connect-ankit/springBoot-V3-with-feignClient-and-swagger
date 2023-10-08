package com.inn.assignment.second.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController

@Tag(name = "ISecondController")
@FeignClient(name = "SecondService", url = "${second-service.url}", path = "/SecondService", primary = false)
public interface ISecondController {

	@Operation(summary = "isAlive2", description = "Returns a  message.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response with greeting message."),
			@ApiResponse(responseCode = "404", description = "Not Found.") })

	@GetMapping(path = "isAlive2")
	String isAlive();

	@GetMapping(path = "/sayGreeting2")
	String sayGreeting();

}
