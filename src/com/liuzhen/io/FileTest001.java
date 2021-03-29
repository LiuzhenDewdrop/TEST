package com.liuzhen.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import javax.imageio.ImageIO;

import com.liuzhen.app.util.FileUtils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

/**
 * @class: FileTest001
 * @description: 
 * @author: L.zhen
 * @date: 2018/3/9 14:02
 */
public class FileTest001 {
	
	private static boolean[][][] numbers;
	
	public static void main(String[] args) {
//		deal();
//		numbers = initNumbers();
//		test(numbers);
//		printPolicy();
		changeName();
	}
	
	private static void deal() {
		String path = "E:\\Documents\\fhf\\新建文件夹";
//		String path = "E:\\Documents\\fhf";
//		String path = "E:\\Documents\\xjt\\alipay1000";
		File[] list = findFiles(path);
		if (list != null && list.length > 0) {
			for (File file : list) {
				String fileName = file.getName();
				if (fileName.length() == 9) {
					// todo
					getContent(file);
					String newName = path + "\\" + fileName.substring(0, 4) + "_" + fileName.substring(5);
//					file.renameTo(new File(newName));
					System.out.println(newName);
				}
			}
		}
	}
	
	private static File[] findFiles(String path) {
		File file = new File(path);
		return file.listFiles();
	}
	
