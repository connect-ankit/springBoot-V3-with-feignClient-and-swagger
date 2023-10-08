package com.inn.assignment.task2.model;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.inn.assignment.task2.beans.ApplicationContextProvider;
import com.inn.assignment.task2.service.IViewInfoService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "VIEW_INFO1")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ViewInfo {

	@JsonView(Views.DetailedView.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@JsonView(Views.DetailedView.class)
	@Column(name = "PARENT_FK")
	private Long parentId;
	
	
	@JsonView(Views.BasicView.class)
	@Column(name = "NAME")
	private String name;
	
	@JsonView(Views.BasicView.class)
	@Column(name = "COLOR")
	private String color;

	@JsonView(Views.BasicView.class)
	@Transient
	private List<ViewInfo> subClass;

	@JsonGetter
	private List<ViewInfo> getSubClass() {
		IViewInfoService bean = ApplicationContextProvider.getApplicationContext().getBean(IViewInfoService.class);
		this.subClass = bean.findByParentId(this.id);
		return this.subClass;

	}
	
	public void setSubClass(List<ViewInfo> list) {
		this.subClass=list;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ViewInfo [id=" + id + ", parentId=" + parentId + ", name=" + name + ", color=" + color + ", subClass="
				+ subClass + "]";
	}

}