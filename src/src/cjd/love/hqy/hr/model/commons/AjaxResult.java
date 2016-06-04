package cjd.love.hqy.hr.model.commons;

/**
 * Ajax异步执行结果返回实体
 * @author Mr.cjd
 */
public class AjaxResult {
	
	/** 结果 成功与否 */
	private boolean success;
	/** 结果 错误消息，只有发生错误才会有 */
	private String errmsg;
	
	public AjaxResult(boolean success) {
		super();
		this.success = success;
	}
	
	public AjaxResult(String errmsg) {
		super();
		this.success = false;
		this.errmsg = errmsg;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
