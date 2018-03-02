package com.liuzhen.util;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.CPInfo;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.constants.ConstantLongInfo;
/**
 * @class: JClassLabUtil
 * @description: jclasslab工具的应用
 * @author: L.zhen
 * @date: 2018/3/2 16:57
 */
public class JClassLabUtil {
	
	public static void main(String[] args) throws Exception {
		
		String filePath = "D:\\Download\\QQDownload\\api-test\\org\\apache\\jmeter\\functions\\IflytekTestValidity.class";   //class所在路径
		FileInputStream fis = new FileInputStream(filePath);
		
		DataInput di = new DataInputStream(fis);
		ClassFile cf = new ClassFile();
		cf.read(di);
		CPInfo[] infos = cf.getConstantPool();
		
		int count = infos.length;
		for (int i = 0; i < count; i++) {
			if (infos[i] != null) {
				System.out.print(i);
				System.out.print(" = ");
				System.out.print(infos[i].getVerbose());
				System.out.print(" = ");
				System.out.println(infos[i].getTagVerbose());
				if (i == 48) {
//					ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];
					ConstantLongInfo uInfo = (ConstantLongInfo)infos[i];
					uInfo.setLong(2555942400000L);
					infos[i] = uInfo;
				}
			}
		}
		cf.setConstantPool(infos);
		fis.close();
		File f = new File(filePath);
		ClassFileWriter.writeToFile(f, cf);
	}
}
