package com.liuzhen.json;/*
 * @class: Test001
 * @description: 
 * @author L.zhen
 * @create 2016-12-14 16:17
 */

import java.util.Map;

import com.google.gson.Gson;

public class Test001 {
	
	public static void main(String[] args) {
		String str = "{\"sign\":\"804af95d7daf6070d5a7d1d76053e401\",\"protocol\":\"httpJson\",\"orderNo\":\"201610211481702093117\",\"signType\":\"MD5\",\"service\":\"installmentSign\",\"resultCode\":\"ORDER_NO_NOT_UNIQUE\",\"partnerId\":\"20160831020000752643\",\"resultMessage\":\"商户订单号不唯一:写入订单号失败\",\"success\":false,\"version\":\"1.0\",\"testMap\":{\"1\":1,\"2\":2}}";
		Map<String, Object> cacheMap = new Gson().fromJson(str, Map.class);
		Object sign = cacheMap.get("sign");
		System.out.println(sign instanceof String);
		System.out.println(sign instanceof Map);
//		System.out.println(testMap instanceof String);
//		System.out.println(testMap instanceof Map);
		if (sign instanceof String) {
			String sign1 = (String) sign;
		}
		System.out.println(1);
	}
}
