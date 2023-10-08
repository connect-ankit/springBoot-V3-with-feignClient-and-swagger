package com.inn.assignment.task2.controller;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.annotation.JsonView;
import com.inn.assignment.task2.model.ViewInfo;
import com.inn.assignment.task2.model.Views;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "IViewInfoController")
public interface IviewInfoController {
	
	@Operation(summary = "getDetailList", description = "Returns detail list including all params")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful response with greeting message."),
            @ApiResponse(responseCode = "404", description = "Not Found.")
    })
	
	@JsonView(Views.DetailedView.class)
	@GetMapping(path = "/getDetailList")
	List<ViewInfo> getDetailList();
	
	
	@Operation(summary = "getList", description = "Returns list with specific params ")
	@JsonView(Views.BasicView.class)
	@GetMapping(path = "/getList")
	List<ViewInfo> getList();

	@GetMapping("/findById/{id}")
	@Operation(summary = "findById", description = "Returns single object with nested json")
	public ViewInfo findById(@PathVariable Long id);

	@Hidden
	@GetMapping("/findByParentId/{id}")
	public List<ViewInfo> findByParentId(@PathVariable Long id);

	@GetMapping("/getNestedResult")
	@Operation(summary = "getNestedResult", description = "Returns list with nested json")
	public List<Map<String, Object>> getNestedResult();
	
	
	
	
	@GetMapping("/printPrams/{first}/{second}")
	@Operation(summary = "printParams", description = "This API is designed to print params using custom annotations")
	public Integer printPrams(@PathVariable(required = true,name = "first") Integer first,@PathVariable(required = true,name = "second") Integer second );

}
