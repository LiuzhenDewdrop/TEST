package com.practicality.subway;

/*
 * @class: SubWayModel
 * @description: 
 * @author: L.zhen
 * @date: 2019/1/15 16:41
 */
public class SubWayModel {
	
	private double pieceAmt;	// 单次价格
	private double totalAmt;	// 总价格
	private int times;			// 当月次数
	private double rate;		// 当前折扣率
	
	public double getPieceAmt() {
		return pieceAmt;
	}
	
	public void setPieceAmt(double pieceAmt) {
		this.pieceAmt = pieceAmt;
	}
	
	public double getTotalAmt() {
		return totalAmt;
	}
	
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	public int getTimes() {
		return times;
	}
	
	public void setTimes(int times) {
		this.times = times;
	}
	
	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
}
