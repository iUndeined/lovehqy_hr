package cjd.love.hqy.hr.ext;

import com.jfinal.core.Controller;

public class HrLoveController extends Controller {
	
	public void success(){
		// 返回哪个界面
		this.setAttr("back_to_view", this.getPara("back_to_view", ""));
		this.render("/success.html");
	}
	
}
