package com.api.tq;
/**
 * @enum: Mastery
 * @description: 
 * @author: L.zhen
 * @date: 2021/2/17 10:36
 */
public enum Mastery {
	WARFARE(0b001000000, "战斗"),
	SPIRIT (0b000000000, "死灵"),
	NATURE (0b000000001, "自然"),
	ROGUE  (0b000000010, "盗贼"),
	HUNTING(0b000000100, "狩猎"),
	STORM  (0b000001000, "风暴"),
	EARTH  (0b000010000, "大地"),
	DEFENSE(0b000100000, "防御"),
	DREAM  (0b010000000, "梦幻"),
	RUNE   (0b100000000, "符文");
	
	Mastery(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	private int code;
	private String name;
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
