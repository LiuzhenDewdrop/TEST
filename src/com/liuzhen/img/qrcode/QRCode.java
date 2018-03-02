//package com.liuzhen.img.qrcode;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//
//import jp.sourceforge.qrcode.QRCodeDecoder;
//import jp.sourceforge.qrcode.exception.DecodingFailedException;
//
//import com.swetake.util.Qrcode;
//
//public class QRCode {
//
//	/**
//	* 生成二维码图片
//	*/
//	public void encoderQRCode(String content, String imgPath) {
//		try {
//			Qrcode qrcodeHandler = new Qrcode();
//			qrcodeHandler.setQrcodeErrorCorrect('M');
//			qrcodeHandler.setQrcodeEncodeMode('B');
//			qrcodeHandler.setQrcodeVersion(7);
//			System.out.println(content);
//			byte[] contentBytes = content.getBytes("gb2312");
//			BufferedImage bufImg = new BufferedImage(47, 47, BufferedImage.TYPE_INT_RGB);
//			Graphics2D gs = bufImg.createGraphics();
//			gs.setBackground(Color.WHITE);
//			gs.clearRect(0, 0, 47, 47);
//			// 设定图像颜色:BLACK
//			gs.setColor(Color.BLACK);
//			// 设置偏移量,不设置可能导致解析出错
//			int pixoff = 1;
//			// 输出内容
//			if (contentBytes.length > 0 && contentBytes.length < 120) {
//				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
//				System.out.println(codeOut.length);
//				System.out.println(codeOut[0].length);
//				for (int i = 0; i < codeOut.length; i++) {
//					for (int j = 0; j < codeOut.length; j++) {
//						if (codeOut[j][i]) {
//							//gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
//							gs.fillRect(j, i, 1, 1);
//						}
//					}
//				}
//			} else {
//				System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,120 ]. ");
//			}
//			gs.dispose();
//			bufImg.flush();
//			File imgFile = new File(imgPath);
//			// 生成二维码QRCode图片
//			ImageIO.write(bufImg, "png", imgFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	* 解读二维码图片
//	*/
//	public String decoderQRCode(String imgPath) {
//		File imageFile = new File(imgPath);
//		BufferedImage bufImg = null;
//		String decodedData = null;
//		try {
//			bufImg = ImageIO.read(imageFile);
//			QRCodeDecoder qr = new QRCodeDecoder();
//			decodedData = new String(qr.decode(new QRBean(bufImg)), "gb2312");
//		} catch (IOException e) {
//			System.out.println("Error: " + e.getMessage());
//			e.printStackTrace();
//		} catch (DecodingFailedException e) {
//			System.out.println("Error: " + e.getMessage());
//			e.printStackTrace();
//		}
//		return decodedData;
//	}
//
//	public static void main(String[] args) {
//		String imgPathOut = "D:/desk/关机/qr_" + System.currentTimeMillis() + ".png";
//		System.out.println(imgPathOut);
//		String imgPathIn = "D:/desk/关机/qr_1473328722865.png";
//		String content = "hello word 刘振 ~ ！";
//		QRCode qr = new QRCode();
//		qr.encoderQRCode(content, imgPathOut);
//		//System.out.println(qr.decoderQRCode(imgPathIn));
//		System.exit(0);
//	}
//}