package com.liuzhen.list.merge;
/**
 * @class: TestBean
 * @description: 
 * @author Liuzhen
 */
public class TestBean {
	private Integer key;
	private Integer value;
	
	public TestBean() {
	}
	
	public TestBean(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}
	
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
}
