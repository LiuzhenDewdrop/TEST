package com.liuzhen.algorithm.greedy;

import java.util.Arrays;

/**
 * @class: WorkDispatch
 * @description: 作业调度
 * 根据截止时间(deadline)和收益(profit)部署任务(job)顺序
 * @author: Liuzhen
 */
public class WorkDispatch {
	
	private int length;
	private String[] job;
	private int[] deadline;
	private int[] profit;
	
	
	public WorkDispatch(int length, String[] job, int[] deadline, int[] profit) {
		this.length = length;
		this.job = job;
		this.deadline = deadline;
		this.profit = profit;
	}
	
	public static void main(String[] args) {
		WorkDispatch wd = createWorkDispatch();
		if (wd == null) {
			System.out.println("创建错误");
			System.exit(0);
		}
		String[] result = alg(wd);
		System.out.println(Arrays.toString(result));
	}
	
	public static WorkDispatch createWorkDispatch() {
		int length = 5;
		String[] job = {"a", "b", "c", "d", "e"};
		int[] deadline = {2, 1, 2, 1, 3};
		int[] profit = {100, 19, 27, 25, 15};
		if (job.length != length || deadline.length != length || profit.length != length) {
			return null;
		}
		return new WorkDispatch(length, job, deadline, profit);
	}
	
	public static String[] alg(WorkDispatch wd) {
		int length = wd.length;
		String[] job = wd.job;
		int[] deadline = wd.deadline;
		int[] profit = wd.profit;
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (profit[j] < profit[j + 1]) {
					int tempInt = profit[j];
					profit[j] = profit[j + 1];
					profit[j + 1] = tempInt;
					tempInt = deadline[j];
					deadline[j] = deadline[j + 1];
					deadline[j + 1] = tempInt;
					String tempStr = job[j];
					job[j] = job[j + 1];
					job[j + 1] = tempStr;
				}
			}
		}
		boolean[] mark = new boolean[length];
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			for (int j = (deadline[i] < length ? deadline[i] : length) - 1; j >= 0; j--) {
				if (!mark[j]) {
					result[j] = job[i];
					mark[j] = true;
					break;
				}
			}
		}
		return result;
	}
}
