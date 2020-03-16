package com.liuzhen.clock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @class: JobDay
 * @description: 
 * @author: L.zhen
 * @date: 2018/12/11 15:56
 */
public class JobDay {
	
	public static void main(String[] args) {
		get2020();
	}
	
	private static void get2020() {
		startIndex = 830;
		init2020();
		print(getHoliday(2020));
	}
	
	private static void get2019() {
		startIndex = 715;
		init2019();
		print(getHoliday(2019));
	}
	
	
	private static void init2020() {
		// ①元旦：2020年1月1日放假，共1天。
		// ②春节：1月24日至30日放假调休，共7天。1月19日（星期日）、2月1日（星期六）上班。
		// ③清明节：4月4日至6日放假调休，共3天。
		// ④劳动节：5月1日至5日放假调休，共5天。4月26日（星期日）、5月9日（星期六）上班。
		// ⑤端午节：6月25日至27日放假调休，共3天。6月28日（星期日）上班。
		// ⑥国庆节、中秋节：10月1日至8日放假调休，共8天。9月27日（星期日）、10月10日（星期六）上班。
		holiday = new HashSet<>();
		workday = new HashSet<>();
		holiday.add("2020-01-01");
		workday.add("2020-01-19");
		holiday.add("2020-01-24");
		holiday.add("2020-01-27");
		holiday.add("2020-01-28");
		holiday.add("2020-01-29");
		holiday.add("2020-01-30");
		workday.add("2020-02-01");
		holiday.add("2020-04-06");
		workday.add("2020-04-26");
		holiday.add("2020-05-01");
		holiday.add("2020-05-04");
		holiday.add("2020-05-05");
		workday.add("2020-05-09");
		holiday.add("2020-06-25");
		holiday.add("2020-06-26");
		workday.add("2020-06-28");
		workday.add("2020-09-27");
		holiday.add("2020-10-01");
		holiday.add("2020-10-02");
		holiday.add("2020-10-05");
		holiday.add("2020-10-06");
		holiday.add("2020-10-07");
		holiday.add("2020-10-08");
		workday.add("2020-10-10");
	}
	
	private static void init2019() {
		//	一、元旦：2018年12月30日至2019年1月1日放假调休，共3天。2018年12月29日（星期六）上班。
		//	二、春节：2月4日至10日放假调休，共7天。2月2日（星期六）、2月3日（星期日）上班。
		//	三、清明节：4月5日放假，与周末连休。
		//	四、劳动节：5月1日放假。
		//	五、端午节：6月7日放假，与周末连休。
		//	六、中秋节：9月13日放假，与周末连休。
		//	七、国庆节：10月1日至7日放假调休，共7天。9月29日（星期日）、10月12日（星期六）上班。
		holiday = new HashSet<>();
		workday = new HashSet<>();
		holiday.add("2019-01-01");
		workday.add("2019-02-02");
		workday.add("2019-02-03");
		holiday.add("2019-02-04");
		holiday.add("2019-02-05");
		holiday.add("2019-02-06");
		holiday.add("2019-02-07");
		holiday.add("2019-02-08");
		holiday.add("2019-04-05");
		holiday.add("2019-05-01");
		holiday.add("2019-06-07");
		holiday.add("2019-09-13");
		workday.add("2019-09-29");
		holiday.add("2019-10-01");
		holiday.add("2019-10-02");
		holiday.add("2019-10-03");
		holiday.add("2019-10-04");
		holiday.add("2019-10-07");
		workday.add("2019-10-12");
	}
	
	private static Set<String> holiday;
	private static Set<String> workday;
	private static Integer startIndex;
	
	private static List<String> getHoliday(int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, Calendar.JANUARY, 1);
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 364; i++) {
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			String date = DateUtils.formatToDay(c.getTime());
			if ((dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY || holiday.contains(date)) && !workday.contains(date)) {
				list.add(date);
			}
			c.add(Calendar.DATE, 1);
		}
		return list;
	}
	
	private static void print(List<String> list) {
		if (list != null && list.size() > 0) {
			int id = startIndex;
			for (String date : list) {
				System.out.println("INSERT INTO `ct_calendar` (`ID`, `HOLIDAY`, `FLAG`, `DESCRIPTION`) VALUES ('" + (id++) + "', '" + date + " 00:00:00', '0', null);");
			}
		}
	}
}


