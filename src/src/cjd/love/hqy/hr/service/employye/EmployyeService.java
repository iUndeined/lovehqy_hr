package cjd.love.hqy.hr.service.employye;

import java.util.List;
import java.util.ArrayList;
import cjd.love.hqy.hr.pojo.S;
import cjd.love.hqy.hr.pojo.Employee;

public class EmployyeService {
	
	private EmployyeService() {}
	
	public final static EmployyeService me = new EmployyeService();
	
	public List<Employee> list(int type){
		List<Integer> vals = new ArrayList<>(1);
		String sql = "select * from t_employee as i ";
		
		if (S.Employee.List.ALL != type) {
			sql += "where i.status = ? ";
		}
		
		switch (type) {
			case S.Employee.List.WORK:
				vals.add(S.Employee.STATUS_WORK);
				break;
			case S.Employee.List.FIRE:
				vals.add(S.Employee.STATUS_FIRE);
				break;
			default:
				throw new RuntimeException("无法识别的列表查询方式");
		}
		
		// 查询
		return Employee.dao.find(sql, vals.toArray());
	}
	
}
