package com.liuzhen.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.exception.DecodingFailedException;
import com.liuzhen.img.qrcode.QRBean;

public class ImgHelper {

	/**
	 * 把图片读取成二维数组
	 */
	private int[][] createIntArr(BufferedImage bufImg) {
		int x = bufImg.getWidth();
		int y = bufImg.getHeight();
		int[][] imgInt = new int[y][x];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				imgInt[i][j] = bufImg.getRGB(i, j);
				// -1是黑, -16777216是白
				//System.out.print(imgInt[i][j] == -1? "田": "〇");
				System.out.print(imgInt[i][j]);
			}
			System.out.println();
		}
		return imgInt;
	}
	
	/**
	 * 找到黑色像素点
	 */
	private List<String> findBlackPoints(BufferedImage bufImg, int pixoff) {
		int x = bufImg.getWidth();
		int y = bufImg.getHeight();
		List<String> result = new ArrayList<String>();
		for (int i = pixoff; i < y; i++) {
			for (int j = pixoff; j < x; j++) {
				if (bufImg.getRGB(j, i) != -1 && !(
					(pixoff<= j && j<=20 + pixoff && pixoff<= i && i<=20 + pixoff) ||	// 0<=x<=20且0<=y<=20
					(114 + pixoff<= j && j<=134 + pixoff && pixoff<= i && i<=20 + pixoff) ||	// 114<=x<=134且0<=y<=20
					(114 + pixoff<= i && i<=134 + pixoff && pixoff<= j && j<=20 + pixoff)		// 114<=y<=134且0<=x<=20
					)) {
					result.add(j + "," + i);
					j = j + 2;
				}
			}
			i = i + 2;
		}
		return result;
	}
	
	/**
	 * 把图片精简化
	 */
	private BufferedImage createNewImg(BufferedImage bufImg, String testResult) {
		List<String> list = findBlackPoints(bufImg, 1);
		QRCodeDecoder qr = new QRCodeDecoder();
		//bufImg.setRGB(13, 136, rgb)
		for (String str: list) {
			System.out.println(str);
			String[] strArr = str.split(",");
			int x = Integer.parseInt(strArr[0]);
			int y = Integer.parseInt(strArr[1]);
			System.out.println(bufImg.getRGB(x, y));
			bufImg.setRGB(x, y, -1);
			bufImg.setRGB(x + 1, y, -1);
			bufImg.setRGB(x + 2, y, -1);
			bufImg.setRGB(x, y + 1, -1);
			bufImg.setRGB(x + 1, y + 1, -1);
			bufImg.setRGB(x + 2, y + 1, -1);
			bufImg.setRGB(x, y + 2, -1);
			bufImg.setRGB(x + 1, y + 2, -1);
			bufImg.setRGB(x + 2, y + 2, -1);
			String testStr;
			try {
				testStr = new String(qr.decode(new QRBean(bufImg)), "gb2312");
				if (!testResult.equals(testStr)) {
					bufImg.setRGB(x, y, -16777216);
					bufImg.setRGB(x + 1, y, -16777216);
					bufImg.setRGB(x + 2, y, -16777216);
					bufImg.setRGB(x, y + 1, -16777216);
					bufImg.setRGB(x + 1, y + 1, -16777216);
					bufImg.setRGB(x + 2, y + 1, -16777216);
					bufImg.setRGB(x, y + 2, -16777216);
					bufImg.setRGB(x + 1, y + 2, -16777216);
					bufImg.setRGB(x + 2, y + 2, -16777216);
				}
			} catch (DecodingFailedException e) {
				bufImg.setRGB(x, y, -16777216);
				bufImg.setRGB(x + 1, y, -16777216);
				bufImg.setRGB(x + 2, y, -16777216);
				bufImg.setRGB(x, y + 1, -16777216);
				bufImg.setRGB(x + 1, y + 1, -16777216);
				bufImg.setRGB(x + 2, y + 1, -16777216);
				bufImg.setRGB(x, y + 2, -16777216);
				bufImg.setRGB(x + 1, y + 2, -16777216);
				bufImg.setRGB(x + 2, y + 2, -16777216);
				e.printStackTrace();
				System.out.println("aaaaaa" + x + "," + y);
			} catch (UnsupportedEncodingException e) {
				bufImg.setRGB(x, y, -16777216);
				bufImg.setRGB(x + 1, y, -16777216);
				bufImg.setRGB(x + 2, y, -16777216);
				bufImg.setRGB(x, y + 1, -16777216);
				bufImg.setRGB(x + 1, y + 1, -16777216);
				bufImg.setRGB(x + 2, y + 1, -16777216);
				bufImg.setRGB(x, y + 2, -16777216);
				bufImg.setRGB(x + 1, y + 2, -16777216);
				bufImg.setRGB(x + 2, y + 2, -16777216);
				e.printStackTrace();
				System.out.println("bbbbbb" + x + "," + y);
			}
		}
		return bufImg;
	}
	
	public static void main(String[] args) {
		ImgHelper ih = new ImgHelper();
		String imgPath = "D:/desk/关机/qr_1473328722865.png";
		String content = "http://a.eqxiu.com/s/MXtrxQfo?eqrcode=1";
		BufferedImage bufImg = null;
		try {
			bufImg = ImageIO.read(new File(imgPath));
			//ih.createIntArr(bufImg);
			BufferedImage newImg = ih.createNewImg(bufImg, content);
			ImageIO.write(newImg, "png", new File("D:/desk/关机/qr_" + System.currentTimeMillis() + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
