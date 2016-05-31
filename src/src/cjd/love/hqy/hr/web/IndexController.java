package cjd.love.hqy.hr.web;

import com.jfinal.core.Controller;
import cjd.love.hqy.hr.service.IndexService;

public class IndexController extends Controller {
	
	public void index(){
		this.render("index.html");
	}
	
	public void qrcode(){
		IndexService.me.initLocalAddr();
		this.render("qrcode.html");
	}
	
}
