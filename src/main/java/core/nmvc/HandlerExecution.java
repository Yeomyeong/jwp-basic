package core.nmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class HandlerExecution {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	Method method;
	Object declaredObject;

	public HandlerExecution(Method method, Object declaredObject) {
		this.method = method;
		this.declaredObject = declaredObject;
	}

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//TODO validation check
		return (ModelAndView) method.invoke(declaredObject, request, response);
	}
}
