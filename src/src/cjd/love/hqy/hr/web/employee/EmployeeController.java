package cjd.love.hqy.hr.web.employee;

import java.util.Date;
import java.util.List;
import cjd.love.hqy.hr.pojo.Employee;
import cjd.love.hqy.hr.pojo.S;
import cjd.love.hqy.hr.service.employye.EmployyeService;
import cjd.love.hqy.hr.ext.HrLoveController;
import cjd.love.hqy.hr.model.commons.AjaxResult;

public class EmployeeController extends HrLoveController {
	
	public void join(){
		// 获取 雇员
		Employee employee = this.getModel(Employee.class, "e");
		employee.setStatus(S.Employee.STATUS_WORK);
		employee.setCreatedDate(new Date());
		employee.save();
		// 返回 成功
		this.success();
	}
	
	/**
	 * 解雇一波学员
	 */
	public void fire(){
		// 获取 雇员id
		Integer emplId = this.getParaToInt("id");
		if (emplId == null) {
			this.renderJson(new AjaxResult("雇员id不能为空"));
			return;
		}
		// 更新 雇员状态
		Employee employee = Employee.dao.findById(emplId);
		employee.setStatus(S.Employee.STATUS_FIRE);
		employee.update();
		
		// 返回成功
		this.renderJson(new AjaxResult(true));
	}
	
	public void list(){
		// 查找 在职员工
		this.setAttr("list", EmployyeService.me.list(S.Employee.List.WORK));
		this.render("/views/employee/list.html");
	}
	
}
