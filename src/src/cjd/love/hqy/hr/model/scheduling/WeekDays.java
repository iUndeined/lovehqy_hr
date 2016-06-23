package cjd.love.hqy.hr.model.scheduling;

import java.util.Date;
import java.util.List;

import cjd.love.hqy.hr.pojo.WorkScheduling;

public class WeekDays {
	
	/** 排班 日期类 */
	private Date date;
	/** 排班 几月份 */
	private int month;
	/** 排班 多少号 */
	private int day;
	/** 排班 星期几 */
	private String week;
	/** 排班 已经排有的数据 */
	private List<WorkScheduling> datas;
	
	public WeekDays(Date date, int month, int day, String week) {
		super();
		this.date = date;
		this.month = month;
		this.day = day;
		this.week = week;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public List<WorkScheduling> getDatas() {
		return datas;
	}

	public void setDatas(List<WorkScheduling> datas) {
		this.datas = datas;
	}
	
}
