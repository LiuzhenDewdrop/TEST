package com.master.matrix;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @class: CellModel
 * @description: 
 * @author: L.zhen
 * @date: 2020/3/22 13:32
 */
@Data
public class CellModel {
	
	private int rowIndex;
	private int colIndex;
	private String name;
	private BigDecimal value;
	private String expression;
	
	public CellModel(int rowIndex, int colIndex, String name, BigDecimal value) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
		this.name = name;
		this.value = value;
	}
}
