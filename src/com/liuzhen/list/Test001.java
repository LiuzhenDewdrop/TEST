package com.liuzhen.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @class: Test001
 * @description: 
 * @author Liuzhen
 */
public class Test001 {
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("index", i + 1);
			map.put("test", "aaa" + i);
			list.add(map);
		}
		
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			if ((int) map.get("index") == 2 || (int) map.get("index") == 3) {
				list.remove(i--);
			}
		}
		
		System.out.println("null test start..."); // 报错NullPointerException
		List<Map<String, Object>> list1 = null;
		for (Map<String, Object> map : list1) {
			System.out.println(map.get(1));
		}
		System.exit(0);
	}
}
