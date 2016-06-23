package cjd.love.hqy.hr.web.scheduling;

import cjd.love.hqy.hr.ext.HrLoveController;
import cjd.love.hqy.hr.pojo.S;
import cjd.love.hqy.hr.service.employye.EmployyeService;
import cjd.love.hqy.hr.service.scheduling.SchedulingService;

public class SchedulingController extends HrLoveController {
	
	/**
	 * 排班 编排页面
	 */
	public void builder(){
		SchedulingService.me.initSchedulingPage();
		this.setAttr("emplL", EmployyeService.me.list(S.Employee.List.WORK));
		this.render("/views/scheduling/builder.html");
	}
	
	/**
	 * 排班 保存方法
	 */
	public void shoot(){
		// 获取 保存信息
		String jSave = this.getPara("saves");
		// 执行 服务方法
		SchedulingService.me.doSchedulingShoot(jSave);
		// 返回成功页
		this.success();
	}
	
}