package com.liuzhen.clock;

import java.util.Date;

/**
 * @class: WorkTimer
 * @description: 
 * @author: L.zhen
 * @date: 2017/11/20 16:49
 */
public class WorkTimer {

	public static void main(String[] args) {
		getOpenComputerTime();
	}
	
	private static void getOpenComputerTime() {
		System.out.println(new Date(new Date().getTime() - System.nanoTime() / 1000 / 1000));
	}
}
