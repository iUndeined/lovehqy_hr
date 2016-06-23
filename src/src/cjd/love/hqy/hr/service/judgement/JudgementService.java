package cjd.love.hqy.hr.service.judgement;

import java.util.Date;
import java.util.List;

import cjd.love.hqy.hr.pojo.WorkScheduling;
import cjd.love.hqy.hr.util.ControllerUtil;
import cjd.love.hqy.hr.util.DateUtil;
import me.cjd.sqlbuilder.core.SqlBuilder;

public class JudgementService {
	
	public final static JudgementService me = new JudgementService();
	
	public void initCorePage(){
		// 声明 当前日期
		Date currentDate = DateUtil.me.get();
		// 获取 sql语句
		String sql = SqlBuilder.render("scheduling.findSchedulingByDate");
		// 查询 已配的排班
		List<WorkScheduling> schL = WorkScheduling.dao.find(sql, currentDate);
		// 传出页面
		ControllerUtil.setAttr("schL", schL);
	}
	
}