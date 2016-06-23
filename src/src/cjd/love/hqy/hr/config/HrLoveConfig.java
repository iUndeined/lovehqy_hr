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
import cjd.love.hqy.hr.web.judgement.JudgementController;
import cjd.love.hqy.hr.web.scheduling.SchedulingController;
import me.cjd.sqlbuilder.core.SqlBuilder;
import me.cjd.sqlbuilder.engine.SqlBeetlEngine;

public class HrLoveConfig extends JFinalConfig {
	
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		// 集成 Beetl模板引擎
		me.setMainRenderFactory(new BeetlRenderFactory());
		// 初始化 外部sql工具
		SqlBuilder.setEngine(new SqlBeetlEngine());
	}

	@Override
	public void configHandler(Handlers me) {
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new ControllerInter());
	}
	
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/lovehqy_hr?useUnicode=true&characterEncoding=UTF-8";
	private final String JDBC_USER = "root";
	private final String JDBC_PSWD = "root";
	/**
	 * 部署到公共云平台
	 * 平台地址：http://www.mopaas.com
	 */
	/*
	private final String JDBC_URL = "jdbc:mysql://192.168.1.11:3306/d920a11c9e07b4628b0a4fb8f225d0e0a?useUnicode=true&characterEncoding=UTF-8";
	private final String JDBC_USER = "831d01ad-ae5d";
	private final String JDBC_PSWD = "a32df4cd-9d14";
	*/
	
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
		me.add("/scheduling", SchedulingController.class);
		me.add("/judgement", JudgementController.class);
	}
	
}
