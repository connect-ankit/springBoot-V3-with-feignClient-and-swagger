package com.inn.assignment.task2.service.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.inn.assignment.task2.model.ViewInfo;
import com.inn.assignment.task2.repository.IViewInfoRepository;
import com.inn.assignment.task2.service.IViewInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j

public class ViewInfoServiceImpl implements IViewInfoService {

	

	private IViewInfoRepository infoRepository;

	
	@Override
	public List<ViewInfo> getList() {
		log.info("Inside getList");
		
		return infoRepository.findAll();
	}

	@Override
	public List<ViewInfo> findByParentId(Long parentId) {
		log.info("Inside findByParentId :{}", parentId);
		return infoRepository.findByParentId(parentId);
	}

	@Override
	public ViewInfo findById(Long id) {
		ViewInfo byId = infoRepository.getById(id);
		
		log.info("Inside findById :{}", byId.getParentId());
		List<ViewInfo> findByParentId = infoRepository.findByParentId(byId.getId());
		log.info("after result :{}", findByParentId);
		ViewInfo result = new ViewInfo();
		result.setSubClass(findByParentId);
		result.setColor(byId.getColor());
		result.setName(byId.getName());
		result.setId(byId.getId());
		result.setParentId(byId.getParentId());
		log.info("resuring  result :{}", result);
		return result;
	}

	@Override
	public List<Map<String, Object>> getNestedResult() {
		List<Map<String, Object>> result = new ArrayList<>();
		List<ViewInfo> topLevelClasses = infoRepository.findByParentId(0L);
		log.info("Inside getNestedResult :{}", topLevelClasses.size());
		for (ViewInfo topLevelClass : topLevelClasses) {
			Map<String, Object> classMap = new LinkedHashMap<>();
			classMap.put("Name", topLevelClass.getName());
			classMap.put("Color", topLevelClass.getColor());
			List<Map<String, Object>> subClasses = getSubClasses(topLevelClass.getId());
			if (!subClasses.isEmpty()) {
				classMap.put("Sub Classes", subClasses);
			}
			result.add(classMap);
		}

		return result;
	}

	private List<Map<String, Object>> getSubClasses(Long parentId) {
		List<Map<String, Object>> subClasses = new ArrayList<>();
		List<ViewInfo> childClasses = infoRepository.findByParentId(parentId);

		for (ViewInfo childClass : childClasses) {
			Map<String, Object> classMap = new LinkedHashMap<>();
			classMap.put("Name", childClass.getName());
			classMap.put("Color", childClass.getColor());
			List<Map<String, Object>> nestedSubClasses = getSubClasses(childClass.getId());
			if (!nestedSubClasses.isEmpty()) {
				classMap.put("Sub Classes", nestedSubClasses);
			}
			subClasses.add(classMap);
		}

		return subClasses;
	}

}
