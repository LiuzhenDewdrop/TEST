package com.master.matrix;

import lombok.Data;

/**
 * @class: MatrixModel
 * @description: 
 * @author: L.zhen
 * @date: 2020/3/22 13:28
 */
@Data
public class MatrixModel {
	
	private String name;
	private CellModel[][] matrix;
	private int row;
	private int col;
	
	public MatrixModel(String name, CellModel[][] matrix, int row, int col) {
		this.name = name;
		this.matrix = matrix;
		this.row = row;
		this.col = col;
	}
	
	public MatrixModel(String name, int row, int col) {
		this.name = name;
		this.row = row;
		this.col = col;
		this.matrix = new CellModel[row][col];
	}
}
