package cjd.love.hqy.hr.pojo.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseJudgement<M extends BaseJudgement<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setJugDate(java.util.Date jugDate) {
		set("jug_date", jugDate);
	}

	public java.util.Date getJugDate() {
		return get("jug_date");
	}

	public void setJugStatus(java.lang.Integer jugStatus) {
		set("jug_status", jugStatus);
	}

	public java.lang.Integer getJugStatus() {
		return get("jug_status");
	}

	public void setJugManId(java.lang.Integer jugManId) {
		set("jug_man_id", jugManId);
	}

	public java.lang.Integer getJugManId() {
		return get("jug_man_id");
	}

	public void setJugManName(java.lang.String jugManName) {
		set("jug_man_name", jugManName);
	}

	public java.lang.String getJugManName() {
		return get("jug_man_name");
	}

	public void setJugValue(java.lang.Double jugValue) {
		set("jug_value", jugValue);
	}

	public java.lang.Double getJugValue() {
		return get("jug_value");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

	public void setCreaedDate(java.util.Date creaedDate) {
		set("creaed_date", creaedDate);
	}

	public java.util.Date getCreaedDate() {
		return get("creaed_date");
	}

}
