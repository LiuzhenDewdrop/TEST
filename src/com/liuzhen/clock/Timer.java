package com.liuzhen.clock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer extends Thread {

	private long interval = 1000l;		// 间隔,默认1s
	
	public Timer() {
	}
	
	public Timer(long interval) {
		this.interval = interval;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println(sdf.format(new Date()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
