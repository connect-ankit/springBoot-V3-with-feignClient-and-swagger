package com.inn.assignment.task2.service;

import java.util.List;
import java.util.Map;

import com.inn.assignment.task2.model.ViewInfo;

public interface IViewInfoService {
	public List<ViewInfo> getList();

	public List<ViewInfo> findByParentId(Long parentId);

	public List<Map<String, Object>> getNestedResult();

	public ViewInfo findById(Long id);
}
