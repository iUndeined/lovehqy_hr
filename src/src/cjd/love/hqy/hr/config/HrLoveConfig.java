package cjd.love.hqy.hr.config;

import org.beetl.ext.jfinal.BeetlRenderFactory;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import cjd.love.hqy.hr.intor.ControllerInter;
import cjd.love.hqy.hr.pojo._MappingKit;
import cjd.love.hqy.hr.web.IndexController;
import cjd.love.hqy.hr.web.employee.EmployeeController;

public class HrLoveConfig extends JFinalConfig {
	
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		// 集成 Beetl模板引擎
		me.setMainRenderFactory(new BeetlRenderFactory());
	}

	@Override
	public void configHandler(Handlers me) {
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new ControllerInter());
	}
	
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/lovehqy_hr";
	private final String JDBC_USER = "root";
	private final String JDBC_PSWD = "root";
	
	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin cp = new C3p0Plugin(JDBC_URL, JDBC_USER, JDBC_PSWD);
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		_MappingKit.mapping(arp);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);
		me.add("/employee", EmployeeController.class);
	}
	
}
