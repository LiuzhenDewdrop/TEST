package com.liuzhen.algorithm;
/**
 * @class: MonkeyAndPeach
 * @description: 猴子和桃子
 * 海滩上有一堆桃子，五只猴子来分。
 * 第一只猴子把这堆桃子平均分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。
 * 第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份;
 * 第三、第四、第五只猴子都是这样做的。
 * 问海滩上原来最少有多少个桃子？
 * @author: Liuzhen
 */
public class MonkeyAndPeach {
	
	public void getNum(int peach, int leftMonkey, int monkey) {
		if (leftMonkey == 0) {
			System.out.println(peach);
			for (int i = 0; i < monkey; i++) {
				peach = peach * monkey / (monkey - 1) + 1;
				System.out.println(peach);
			}
			return;
		}
		for (int i = peach; i >= 0; i--) {
			if (i % monkey != 1) {
				return;
			} else {
				getNum((i - 1) * (monkey - 1) / monkey, leftMonkey - 1, monkey);
			}
		}
	}
	
	public void getPeach(int totalMonkey) {
		int radix = 1;			// 桃子基数
		int peach = 0;			// 测试桃子总数量
		int monkeyIndex = 1;	// 第几个猴子
		while (monkeyIndex < totalMonkey) {
			peach = radix * totalMonkey + 1;
			while (monkeyIndex < totalMonkey) {
				if (peach % (totalMonkey - 1) == 0) {
					peach = peach / (totalMonkey - 1) * totalMonkey + 1;
					monkeyIndex++;
				} else {
					monkeyIndex = 1;
					break;
				}
			}
			radix++;
		}
		System.out.println(totalMonkey + "个猴子至少需要：" + peach + "个桃子");
		for (int i = 0; i< monkeyIndex; i++) {
			peach = (peach - 1) / 5 * 4;
			System.out.println("第" + (monkeyIndex - i) + "个猴子有桃子：" + peach + "个");
		}
	}
	
	public static void main(String[] args) {
		MonkeyAndPeach mp = new MonkeyAndPeach();
//		mp.getNum(3121, 5, 5);
		mp.getPeach(5);
	}
}

