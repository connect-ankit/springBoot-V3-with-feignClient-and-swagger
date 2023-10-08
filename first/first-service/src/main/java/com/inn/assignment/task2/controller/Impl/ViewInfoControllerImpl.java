package com.inn.assignment.task2.controller.Impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.assignment.first.utils.CustomLogger;
import com.inn.assignment.task2.controller.IviewInfoController;
import com.inn.assignment.task2.model.ViewInfo;
import com.inn.assignment.task2.service.IViewInfoService;

@RequestMapping(path = "/ViewInfo")
@RestController
public class ViewInfoControllerImpl implements IviewInfoController {

	@Autowired
	IViewInfoService infoService;

	@Override
	public List<ViewInfo> getList() {

		return infoService.getList();
	}

	@Override
	public ViewInfo findById(Long id) {
		return infoService.findById(id);
	}

	@Override
	public List<ViewInfo> findByParentId(Long id) {

		return infoService.findByParentId(id);
	}

	public List<Map<String, Object>> getNestedResult() {
		return infoService.getNestedResult();
	}

	@Override
	public List<ViewInfo> getDetailList() {
		return infoService.getList();
	}

	@Override
	@CustomLogger
	public Integer printPrams(Integer first, Integer second) {
		
		return first*second;
	}
}
