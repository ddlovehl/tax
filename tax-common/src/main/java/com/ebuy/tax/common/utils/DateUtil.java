package com.ebuy.tax.common.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author lee
 * @version 1.0
 * @Date 2007-4-26
 * @copyright huateng
 */
public class DateUtil {
	
	/**
	 * 
	 */
	private  static Log  log = LogFactory.getLog(DateUtil.class);
	
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	public static Timestamp addTimes(Timestamp time, int year, int month,
			int days, int hours, int minutes, int seconds) {
		if (time == null) {
			return null;
		}
		return new Timestamp(time.getYear() + year, time.getMonth() + month,
				time.getDate() + days, time.getHours() + hours, time
						.getMinutes()
						+ minutes, time.getSeconds() + seconds, 0);
	}

	public static Timestamp addDays(Timestamp time, int days) {
		if (time == null) {
			return null;
		}
		return new Timestamp(time.getYear(), time.getMonth(), time.getDate()
				+ days, time.getHours(), time.getMinutes(), time.getSeconds(),
				0);
	}

	/**
	 * 将日期格式的字符串转换为日期类型
	 * 
	 * @param dataString
	 * @param format
	 *            字符串的日期格式
	 * @return
	 */
	public static Date toDate(String dataString, String format) {
		if (dataString == null || dataString.equals("")) {
			return null;
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		try {
			return new Date(myFormat.parse(dataString).getTime());
		} catch (Exception e) {
			log.error("",e);
			return null;
		}
	}

	/**
	 * 将日期格式的字符串转换为日期类型。如果字符串的格式为"yyyy-MM-dd HH:mm:ss",则截取日期返回
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param dataString
	 * @return
	 */
	public static Date toDate(String dataString) {
		if (dataString == null || dataString.equals("")) {
			return null;
		}
		if (dataString.length() > 10) {
			return toDate(dataString, "yyyy-MM-dd HH:mm:ss");
		} else {
			return toDate(dataString, "yyyy-MM-dd");
		}
	}

	/**
	 * 将时间格式的字符串转换为时间类型
	 * 
	 * @param timeString
	 * @param format
	 *            字符串的时间格式
	 * @return
	 */
	public static Timestamp toTime(String timeString, String format) {
		if (timeString == null || timeString.equals("")) {
			return null;
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		try {
			return new Timestamp(myFormat.parse(timeString).getTime());
		} catch (Exception e) {
			log.error("",e);
			return null;
		}
	}

	/**
	 * 将时间格式的字符串转换为时间类型。如果字符串的格式为"yyyy-MM-dd"，则返回当日0点0分0秒的时间。
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param timeString
	 * @return
	 */
	public static Timestamp toTime(String timeString) {
		if (timeString == null || timeString.equals("")) {
			return null;
		}
		if (timeString.length() > 10) {
			return toTime(timeString, "yyyy-MM-dd HH:mm:ss");
		} else {
			return toTime(timeString, "yyyy-MM-dd");
		}
	}

	/**
	 * 如果字符串的格式是"yyyy-MM-dd"，则返回当日0点0分0秒的时间;如果格式是"yyyy-MM-dd
	 * HH:mm:ss"，直接返回该字符串表示的时间
	 * 
	 * @param dateString
	 * @return
	 */
	public static Timestamp getFirstTime(String dateString) {
		if (dateString == null || dateString.equals("")) {
			return null;
		}
		if (dateString.length() > 10) {
			return toTime(dateString, "yyyy-MM-dd HH:mm:ss");
		} else {
			return toTime(dateString, "yyyy-MM-dd");
		}
	}

	/**
	 * 如果字符串的格式是"yyyy-MM-dd"，则返回当日23点59分59秒的时间;如果格式是"yyyy-MM-dd
	 * HH:mm:ss"，直接返回该字符串表示的时间
	 * 
	 * @param dateString
	 * @return
	 */
	public static Timestamp getLastTime(String dateString) {
		if (dateString == null || dateString.equals("")) {
			return null;
		}
		if (dateString.length() > 10) {
			return toTime(dateString, "yyyy-MM-dd HH:mm:ss");
		} else {
			Timestamp firstTime = getFirstTime(dateString);
			return new Timestamp(firstTime.getYear(), firstTime.getMonth(),
					firstTime.getDate(), 23, 59, 59, 0);
		}

	}

	/**
	 * 获取指定时间所在的日期
	 * 
	 * @param time
	 * @return
	 */
	public static Date getDate(Timestamp time) {
		if (time == null) {
			return null;
		}
		return new Date(time.getTime());
	}

	/**
	 * 获取指定日期的0点0分0秒的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getFirstTime(Date date) {
		if (date == null) {
			return null;
		}
		return new Timestamp(date.getYear(), date.getMonth(), date.getDate(),
				0, 0, 0, 0);
	}

	/**
	 * 获取指定日期的23点59分59秒的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getLastTime(Date date) {
		if (date == null) {
			return null;
		}
		return new Timestamp(date.getYear(), date.getMonth(), date.getDate(),
				23, 59, 59, 0);
	}

	/**
	 * 获取系统当前日期
	 * 
	 * @return
	 */
	public static Date getDate() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Date.valueOf(mystrdate);
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 */
	public static Timestamp getTime() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		String mystrdate = myFormat.format(calendar.getTime());
		return Timestamp.valueOf(mystrdate);
	}

	/**
	 * 获取14位系统当前时间
	 * 
	 */
	public static String getSysTime14(){
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar = Calendar.getInstance();
		return myFormat.format(calendar.getTime());
	}
	/**
	 * 判断指定的日期是否是当月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLastDateOfMonth(Date date) {
		if (date == null) {
			return false;
		}
		Date secdate = new Date(date.getYear(), date.getMonth(),
				date.getDate() + 1);
		if (secdate.getMonth() > date.getMonth()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断指定的时间是否是当月最后一天
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isLastDateOfMonth(Timestamp time) {
		if (time == null) {
			return false;
		}
		Date secdate = new Date(time.getYear(), time.getMonth(),
				time.getDate() + 1);
		if (secdate.getMonth() > time.getMonth()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断指定日期是否是当月第一天
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isFirstDateOfMonth(Date date) {
		if (date == null) {
			return false;
		}
		return date.getDate() == 1;
	}

	/**
	 * 判断指定的时间是否是当月的第一天
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isFirstDateOfMonth(Timestamp time) {
		if (time == null) {
			return false;
		}
		return time.getDate() == 1;
	}

	/**
	 * 获取指定的日期所在月份的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfMonth(Date date) {
		if (date == null) {
			return null;
		}
		return new Date(date.getYear(), date.getMonth(), 1);
	}

	/**
	 * 获取指定的日期所在月份的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		if (date == null) {
			return null;
		}
		return new Date(date.getYear(), date.getMonth(), getMonthDays(date
				.getYear(), date.getMonth()));
	}

	/**
	 * 获取指定的时间所在月份的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Timestamp time) {
		if (time == null) {
			return null;
		}
		return new Date(time.getYear(), time.getMonth(), getMonthDays(time
				.getYear(), time.getMonth()));
	}

	/**
	 * 判断指定的日期是否是当季度的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLastDateOfSeason(Date date) {
		if (date == null) {
			return false;
		}
		Date secdate = new Date(date.getYear(), date.getMonth(),
				date.getDate() + 1);
		if (secdate.getMonth() != date.getMonth()
				&& (date.getMonth() + 1) % 3 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断指定的日期是否是当年的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLastDateOfYear(Date date) {
		if (date == null) {
			return false;
		}
		Date secdate = new Date(date.getYear(), date.getMonth(),
				date.getDate() + 1);
		return (secdate.getYear() > date.getYear());
	}

	/**
	 * 判断指定日期是否在指定时间段内的第一个月份中
	 * 
	 * @param date
	 * @param beginTime
	 *            时间段的开始时间
	 * @param endTime
	 *            时间段的结束时间
	 * @return
	 */
	public static boolean atFirstMonth(Date date, Timestamp beginTime,
			Timestamp endTime) {
		if (date == null) {
			return false;
		}
		if (date.getYear() == beginTime.getYear()
				&& date.getMonth() == beginTime.getMonth()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断指定日期是否在指定时间段内的最后一个月中
	 * 
	 * @param date
	 * @param beginTime
	 *            时间段的开始时间
	 * @param endTime
	 *            时间段的结束时间
	 * @return
	 */
	public static boolean atLastMonth(Date date, Timestamp beginTime,
			Timestamp endTime) {
		if (date == null) {
			return false;
		}
		if (date.getYear() == endTime.getYear()
				&& date.getMonth() == endTime.getMonth()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否闰年
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取指定年指定月份的天数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthDays(int year, int month) {
		switch (month) {
		case 0:
		case 2:
		case 4:
		case 6:
		case 7:
		case 9:
		case 11:
			return 31;
		case 1:
			if (isLeapYear(1900 + year)) {
				return 29;
			} else {
				return 28;
			}
		case 3:
		case 5:
		case 8:
		case 10:
			return 30;
		}
		throw new RuntimeException("错误的月份");
	}

	/**
	 * 获取指定日期在规定时间段内第一个月中的位置
	 * 
	 * @param date
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static double firstMonthPercent(Date date, Timestamp beginTime,
			Timestamp endTime) {
		if (date == null) {
			return 0;
		}
		if (beginTime.getYear() == endTime.getYear()
				&& beginTime.getMonth() == endTime.getMonth()) {
			return (double) (date.getDate() - beginTime.getDate())
					/ (double) (endTime.getDate() - beginTime.getDate());
		} else {
			return (double) (date.getDate() - beginTime.getDate())
					/ (double) getMonthDays(date.getYear(), date.getMonth());
		}
	}

	/**
	 * 获取指定日期在规定时间段内最后一个月中的位置
	 * 
	 * @param date
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static double lastMonthPercent(Date date, Timestamp beginTime,
			Timestamp endTime) {
		if (date == null) {
			return 0;
		}
		if (beginTime.getYear() == endTime.getYear()
				&& beginTime.getMonth() == endTime.getMonth()) {
			return (double) (date.getDate() - beginTime.getDate())
					/ (double) (endTime.getDate() - beginTime.getDate());
		} else {
			return (double) endTime.getDate()
					/ (double) getMonthDays(date.getYear(), date.getMonth());
		}
	}

	/**
	 * 判断指定日期是否在当月的15日以前
	 *
	 * @param date
	 * @return
	 */
	public static boolean beforeFifth(Date date) {
		if (date == null) {
			return false;
		}
		return date.getDate() < 15;
	}

	/**
	 * 判断指定的时间是否在当月的15日以前
	 * 
	 * @param time
	 * @return
	 */
	public static boolean beforeFifth(Timestamp time) {
		if (time == null) {
			return false;
		}
		return time.getDate() < 15;
	}

	/**
	 * 获取两个日期之间间隔的天数
	 * 
	 * @param endDate
	 * @param beginDate
	 * @return
	 */
	public static long getDays(Date endDate, Date beginDate) {
		if (endDate == null || beginDate == null) {
			return 0;
		}
		long days = (endDate.getTime() - beginDate.getTime())
				/ (24 * 60 * 60 * 1000);
		return days;
	}

	/**
	 * 获取两个时间点之间间隔的天数
	 * 
	 * @param endTime
	 * @param beginTime
	 * @return
	 */
	public static long getDays(Timestamp endTime, Timestamp beginTime) {
		if (endTime == null || beginTime == null) {
			return 0;
		}
		long days = (endTime.getTime() - beginTime.getTime())
				/ (24 * 60 * 60 * 1000);
		return days;
	}

	/**
	 * 获取两个日期之间间隔的月数
	 * 
	 * @param endDate
	 * @param beginDate
	 * @return
	 */
	public static long getMonth(Date endDate, Date beginDate) {
		if (endDate == null || beginDate == null) {
			return 0;
		}
		if (endDate.compareTo(beginDate) <= 0) {
			return 0;
		} else {
			if (endDate.getYear() == beginDate.getYear()) {
				return endDate.getMonth() - beginDate.getMonth();
			} else {
				return (endDate.getYear() - beginDate.getYear() - 1) * 12
						+ (12 - beginDate.getMonth() - 1);
			}
		}
	}

	/**
	 * 获取指定月份的第一天的0点0分0秒的时间
	 * 
	 * @param month
	 * @return
	 */
	public static Timestamp getFirstTimeOfMonth(String month) {
		if (month == null || month.equals("")) {
			return null;
		}
		return toTime(month, "yyyyMM");
	}

	/**
	 * 获取指定月份的最后一天的23点59分59秒的时间
	 * 
	 * @param month
	 * @return
	 */
	public static Timestamp getLastTimeOfMonth(String month) {
		if (month == null || month.equals("")) {
			return null;
		}
		Timestamp firstTime = getFirstTimeOfMonth(month);
		return new Timestamp(
				firstTime.getYear(),
				firstTime.getMonth(),
				DateUtil
						.getMonthDays(firstTime.getYear(), firstTime.getMonth()),
				23, 59, 59, 0);
	}

	/**
	 * 获取指定日期的下一个日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDate(Date date) {
		if (date == null) {
			return null;
		}
		return new Date(date.getYear(), date.getMonth(), date.getDate() + 1);
	}

	/**
	 * 判断两个日期是否在同一个月份
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean inSameMonth(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		if (date1.getYear() == date2.getYear()
				&& date1.getMonth() == date2.getMonth()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断一个日期和一个时间是否在同月
	 * 
	 * @param date
	 * @param time
	 * @return
	 */
	public static boolean inSameMonth(Date date, Timestamp time) {
		if (date == null || time == null) {
			return false;
		}
		if (date.getYear() == time.getYear()
				&& date.getMonth() == time.getMonth()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断给定的两个时间是否在同月
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static boolean inSameMonth(Timestamp time1, Timestamp time2) {
		if (time1 == null || time2 == null) {
			return false;
		}
		if (time1.getYear() == time2.getYear()
				&& time1.getMonth() == time2.getMonth()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断一个时间是否在指定的月份
	 * @param time
	 * @param month
	 * @return
	 */
	public static boolean inMonth(Timestamp time, String month) {
		if (time == null || month == null || month.equals("")) {
			return false;
		}
		String m = formatTime(time, "yyyyMM");
		return m.equals(month);
	}

	/**
	 * 获取当前月份，格式yyyyMM
	 * 
	 * @return
	 */
	public static String getMonth() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMM");
		return myFormat.format(getDate());
	}

	/**
	 * 获取指定月份的前一个月
	 * 
	 * @return
	 */
	public static String getPreviousMonth(String month) {
		Timestamp time = getFirstTimeOfMonth(month);
		time.setDate(time.getDate() - 1);
		return formatTime(time, "yyyyMM");
	}

	/**
	 * 获取当前月的前一个月份
	 * 
	 * @return
	 */
	public static String getPreviousMonth() {
		Timestamp time = getFirstTimeOfMonth(getMonth());
		time.setDate(time.getDate() - 1);
		return formatTime(time, "yyyyMM");
	}
	
	/**
	 * 获取距离现在间隔月份的时间
	 */
	public static String getPointMonth(int interval){
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.MONTH, interval); //得到某一个月 
		
		
		return  formatDate(calendar.getTime(), "yyyyMM");
		
	}

	/**
	 * 获取当前月的后一个月份
	 * 
	 * @return
	 */
	public static String getLastMonth() {
		Timestamp time = getLastTimeOfMonth(getMonth());
		time.setDate(time.getDate() + 1);
		return formatTime(time, "yyyyMM");
	}

	/**
	 * 获取当前月份，格式MM
	 * 
	 * @return
	 */
	public static String getMMMonth() {
		SimpleDateFormat myFormat = new SimpleDateFormat("MM");
		return myFormat.format(getDate());
	}

	/**
	 * 获取当前年份，格式yyyy
	 * 
	 * @return
	 */
	public static String getYYYYYear() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy");
		return myFormat.format(getDate());
	}

	/**
	 * 获取当前年份，格式yy
	 * 
	 * @return
	 */
	public static String getYYYear() {
		SimpleDateFormat myFormat = new SimpleDateFormat("yy");
		return myFormat.format(getDate());
	}

	/**
	 * 获取指定月份的第一天日期
	 * 
	 * @param month
	 * @return
	 */
	public static Date getFirstDateOfMonth(String month) {
		if (month == null || month.equals("")) {
			return null;
		}
		return toDate(month, "yyyyMM");
	}

	/**
	 * 获取指定月份的最后一天日期
	 * 
	 * @param month
	 * @return
	 */
	public static Date getLastDateOfMonth(String month) {
		if (month == null || month.equals("")) {
			return null;
		}
		Date date = getFirstDateOfMonth(month);
		return new Date(date.getYear(), date.getMonth(), getMonthDays(date
				.getYear(), date.getMonth()));
	}

	/**
	 * 判断指定日期是否在两个时间范围内
	 * 
	 * @param date
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean between(Date date, Timestamp beginTime,
			Timestamp endTime) {
		if (date.before(getDate(endTime)) && date.after(getDate(beginTime))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断指定时间是否在两个时间范围内
	 * 
	 * @param time
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean between(Timestamp time, Timestamp beginTime,
			Timestamp endTime) {
		if (time.before(endTime) && time.after(beginTime)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 将日期段分割成自然月
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public static String[] getMonths(Date fromDate, Date toDate) {
		List<String> months = new ArrayList<String>();
		int fromYear = 1900 + fromDate.getYear();
		int fromMonth = fromDate.getMonth() + 1;
		int toYear = 1900 + toDate.getYear();
		int toMonth = toDate.getMonth() + 1;
		for (int i = fromYear; i < toYear; i++) {
			if (i == fromYear) {
				for (int j = fromMonth; j <= 12; j++) {
					months.add("" + i + convertMonth(j));
				}
			} else {
				for (int j = 1; j <= 12; j++) {
					months.add("" + i + convertMonth(j));
				}
			}
		}
		if (fromYear == toYear) {
			for (int i = fromMonth; i <= toMonth; i++) {
				months.add("" + toYear + convertMonth(i));
			}
		} else {
			for (int i = 1; i <= toMonth; i++) {
				months.add("" + toYear + convertMonth(i));
			}
		}
		String[] mon = new String[months.size()];
		int n = 0;
		for (Iterator<String> i = months.iterator(); i.hasNext();) {
			mon[n++] = i.next();
		}
		return mon;
	}

	/**
	 * 将整数表示的月份转成成字符串型
	 * 
	 * @param month
	 * @return
	 */
	private static String convertMonth(int month) {
		if (month < 10) {
			return "0" + month;
		} else {
			return "" + month;
		}
	}

	/**
	 * 将日期转换为yyyyMMdd格式的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd");
		return myFormat.format(date);
	}

	/**
	 * 将日期转换为指定格式的字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(date);
	}

	/**
	 * 将时间转换为yyyyMMdd HH:mm:ss格式的字符串
	 * 
	 * @param time
	 * @return
	 */
	public static String formatTime(Timestamp time) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return myFormat.format(time);
	}

	/**
	 * 将时间转换为指定格式的字符串
	 * 
	 * @param time
	 * @param format
	 * @return
	 */
	public static String formatTime(Timestamp time, String format) {
		if (time == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(time);
	}

	/**
	 * 获取当前时间的前一秒时间
	 * 
	 * @param time
	 * @return
	 */
	public static Timestamp getPrevTime(Timestamp time) {
		return new Timestamp(time.getYear(), time.getMonth(), time.getDate(),
				time.getHours(), time.getMinutes(), time.getSeconds() - 1, 0);
	}

	/**
	 * 将时间转换为长整型
	 * 
	 * @param time
	 * @return
	 */
	public static long toLong(Timestamp time) {
		return time.getTime();
	}

//	/**
//	 * 将两个时间相减，得出半小时为单位的时间差
//	 * 
//	 * @param time1
//	 * @param time2
//	 * @return
//	 */
//	public static double subHalfHour(Timestamp time1, Timestamp time2) {
//		if (time1 == null || time2 == null) {
//			return 0;
//		}
//		return NumberUtil.round(
//				(double) (time1.getTime() - time2.getTime()) / 1800000, 2);
//	}
//
//	/**
//	 * 将两个时间相减，得出半小时为单位的时间差
//	 * 
//	 * @param time1
//	 * @param time2
//	 * @return
//	 */
//	public static double subQuatorHour(Timestamp time1, Timestamp time2) {
//		if (time1 == null || time2 == null) {
//			return 0;
//		}
//		return NumberUtil.round(
//				(double) (time1.getTime() - time2.getTime()) / 900000, 2);
//	}
//
//	/**
//	 * 将两个时间相减，得出小时为单位的时间差
//	 * 
//	 * @param time1
//	 * @param time2
//	 * @return
//	 */
//	public static double subHour(Timestamp time1, Timestamp time2) {
//		if (time1 == null || time2 == null) {
//			return 0;
//		}
//		return NumberUtil.round(
//				(double) (time1.getTime() - time2.getTime()) / 3600000, 2);
//	}

	// select extract(day from end_time-begin_time)*24+extract(hour from
	// end_time-begin_time)+extract(minute from end_time-begin_time)/60 into
	// hours from dual;

	public static String getDateString(Timestamp time) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		String mystrdate = myFormat.format(time);
		return mystrdate;
	}

	public static String getTimestampString(Timestamp time, String format) {
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		String mystrdate = myFormat.format(time);
		return mystrdate;
	}

	public static String getMonthByMMM(String MMM) {
		String[] monthList = { "jan", "feb", "mar", "apr", "may", "jun", "jul",
				"aug", "sep", "oct", "nov", "dec" };
		String month = "01";
		for (int i = 0; i < 12; i++) {
			if (monthList[i].equalsIgnoreCase(MMM))
				month = "0" + (i + 1);
		}
		return month.substring(month.length() - 2);
	}

	public static Timestamp addMonths(Timestamp time, int months) {
		if (time == null) {
			return null;
		}
		return new Timestamp(time.getYear(), time.getMonth() + months, time
				.getDate(), time.getHours(), time.getMinutes(), time
				.getSeconds(), 0);
	}

	public static void main(String[] args) throws Exception {
		try {
//			Timestamp t = DateUtil.getTime();
//			System.out.println(getPointMonth(-3));
//			System.out.println(DateUtil.formatTime(t, "yyyyMMdd HH:mm"));
			
//			SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
//			sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
//			System.out.println(sdf.format(0));
			
//			String str = "201104141302";
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
//			long millionSeconds = sdf.parse(str).getTime();// 毫秒
//
//			System.out.println(millionSeconds);
			
//			1302757320000
			
			System.out.println(DateUtil.formatDate(System.currentTimeMillis(), "yyyy-MM-dd 00:00:00"));
		} catch (Exception e) {
			log.error("",e);
		}
	}

	/**
	 * @param createTime
	 * @param format
	 * @return
	 */
	public static String formatDate(java.util.Date createTime, String format) {
		// TODO Auto-generated method stub
		if (createTime == null) {
			return "";
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(createTime);

	}
	
	public static String formatDate(Long curr, String format){
		if(curr==0) return "0";
		SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
		//sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		sdf.applyPattern(format);
		return sdf.format(curr);
	}


	/**
	 * 将日期格式的字符串转换为日期类型
	 * 
	 * @param dataString
	 * @param format
	 *            字符串的日期格式
	 * @return
	 */
	public static java.util.Date toUtilDate(String dataString, String format) {
		return toUtilDate(dataString, format, null);
	}
	
	/**
	 * 将日期格式的字符串转换为日期类型
	 * 
	 * @param dataString
	 * @param format
	 *            字符串的日期格式
	 * @return
	 */
	public static java.util.Date toUtilDate(String dataString, String format, java.util.Date def) {
		if (dataString == null || dataString.equals("")) {
			return def;
		}
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		try {
			return new java.util.Date(myFormat.parse(dataString).getTime());
		} catch (Exception e) {
			log.error("",e);
			return def;
		}
	}
	
	
	/**
	 * 功能: 将字符串转换为指定格式的日期返回
	 * @param dateStr		要转换的字符串
	 * @param format		目标日期格式
	 * @return
	 */
	public static java.util.Date formatStrToDate(String dateStr, String format) {
		if(dateStr == null || "".equals(dateStr)){
			return null;
		} 
		SimpleDateFormat sdf1 = new SimpleDateFormat(format);
		java.util.Date date = null;
		try {
			date = sdf1.parse(dateStr);
		} catch(Exception e) {
			log.error("",e);
			return null;
		}
		return date;
	}
	
	  /**
	   * 功能：字符串转换为Date
	   */
	  public static java.util.Date formatStrToDate(String strdate) throws Exception {
		  String str = strdate.replace("-", "");
	      SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	      return formatter.parse(str);

	  }
	
	
	/**
	 * 获取当前年份，格式format, 默认yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getStrDate() {
		return getStrDate("yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取当前年份，格式format, 默认yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getStrDate(String format) {
		if(null == format || "".equals(format)) format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(new java.util.Date());
	}
	
	/**
	 * 获取当前年份，格式format, 默认yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getStrDate(Timestamp date, String format) {
		if(null == format || "".equals(format)) format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat myFormat = new SimpleDateFormat(format);
		return myFormat.format(date);
	}
	
	/**
	 * 比较两个字符串时间的大小 不取结果的绝对值
	 * 
	 * @param t1
	 *            时间1
	 * @param t2
	 *            时间2
	 * @param parrten
	 *            时间格式 :yyyy-MM-dd HH:mm:ss
	 * @return 返回long =0相等，>0 t1>t2，<0 t1<t2
	 */
	public static long compareStringTimeEx(String t1, String t2, String parrten) {
		SimpleDateFormat formatter = new SimpleDateFormat(parrten);
		long startT = 0;
		long endT = 0;
		try {
			startT = formatter.parse(t1).getTime();
			endT = formatter.parse(t2).getTime();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("",e);
		}
		long ss = (startT - endT) / (1000); // 共计秒数
		return ss;

	}
	
    /** 
     * 获得指定日期的前七天 
     *  
     * @param specifiedDay 
     * @return 
     * @throws Exception 
     */  
    public static java.util.Date getSpecifiedDayBefore(java.util.Date specifiedDay) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();  
        
        c.setTime(specifiedDay);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day - 7);  
        
       return c.getTime();
    }  
    
    public static String DateToString(java.util.Date date){
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
		String formatTime = time.format(date);
		return formatTime;
    }

}