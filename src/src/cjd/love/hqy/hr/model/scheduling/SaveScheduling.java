package cjd.love.hqy.hr.model.scheduling;

import java.util.Date;

/**
 * 保存 排班 模型
 * @author Mr.cjd
 */
public class SaveScheduling {
	
	/** 排班 ID */
	private Integer schId;
	/** 排班 雇员ID */
	private Integer employeeId;
	/** 排班 雇员名称 */
	private String employeeName;
	/** 排班 日期 */
	private Date date;
	
	public Integer getSchId() {
		return schId;
	}

	public void setSchId(Integer schId) {
		this.schId = schId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
