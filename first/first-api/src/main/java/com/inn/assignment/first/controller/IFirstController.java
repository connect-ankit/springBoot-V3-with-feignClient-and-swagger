
package com.inn.assignment.first.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "IFirstController")
@FeignClient(name = "FirstService", url = "${first-service.url}", path = "/FirstService", primary = false)
public interface IFirstController {

	@Operation(summary = "isAlive", description = "Returns a  message.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response with greeting message."),
			@ApiResponse(responseCode = "404", description = "Not Found.") })

	@GetMapping(path = "isAlive")
	String isAlive();

	@PostMapping(path = "/sayHello")

	@Operation(summary = "Say Hello", description = "Returns a greeting message.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response with greeting message."),
			@ApiResponse(responseCode = "404", description = "Not Found.") })

	String sayHello(@RequestBody(required = true) String value);

}
