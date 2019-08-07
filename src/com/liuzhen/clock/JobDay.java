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
		init();
		print(getHoliday());
	}
	
	public static void init() {
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
	
	private static List<String> getHoliday() {
		Calendar c = Calendar.getInstance();
		c.set(2019, Calendar.JANUARY, 1);
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
			int id = 715;
			for (String date : list) {
				System.out.println("INSERT INTO `ct_calendar` (`ID`, `HOLIDAY`, `FLAG`, `DESCRIPTION`) VALUES ('" + (id++) + "', '" + date + " 00:00:00', '0', 'null');");
			}
		}
	}
}


