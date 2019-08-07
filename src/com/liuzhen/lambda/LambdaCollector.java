package com.liuzhen.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.liuzhen.model.BaseModel;

/**
 * @class: LambdaCollector
 * @description: 
 * @author: L.zhen
 * @date: 2018/2/7 15:58
 */
public class LambdaCollector {
	
	public static void main(String[] args) {
//		test001();
//		test002();
//		test003();
		test004();
	}
	
	private static List<BaseModel> createList() {
		List<BaseModel> list = new ArrayList<>();
		list.add(new BaseModel(4, "ddd", "f"));
		list.add(new BaseModel(3, "ccc", "m"));
		list.add(new BaseModel(5, "eee", "f"));
		list.add(new BaseModel(1, "aaa", "f"));
		list.add(new BaseModel(2, "bbb", "m"));
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
	
	private static void test002() {
		Integer[] arr = new Integer[]{4, 7, 2, 6, 1, 5, 3};
		Integer[] arr1 = arr.clone();
		Stream.of(arr).sorted((s1, s2) -> {
			System.out.println(s1 + ", " + s2);
			return s1.compareTo(s2);
		}).forEach(System.out::println);
		
		insertSort(arr1);
		System.out.println(Arrays.toString(arr1));
	}
	
	private static void insertSort(Integer[] arr) {
		for (int i = 1; i <arr.length ; i++) {
			System.out.println(arr[i - 1] + ", " + arr[i]);
			if (arr[i - 1] > arr[i]) {
				int temp = arr[i];
				arr[i] = arr[i - 1];
				int j = i - 1;
				while (--j != -1 && temp < arr[j]) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = temp;
			}
		}
	}
	
	private static void test003() {
		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			list.add(new Integer((int) (Math.random() * 100)));
//		}
		System.out.println(Arrays.toString(list.toArray()));
		list.stream().sorted().collect(Collectors.toList());
		System.out.println(Arrays.toString(list.stream().sorted().toArray()));
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	private static void test004() {
		List<BaseModel> list = createList();
		List<String> nameList = list.stream().map(BaseModel::getName).collect(Collectors.toList());
		if (nameList == null) {
			System.out.println("size: is null !" );
		} else {
			System.out.println("size:" + nameList.size());
			System.out.println(Arrays.toString(nameList.toArray()));
		}
	}
}
