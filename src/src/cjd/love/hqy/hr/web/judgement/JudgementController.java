package cjd.love.hqy.hr.web.judgement;

import com.jfinal.core.Controller;

import cjd.love.hqy.hr.service.judgement.JudgementService;

/**
 * 考勤控制器
 * @author Mr.cjd
 */
public class JudgementController extends Controller {
	
	public void index(){
		JudgementService.me.initCorePage();
		this.render("/views/judgement/core.html");
	}
	
}
