package cjd.love.hqy.hr.service.scheduling;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cjd.love.hqy.hr.util.ControllerUtil;
import cjd.love.hqy.hr.util.DateUtil;
import cjd.love.hqy.hr.model.scheduling.WeekDays;

public class SchedulingService {
	
	public final static SchedulingService me = new SchedulingService();
	
	public void initSchedulingPage(){
		// 获取 当前是几月份
		int month = DateUtil.me.getMonth();
		// 获取 今天是几号
		int day = DateUtil.me.getDay();
		// 获取 当月有多少天
		int dayMax = DateUtil.me.getDayOfMonthMax();
		// 声明 列表
		List<WeekDays> list = new ArrayList<>(dayMax);
		// 循环 生成
		for (int i = day; i <= dayMax; i ++) {
			Date date = DateUtil.me.get(month, i);
			String dayOfWeek = DateUtil.me.getDayOfWeekName(date);
			WeekDays weekDay = new WeekDays(date, month, day, dayOfWeek);
			list.add(weekDay);
		}
		
		// 传值出页面
		ControllerUtil.setAttr("list", list);
	}
	
}