	private static String getContent(File file) {
		// todo
		try {
			BufferedImage image = ImageIO.read(file);
			// 数字宽度11高度16，第一个数字9，16开始
			int width = image.getWidth();
			int height = image.getHeight();
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					int rgb = image.getRGB(j, i);
					System.out.print(rgb != -1118482 ? "★" : "☆");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * @title:  getNum
	 * @description: 根据字符串，转化为数字
	 * @param str
	 * @return
	 * @author: L.zhen
	 * @date:   2018/3/9 16:36
	 */
	private static boolean[][] getNum(String str) {
		char yes = "★".charAt(0);
		boolean[][] result = new boolean[16][11];
		String[] arr = str.split("\n");
		for (int i = 0; i < arr.length; i++) {
			char[] chars = arr[i].toCharArray();
			for (int j = 0; j < chars.length; j++) {
				result[i][j] = chars[j] == yes;
			}
		}
		return result;
	}
	
	/**
	 * @title:  print
	 * @description: 打印
	 * @param num
	 * @author: L.zhen
	 * @date:   2018/3/9 16:37
	 */
	private static void print(boolean[][] num) {
		for (boolean[] booleans : num) {
			for (boolean b : booleans) {
				System.out.print(b ? "★" : "☆");
			}
			System.out.println();
		}
	}
	
	/**
	 * @title:  initNumbers
	 * @description: 初始化数字
	 * @return
	 * @author: L.zhen
	 * @date:   2018/3/9 16:36
	 */
	private static boolean[][][] initNumbers() {
		boolean[][][] numbers = new boolean[10][16][11];
		String[] strings = getStrings();
		for (int i = 0; i < strings.length; i++) {
			numbers[i] = getNum(strings[i]);
		}
		return numbers;
	}
	
	/**
	 * @title:  getStrings
	 * @description: 获取字符串数组
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/3/9 16:36
	 */
	private static String[] getStrings() {
		String[] strings = new String[10];
		strings[0] = "☆☆☆★★★★☆☆☆☆\n" + "☆☆★★★★★★★☆☆\n" + "☆★★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "★★★★☆☆★★★★☆\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆★★★★★\n" + "★★★★★☆★★★★☆\n" + "☆★★★★★★★★★☆\n" + "☆★★★★★★★★☆☆\n" + "☆☆★★★★★★☆☆☆";
		strings[1] = "☆☆☆☆☆★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆★★★★★★★☆☆☆\n" + "☆★★★★★★★☆☆☆\n" + "☆★★★★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆";
		strings[2] = "☆☆☆★★★★☆☆☆☆\n" + "☆★★★★★★★★☆☆\n" + "☆★★★★★★★★★☆\n" + "★★★★★★★★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★☆☆☆★★★★★\n" + "☆☆☆☆☆★★★★★☆\n" + "☆☆☆★★★★★★★☆\n" + "☆☆★★★★★★★☆☆\n" + "☆★★★★★★★☆☆☆\n" + "★★★★★★☆☆☆☆☆\n" + "★★★★☆☆☆☆☆☆☆\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★★";
		strings[3] = "☆☆☆☆★★★☆☆☆☆\n" + "☆☆★★★★★★★☆☆\n" + "☆★★★★★★★★★☆\n" + "★★★★★★★★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★★★★★★★★\n" + "☆☆☆★★★★★★★☆\n" + "☆☆☆★★★★★★★☆\n" + "☆☆☆★★★★★★★★\n" + "★★★☆☆☆★★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆★★★★★\n" + "★★★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "☆☆★★★★★★★☆☆";
		strings[4] = "☆☆☆☆☆☆☆★★★☆\n" + "☆☆☆☆☆☆★★★★☆\n" + "☆☆☆☆☆★★★★★☆\n" + "☆☆☆☆★★★★★★☆\n" + "☆☆☆☆★★★★★★☆\n" + "☆☆☆★★★★★★★☆\n" + "☆☆★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "☆★★★★☆★★★★☆\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★★\n" + "☆☆☆☆☆☆★★★★☆\n" + "☆☆☆☆☆☆★★★★☆\n" + "☆☆☆☆☆☆★★★★☆";
		strings[5] = "☆★★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "★★★★★★★☆☆☆☆\n" + "★★★★★★★★★☆☆\n" + "★★★★★★★★★★☆\n" + "★★★★★★★★★★☆\n" + "★★★★☆☆★★★★★\n" + "☆☆☆☆☆☆☆★★★★\n" + "★★★☆☆☆☆★★★★\n" + "★★★☆☆☆☆★★★★\n" + "★★★★☆★★★★★☆\n" + "★★★★★★★★★★☆\n" + "☆★★★★★★★★☆☆\n" + "☆☆★★★★★★☆☆☆";
		strings[6] = "☆☆☆☆☆★★☆☆☆☆\n" + "☆☆★★★★★★★☆☆\n" + "☆★★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "★★★★★☆★★★★☆\n" + "★★★★☆★★★★★★\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★☆\n" + "★★★★★★★★★★☆\n" + "★★★★★☆★★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★★☆★★★★★\n" + "☆★★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "☆☆★★★★★★★☆☆";
		strings[7] = "★★★★★★★★★★★\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★★\n" + "☆☆☆☆☆☆★★★★☆\n" + "☆☆☆☆☆★★★★★☆\n" + "☆☆☆☆☆★★★★☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆☆★★★★☆☆☆\n" + "☆☆☆★★★★☆☆☆☆\n" + "☆☆☆★★★★☆☆☆☆\n" + "☆☆★★★★☆☆☆☆☆\n" + "☆☆★★★★☆☆☆☆☆\n" + "☆☆★★★★☆☆☆☆☆\n" + "☆☆★★★★☆☆☆☆☆\n" + "☆★★★★☆☆☆☆☆☆";
		strings[8] = "☆☆☆★★★★★☆☆☆\n" + "☆★★★★★★★★☆☆\n" + "☆★★★★★★★★★☆\n" + "★★★★★★★★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★★★★★★★★\n" + "☆★★★★★★★★★☆\n" + "☆★★★★★★★★★☆\n" + "★★★★★★★★★★☆\n" + "★★★★★☆★★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★★☆★★★★☆\n" + "★★★★★★★★★★☆\n" + "☆★★★★★★★★☆☆\n" + "☆☆★★★★★★☆☆☆";
		strings[9] = "☆☆☆☆★★★☆☆☆☆\n" + "☆☆★★★★★★★☆☆\n" + "☆★★★★★★★★★☆\n" + "★★★★★★★★★★☆\n" + "★★★★☆☆★★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★☆☆☆★★★★\n" + "★★★★★★★★★★★\n" + "★★★★★★★★★★★\n" + "☆★★★★★★★★★★\n" + "☆☆★★★★★★★★★\n" + "★★★★☆☆★★★★☆\n" + "★★★★★☆★★★★☆\n" + "☆★★★★★★★★★☆\n" + "☆★★★★★★★★☆☆\n" + "☆☆★★★★★★☆☆☆";
		return strings;
	}
	
	/**
	 * @title:  getNum
	 * @description: 获取某个数字
	 * @param i
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/3/9 16:38
	 */
	private static boolean[][] getNum(int i) {
		if (i > -1 && i < 10) {
			return numbers[i];
		} else {
			return null;
		}
	}
	
	/**
	 * @title:  printCol
	 * @description: 打印纵向
	 * @param num
	 * @param index
	 * @param printMode		打印模式：0、不打印；1、纵向打印；2、横向打印
	 * @return
	 * @author: L.zhen
	 * @date:   2018/3/9 17:15
	 */
	private static boolean[] printCol(boolean[][] num, int index, int printMode) {
		if (index > -1 && index < 11) {
			boolean[] result = new boolean[16];
			for (int i = 0; i < num.length; i++) {
				result[i] = num[i][index];
				if (printMode == 1) {
					System.out.println(num[i][index] ? "★" : "☆");
				} else if (printMode == 2) {
					System.out.print(num[i][index] ? "★" : "☆");
				}
			}
			if (printMode == 2) {
				System.out.println();
			}
			return result;
		} else {
			return null;
		}
	}
	
	private static boolean[] printRow(boolean[][] num, int index, int printMode) {
		if (index > -1 && index < 16) {
			boolean[] result = num[index];
			if (printMode == 1) {
				for (boolean b : result) {
					System.out.println(b ? "★" : "☆");
				}
			}
			return result;
		} else {
			return null;
		}
	}
	
	/**
	 * @title:  changeTimes
	 * @description: 从进入图形开始的改变次数
	 * @param num
	 * @return
	 * @author: L.zhen
	 * @date:   2018/3/9 17:10
	 */
	private static int changeTimes(boolean[] num) {
		int result = -1;
		boolean start = false;
		for (boolean b : num) {
			if (b ^ start) {
				result++;
				start = b;
			}
		}
		return result;
	}
	
	/**
	 * @title:  countCircles
	 * @description: 几个孔
	 * @param num
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/3/9 17:10
	 */
	private static int countCircles(boolean[] num) {
		return changeTimes(num) / 2;
	}
	
	private static int countMaxLineLength(boolean[] num) {
		int result = 0;
		int temp = 0;
		for (boolean b : num) {
			if (b) {
				temp++;
			} else {
				if(temp > result) {
					result = temp;
				}
				temp = 0;
			}
		}
		return result > temp ? result : temp;
	}
	
	private static NumBean getNumBean(boolean[][] numbers) {
		// 获取数字
		NumBean num = new NumBean(numbers);
		// 横向
		int[] rowCircles = new int[16];
		int[] rowLineLength = new int[16];
		String rowCircle = "";
		int rowCircleTemp = 0;
		int rowLine = 0;
		int rowLineTemp = 0;
		int rowLineCount = 0;
		for (int j = 0; j < 16; j++) {
			boolean[] b = printRow(num.getNum(), j, 0);
			rowCircles[j] = countCircles(b);
			rowLineLength[j] = countMaxLineLength(b);
			if (j == 0) {
				rowCircleTemp = rowCircles[j];
				rowCircle = rowCircleTemp + "";
			} else if (rowCircleTemp != rowCircles[j]) {
				rowCircleTemp = rowCircles[j];
				rowCircle += rowCircleTemp;
			}
			
			if (rowLineCount == 0) {
				rowLineTemp = rowLineLength[j];
				if (rowLineTemp > 0) {
					rowLineCount++;
				}
			} else if (rowLineTemp == rowLineLength[j]) {
				if (rowLineCount == 2) {
					if (rowLineTemp > rowLine) {
						rowLine = rowLineTemp;
					}
					rowLineCount = 0;
				} else {
					rowLineCount++;
				}
			} else {
				rowLineCount = 0;
				rowLineTemp = rowLineLength[j];
				if (rowLineTemp > 0) {
					rowLineCount++;
				}
			}
		}
		num.setRowCircles(rowCircles);
		num.setRowLineLength(rowLineLength);
		num.setRowCircle(rowCircle);
		num.setRowLine(rowLine > 4 ? rowLine : 0);
		// 纵向
		int[] colCircles = new int[11];
		int[] colLineLength = new int[11];
		String colCircle = "";
		int colCircleTemp = 0;
		int colLine = 0;
		int colLineTemp = 0;
		int colLineCount = 0;
		for (int j = 0; j < 11; j++) {
			boolean[] b = printCol(num.getNum(), j, 0);
			colCircles[j] = countCircles(b);
			colLineLength[j] = countMaxLineLength(b);
			if (j == 0) {
				colCircleTemp = colCircles[j];
				colCircle = colCircleTemp + "";
			} else if (colCircleTemp != colCircles[j]) {
				colCircleTemp = colCircles[j];
				colCircle += colCircleTemp;
			}
			
			if (colLineCount == 0) {
				colLineTemp = colLineLength[j];
				if (colLineTemp > 0) {
					colLineCount++;
				}
			} else if (colLineTemp == colLineLength[j]) {
				if (colLineCount == 2) {
					if (colLineTemp > colLine) {
						colLine = colLineTemp;
					}
					colLineCount = 0;
				} else {
					colLineCount++;
				}
			} else {
				colLineCount = 0;
				colLineTemp = colLineLength[j];
				if (colLineTemp > 0) {
					colLineCount++;
				} 
			}
		}
		num.setColCircles(colCircles);
		num.setColLineLength(colLineLength);
		num.setColCircle(colCircle);
		num.setColLine(colLine > 4 ? colLine : 0);
		return num;
	}
	
	/**
	 * @title:  getNumBeans
	 * @description: 获取各个数字的信息
	 * @param numbers
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/3/9 17:19
	 */
	private static NumBean[] getNumBeans(boolean[][][] numbers) {
		NumBean[] result = new NumBean[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = getNumBean(numbers[i]);
		}
		return result;
	}
	
	private static void test(boolean[][][] numbers) {
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println(i + ":");
//			System.out.println(countCircles(printCol(numbers[i], 5, 2)));
//		}
		NumBean[] circles = getNumBeans(numbers);
		for (int i = 0; i < circles.length; i++) {
			System.out.println(i + ":");
			System.out.println("横向孔数" + Arrays.toString(circles[i].getRowCircles()));
			System.out.println("横向孔数趋势" + circles[i].getRowCircle());
			System.out.println("纵向孔数" + Arrays.toString(circles[i].getColCircles()));
			System.out.println("纵向孔数趋势" + circles[i].getColCircle());
			System.out.println("横向长线" + Arrays.toString(circles[i].getRowLineLength()));
			System.out.println("横向有效长线" + circles[i].getRowLine());
			System.out.println("纵向长线" + Arrays.toString(circles[i].getColLineLength()));
			System.out.println("纵向有效长线" + circles[i].getColLine());
		}
	}
	
	private static int analyse(NumBean nb) {
		
		return 0;
	}
	
	private static void printPolicy() {
		String path = "D:\\Downloads\\BaiduNetdisk\\02.强化班";
//		String tempPath = "D:\\Downloads\\BaiduNetdisk\\02.强化班\\temp\\";
		File[] list = findFiles(path);
		Encoder encoder = new Encoder();
		int i = 0;
		for (File dir : list) {
			if ("temp".equals(dir.getName())) {
				continue;
			}
			for (File file : Objects.requireNonNull(dir.listFiles())) {
//				if (file.getName().contains(".downloading")) {
//					System.out.println(++i + file.getName());
//					file.renameTo(new File(tempPath + file.getName()));
//					continue;
//				}
//				file.renameTo(new File(file.getAbsolutePath().replaceAll("【公众号：思雨考研】", "").replaceAll(" ", "")));
				String name = FileUtils.getName(file);
				char[] nChars = name.toCharArray();
				if ('0' == nChars[name.length() - 2]) {
					nChars[name.length() - 2] = '-';
//					file.renameTo(new File(file.getAbsolutePath().replaceAll(name, String.valueOf(nChars))));
				}
				System.out.print("【" + dir.getName() + "】" + FileUtils.getName(file) + "\t");
				try {
					MultimediaInfo info = encoder.getInfo(file);
					long d = info.getDuration();
					d /= 1000;
					long ss = d % 60;
					d /= 60;
					long mm = d % 60;
					long hh = d / 60;
					StringBuilder dStr = new StringBuilder("");
					if (hh != 0) {
						dStr.append(hh).append(".");
					}
					if (mm < 10) {
						dStr.append(0);
					}
					dStr.append(mm);
					if (ss != 0) {
						dStr.append(".");
						if (ss < 10) {
							dStr.append(0).append(ss);
						} else if (ss % 10 == 0) {
							dStr.append(ss/10);
						} else {
							dStr.append(ss);
						}
					} else if (hh != 0) {
						dStr.append(".");
						dStr.append(0).append(0);
					}
//					System.out.println(hh + "." + mm + "." + ss + "\t" + info.getDuration() + "\t" + dStr);
					System.out.println(dStr);
				} catch (EncoderException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(1);
	}
	
	private static void changeName(){
		String path = "D:\\Downloads\\BaiduNetdisk\\天龙八部97版";
		File[] list = findFiles(path);
		for (File file : list) {
			String[] arr = file.getName().split("\\.");
			System.out.println(arr[0]);
			System.out.println(arr[1]);
			if ("mkv1".equals(arr[1])) {
				file.renameTo(new File(path + "\\" + arr[0] + ".mkv"));
			}
		}
	}
}
