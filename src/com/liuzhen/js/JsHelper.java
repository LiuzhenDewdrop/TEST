package com.liuzhen.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.liuzhen.app.util.FileUtils;

/*
 * @class: JsHelper
 * @description: 
 * @author: L.zhen
 * @date: 2018/5/30 16:11
 */
public class JsHelper {
	
	public static void main(String[] args) {
//		test001("123");
//		test003();
//		getMindaiLogin(2, 18618464512L);
		getShipinyaopin();
	}
	
	public static void test001(String name) {
		ScriptEngineManager sem = new ScriptEngineManager();
		/*
		 * sem.getEngineByExtension(String extension)参数为js
		 * sem.getEngineByMimeType(String mimeType) 参数为application/javascript 或者text/javascript
		 * sem.getEngineByName(String shortName)参数为js或javascript或JavaScript
		 */
		ScriptEngine se = sem.getEngineByName("js");
		try {
			String script = "function say(){ return 'hello,"+name+"'; }";
			se.eval(script);
			Invocable inv2 = (Invocable) se;
			String res = (String) inv2.invokeFunction("say");
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test002(String script, String function, Object... args) {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("js");
		try {
			se.eval(script);
			Invocable inv2 = (Invocable) se;
			String res = (String) inv2.invokeFunction(function, args);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void test003() {
		String content = FileUtils.getContent("src/com/liuzhen/js/static/test.js");
		test002(content, "sayHello", "123");
		System.out.println(1);
	}
	
	private static void getMindaiLogin(int times, long phone) {
		String sessonId = "";
		String e = times == 1 ? "user.captcha" : "user.isRegistered";
		String r = times == 1 ? "{\"deviceType\":\"pc\"}" : "{\"userName\":\"" + phone + "\",\"deviceType\":\"pc\"}";
		String content = FileUtils.getContent("src/com/liuzhen/js/static/mindaiLogin.js");
		test002(content, "getValues", sessonId, e, r);
	}
	
	private static void getShipinyaopin() {
		String callback = "search.jsp?tableId=0_-1&bcId=147935112391062412920290887258";
		String url = "8p4";
			String formEle = "tableId=124&bcId=150225369505818928066514190553&curstart=5&tableName=TABLE124&viewtitleName=COLUMN1654&viewsubTitleName=COLUMN1661,COLUMN1653&tableView=婴幼儿配方乳粉产品配方&cid=0&ytableId=0&searchType=search&State=1";
		String content = FileUtils.getContent("src/com/liuzhen/js/static/shipinyaopinjiandu.js");
		test002(content, "commitForECMA", formEle);
	}
}
