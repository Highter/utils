package com.yjw.utils.date;

import java.util.Calendar;

/**
 * 测试Calendar类
 *@author Administrator
 *@date 下午3:33:27,2016年6月29日
 *@vesion 1.0
 *@see yjwsmileatlife@126.com
 */

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。    
		cal.add(Calendar.DAY_OF_MONTH, -1);//取当前日期的前一天.    
		System.out.println(cal);
		
		String dateString = DateUtils.getStringByFormat(cal.getTime(), DateUtils.dateFormatYMDHMS);
		System.out.println("00010001:"+dateString);
	}
}
