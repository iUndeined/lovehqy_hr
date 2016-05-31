package cjd.love.hqy.hr.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import cjd.love.hqy.hr.util.ControllerUtil;

public class IndexService {
	
	public final static IndexService me = new IndexService();
	
	public void initLocalAddr() {
		try {
			InetAddress local = InetAddress.getLocalHost();
			// 获取 本机的ip地址
			String localIp = local.getHostAddress();
			// 传出页面 本机ip
			ControllerUtil.setAttr("localIp", localIp);
		} catch (UnknownHostException e) {
			throw new RuntimeException("无法获取到本机地址", e);
		}
	}
	
}
