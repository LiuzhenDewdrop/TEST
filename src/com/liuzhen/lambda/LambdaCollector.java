package com.liuzhen.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.liuzhen.model.BaseModel;

/**
 * @class: LambdaCollector
 * @description: 
 * @author: L.zhen
 * @date: 2018/2/7 15:58
 */
public class LambdaCollector {
	
	public static void main(String[] args) {
		test001();
	}
	
	private static List<BaseModel> createList() {
		List<BaseModel> list = new ArrayList<>();
		list.add(new BaseModel(1, "aaa", "f"));
		list.add(new BaseModel(2, "bbb", "m"));
		list.add(new BaseModel(3, "ccc", "m"));
		list.add(new BaseModel(4, "ddd", "f"));
		list.add(new BaseModel(5, "eee", "f"));
		return list;
	}
	
	private static void test001() {
		List<BaseModel> list = createList();
		List<BaseModel> testList = list.stream().filter(baseModel -> "f".equals(baseModel.getSex())).collect(Collectors.toList());
		if (testList == null) {
			System.out.println("size: is null !" );
		} else {
			System.out.println("size:" + testList.size());
			for (BaseModel baseModel : testList) {
				System.out.print("id: " + baseModel.getId());
				System.out.print(" ,name: " + baseModel.getName());
				System.out.println(" ,sex: " + baseModel.getSex());
			}
		}
	}
}
