package com.inn.assignment.third.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "IThirdController")
@FeignClient(name = "ThirdService", url = "${third-service.url}", path = "/ThirdService", primary = false)
public interface IThirdController {

	@Operation(summary = "isAlive3", description = "Returns a  message.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response with greeting message."),
			@ApiResponse(responseCode = "404", description = "Not Found.") })

	@GetMapping(path = "isAlive3")
	String isAlive();
	
	
	@PostMapping(path = "/sayGreeting3")
	String sayGreeting( @RequestBody(required = true) String value);

}
