package cjd.love.hqy.hr.util;

import com.jfinal.core.Controller;

public class ControllerUtil {
	
	private final static ThreadLocal<Controller> tl = new ThreadLocal<>();
	
	public final static void init(Controller c){
		tl.set(c);
	}
	
	public final static Controller get(){
		Controller c = tl.get();
		if (c == null) {
			throw new RuntimeException("请在controller执行过程中使用该工具，不然无法获取!!");
		}
		return c;
	}
	
	public final static void remove(){
		tl.remove();
	}
	
	public final static Controller setAttr(String name, Object value){
		return get().setAttr(name, value);
	}
	
	public final static <T> T getAttr(String name){
		return get().getAttr(name);
	}
	
	public final static Controller setSessionAttr(String name, Object value){
		return get().setSessionAttr(name, value);
	}
	
	public final static <T> T getSessionAttr(String key){
		return get().getSessionAttr(key);
	}
	
}
