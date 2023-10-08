package com.inn.assignment.task2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inn.assignment.task2.model.ViewInfo;


public interface IViewInfoRepository extends JpaRepository<ViewInfo, Long> {

	List<ViewInfo> findByParentId(Long parentId);
}
