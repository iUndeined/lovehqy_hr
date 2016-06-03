package cjd.love.hqy.hr.web.scheduling;

import cjd.love.hqy.hr.ext.HrLoveController;
import cjd.love.hqy.hr.service.scheduling.SchedulingService;

public class SchedulingController extends HrLoveController {
	
	public void builder(){
		SchedulingService.me.initSchedulingPage();
		this.render("/views/scheduling/builder.html");
	}
	
}