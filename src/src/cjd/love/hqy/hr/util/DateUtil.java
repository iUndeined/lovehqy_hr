package cjd.love.hqy.hr.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 * @author Mr.cjd
 */
public class DateUtil {
	
	private DateUtil(){};
	
	public final static DateUtil me = new DateUtil();
	
	public Date get(int month, int day){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), month, day, 0, 0, 0);
		return cal.getTime();
	}
	
	public int getMonth(){
		return Calendar.getInstance().get(Calendar.MONTH);
	}
	
	/**
	 * 获取 今天是多少号
	 * @return
	 */
	public int getDay(){
		return Calendar.getInstance().get(Calendar.DATE);
	}
	
	/**
	 * 获取当月最多有多少天
	 * @return
	 */
	public int getDayOfMonthMax(){
		return this.getDayOfMonthMax(new Date());
	}
	
	/**
	 * 获取指定日期月份最多有多少天
	 * @param date 指定日期
	 * @return
	 */
	public int getDayOfMonthMax(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * 获取 是周几
	 * @param date 日期类
	 * @return [星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日]
	 */
	public String getDayOfWeekName(Date date){
		// 获取 日期工具类
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int weekCode = cal.get(Calendar.DAY_OF_WEEK);
		switch (weekCode) {
			case Calendar.MONDAY:
				return "星期一";
			case Calendar.TUESDAY:
				return "星期二";
			case Calendar.WEDNESDAY:
				return "星期三";
			case Calendar.THURSDAY:
				return "星期四";
			case Calendar.FRIDAY:
				return "星期五";
			case Calendar.SATURDAY:
				return "星期六";
			case Calendar.SUNDAY:
				return "星期日";
			default:
				return "未知星期";
		}
	}
	
}
