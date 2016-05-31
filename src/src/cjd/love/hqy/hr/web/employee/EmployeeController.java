package cjd.love.hqy.hr.web.employee;

import java.util.Date;
import java.util.List;
import cjd.love.hqy.hr.pojo.Employee;
import cjd.love.hqy.hr.ext.HrLoveController;

public class EmployeeController extends HrLoveController {
	
	public void join(){
		// 获取 雇员
		Employee employee = this.getModel(Employee.class, "e");
		// 添加
		employee.setCreatedDate(new Date());
		employee.save();
		// 返回 成功
		this.success();
	}
	
	public void list(){
		List<Employee> list = Employee.dao.find("select * from t_employee ");
		this.setAttr("list", list);
		this.render("/views/employee/list.html");
	}
	
}
