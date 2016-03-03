package com.yjw.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *0001:时间工具类
 *@author Orange
 *@date 下午9:05:40,2016年2月29日
 *@vesion V1.0
 *@see yjwsmileatlife@126.com
 */
public class DateUtils {
	
	/**
	 * 日期格式：年-月-日  时:分:秒
	 */
	public static final String dateFormatYMDHMS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 日期格式：年-月-日  时:分
	 */
	public static final String dateFormatYMDHM = "yyyy-MM-dd HH:mm";
	
	/**
	 * 日期格式：年-月-日 
	 */
	public static final String dateFormatYMD = "yyyy-MM-dd";
	
	/**
	 * 日期格式：年-月
	 */
	public static final String dateFormatYM = "yyyy-MM";
	
	/**
	 * 00010001:Date类型转换成String类型
	 * @param date
	 * @param dateFormate
	 * @return
	 */
	public static String getStringByFormat(Date date,String dateFormat){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		String dateStr = null;
		dateStr = simpleDateFormat.format(date);
		return dateStr;
	}
	
	/**
	 * 00010002:String类型转换成Date类型
	 * @param dateString
	 * @param dateFormat
	 * @return
	 */
	public static Date getDateByFormat(String dateString,String dateFormat){
		Date parseDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		try {
			parseDate = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parseDate;
	}
	
}
