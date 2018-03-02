package com.liuzhen.model;
/**
 * @class: BaseModel
 * @description: 
 * @author: L.zhen
 * @date: 2018/2/7 15:59
 */
public class BaseModel {
	
	private Integer id;
	private String name;
	private String sex;
	
	public BaseModel(Integer id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
}
