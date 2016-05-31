package cjd.love.hqy.hr.intor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import cjd.love.hqy.hr.util.ControllerUtil;

public class ControllerInter implements Interceptor {

	@Override
	public void intercept(Invocation i) {
		// 设置 当前controller
		ControllerUtil.init(i.getController());
		try {
			// 执行 主体
			i.invoke();
		} finally {
			ControllerUtil.remove();
		}
	}

}
