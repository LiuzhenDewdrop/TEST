package com.liuzhen.tread;
/**
 * @class: TestEntity
 * @description: 
 * @author Liuzhen
 */
public class TestEntity {
	
	private String id;
	private String name;
	private String desc;
	
	private static String detail;
	
	public TestEntity() {
		
	}
	
	public TestEntity(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static String getDetail() {
		return detail;
	}
	
	public static void setDetail(String detail) {
		TestEntity.detail = detail;
	}
	
	
}
