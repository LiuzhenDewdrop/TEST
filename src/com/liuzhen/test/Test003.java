package com.liuzhen.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @class: Test003
 * @description: 
 * @author Liuzhen
 */
public class Test003 {
	
	public static void main(String[] args) {
		Map<String, Object> inMap = createMap();
		Map<String, Object> temp = new HashMap<>();
		temp.putAll(inMap);
		Map<String, Object> outMap = dealWithMap1(inMap);
		System.exit(0);
	}
	
	private static Map<String, Object> createMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("mapKey", "mapKey");
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Map<String, Object> temp = new HashMap<>();
			temp.put("fund", new BigDecimal(i + 1));
			temp.put("id", i + 1L);
			list.add(temp);
		}
		Map<String, Object> result = new HashMap<>();
		result.put("map", map);
		result.put("list", list);
		return result;
	}
	
	private static Map<String, Object> dealWithMap(Map<String, Object> inputMap) {
		Map<String, Object> inMap = new HashMap<>();
		inMap.putAll(inputMap);
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> list = (List<Map<String, Object>>) inMap.get("list");
		for (Map<String, Object> temp : list) {
			temp.put("fund", ((BigDecimal) temp.get("fund")).add(new BigDecimal(10)));
			temp.put("id", ((Long) temp.get("id")) + 10L);
		}
		Map<String, Object> map = (Map<String, Object>) inMap.get("map");
		result.put("mapKey", "");
		result.put("list", list);
		return result;
	}
	
	private static Map<String, Object> dealWithMap1(Map<String, Object> inMap) {
		List<Map<String, Object>> list = (List<Map<String, Object>>) inMap.get("list");
		List<Map<String, Object>> tempList = new ArrayList<>(list.size());
		for (Map<String, Object> map : list) {
			Map<String, Object> temp = new HashMap<>();
			for (Map.Entry e : map.entrySet()) {
				temp.put(e.getKey().toString(), e.getValue());
			}
			tempList.add(temp);
		}
		for (Map<String, Object> temp : tempList) {
			temp.put("fund", ((BigDecimal) temp.get("fund")).add(new BigDecimal(10)));
			temp.put("id", ((Long) temp.get("id")) + 10L);
		}
		Map<String, Object> result = new HashMap<>();
		result.put("mapKey", "");
		result.put("list", tempList);
		return result;
	}
}
