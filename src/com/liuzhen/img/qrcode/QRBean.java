//package com.liuzhen.img.qrcode;
//
//import java.awt.image.BufferedImage;
//
//import jp.sourceforge.qrcode.data.QRCodeImage;
//
//public class QRBean implements QRCodeImage {
//
//	private BufferedImage bufImg;
//
//	public QRBean(BufferedImage bufImg) {
//		this.bufImg = bufImg;
//	}
//
//	@Override
//	public int getHeight() {
//		return bufImg.getHeight();
//	}
//
//	@Override
//	public int getPixel(int arg0, int arg1) {
//		return bufImg.getRGB(arg0, arg1);
//	}
//
//	@Override
//	public int getWidth() {
//		return bufImg.getWidth();
//	}
//}
