package cjd.love.hqy.hr.pojo.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseLeave<M extends BaseLeave<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setLeaveManId(java.lang.Integer leaveManId) {
		set("leave_man_id", leaveManId);
	}

	public java.lang.Integer getLeaveManId() {
		return get("leave_man_id");
	}

	public void setLeaveManName(java.lang.String leaveManName) {
		set("leave_man_name", leaveManName);
	}

	public java.lang.String getLeaveManName() {
		return get("leave_man_name");
	}

	public void setLeaveDays(java.lang.Integer leaveDays) {
		set("leave_days", leaveDays);
	}

	public java.lang.Integer getLeaveDays() {
		return get("leave_days");
	}

	public void setLeaveHours(java.lang.Integer leaveHours) {
		set("leave_hours", leaveHours);
	}

	public java.lang.Integer getLeaveHours() {
		return get("leave_hours");
	}

	public void setCreatedDate(java.util.Date createdDate) {
		set("created_date", createdDate);
	}

	public java.util.Date getCreatedDate() {
		return get("created_date");
	}

}
