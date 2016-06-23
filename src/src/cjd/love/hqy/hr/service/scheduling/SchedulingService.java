package cjd.love.hqy.hr.service.scheduling;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

import cjd.love.hqy.hr.util.ControllerUtil;
import cjd.love.hqy.hr.util.DateUtil;
import me.cjd.sqlbuilder.core.SqlBuilder;
import cjd.love.hqy.hr.model.scheduling.SaveScheduling;
import cjd.love.hqy.hr.model.scheduling.WeekDays;
import cjd.love.hqy.hr.pojo.WorkScheduling;

public class SchedulingService {
	
	public final static SchedulingService me = new SchedulingService();
	
	public void initSchedulingPage(){
		// 获取 当前是几月份
		int month = DateUtil.me.getMonth();
		// 获取 今天是几号
		int day = DateUtil.me.getDay();
		// 获取 当月有多少天
		int dayMax = DateUtil.me.getDayOfMonthMax();
		// 获取 sql语句
		String sql = SqlBuilder.render("scheduling.findSchedulingByDate");
		// 声明 列表
		List<WeekDays> list = new ArrayList<>(dayMax);
		// 循环 生成
		for (int i = day; i <= dayMax; i ++) {
			Date date = DateUtil.me.get(month, i);
			String dayOfWeek = DateUtil.me.getDayOfWeekName(date);
			WeekDays weekDay = new WeekDays(date, month, day, dayOfWeek);
			// 查询 已配的排班
			List<WorkScheduling> datas = WorkScheduling.dao.find(sql, date);
			// 将已配置的排班设入Model中
			weekDay.setDatas(datas);
			// 插入返回列表
			list.add(weekDay);
		}
		
		// 传值出页面
		ControllerUtil.setAttr("list", list);
	}
	
	public void doSchedulingShoot(String jSave){
		if (StringUtils.isBlank(jSave)) {
			throw new RuntimeException("保存信息为空，不能存噢");
		}
		
		Date currentDate = new Date();
		// 解析 json串
		List<SaveScheduling> list = JSON.parseArray(jSave, SaveScheduling.class);
		for (SaveScheduling i : list) {
			WorkScheduling sch = new WorkScheduling();
			// 获取 排班ID
			Integer schId = i.getSchId();
			
			// 实体 赋值
			sch.setWorkDate(i.getDate());
			sch.setWorkMan(i.getEmployeeId());
			sch.setWorkManName(i.getEmployeeName());
			sch.setCreatedDate(currentDate);
			
			if (schId == null) {
				// 保存 排班
				sch.save();
			} else {
				// 更新 排班
				sch.setId(schId);
				sch.update();
			}
		}
	}
	
}
