package com.liuzhen.io;
/**
 * @class: NumBean
 * @description: 
 * @author: L.zhen
 * @date: 2018/3/9 17:28
 */
public class NumBean {
	
	public NumBean() {
	}
	
	public NumBean(boolean[][] num) {
		this.num = num;
	}
	
	private boolean[][] num;
	private int[] rowCircles;			// 横向孔数
	private int[] colCircles;			// 纵向孔数
	private int[] rowLineLength;		// 横向最长线
	private int[] colLineLength;		// 纵向最长线
	
	private String rowCircle;			// 横向孔数趋势
	private String colCircle;			// 纵向孔数趋势
	
	private int rowLine;				// 有效横长
	private int colLine;				// 有效纵长
	
	public boolean[][] getNum() {
		return num;
	}
	
	public void setNum(boolean[][] num) {
		this.num = num;
	}
	
	public int[] getRowCircles() {
		return rowCircles;
	}
	
	public void setRowCircles(int[] rowCircles) {
		this.rowCircles = rowCircles;
	}
	
	public int[] getColCircles() {
		return colCircles;
	}
	
	public void setColCircles(int[] colCircles) {
		this.colCircles = colCircles;
	}
	
	public int[] getRowLineLength() {
		return rowLineLength;
	}
	
	public void setRowLineLength(int[] rowLineLength) {
		this.rowLineLength = rowLineLength;
	}
	
	public int[] getColLineLength() {
		return colLineLength;
	}
	
	public void setColLineLength(int[] colLineLength) {
		this.colLineLength = colLineLength;
	}
	
	public String getRowCircle() {
		return rowCircle;
	}
	
	public void setRowCircle(String rowCircle) {
		this.rowCircle = rowCircle;
	}
	
	public String getColCircle() {
		return colCircle;
	}
	
	public void setColCircle(String colCircle) {
		this.colCircle = colCircle;
	}
	
	public int getRowLine() {
		return rowLine;
	}
	
	public void setRowLine(int rowLine) {
		this.rowLine = rowLine;
	}
	
	public int getColLine() {
		return colLine;
	}
	
	public void setColLine(int colLine) {
		this.colLine = colLine;
	}
}
