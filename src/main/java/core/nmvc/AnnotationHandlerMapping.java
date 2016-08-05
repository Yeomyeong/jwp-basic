package core.nmvc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

import javax.servlet.http.HttpServletRequest;

import com.google.common.collect.Maps;

import core.annotation.RequestMapping;
import core.annotation.RequestMethod;
import core.mvc.Controller;

public class AnnotationHandlerMapping {
	private Object[] basePackage;
	
	private Map<HandlerKey, HandlerExecution> handlerExecutions = Maps.newHashMap();

	public AnnotationHandlerMapping(Object... basePackage) {
		this.basePackage = basePackage;
	}
	
	public void initialize() {
		ControllerScanner scanner = new ControllerScanner(basePackage[0].toString());

		for (Object obj : scanner.getController()) {
			Class<?> clazz = obj.getClass();

			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if ( method.isAnnotationPresent(RequestMapping.class) ) {
					RequestMapping rmAnno = method.getAnnotation(RequestMapping.class);

					HandlerKey key  = new HandlerKey(rmAnno.value(), rmAnno.method() );
					handlerExecutions.put(key, new HandlerExecution(method, obj));
				}
			}
		}
	}
	
	public HandlerExecution getHandler(HttpServletRequest request) {
		String requestUri = request.getRequestURI();
		RequestMethod rm = RequestMethod.valueOf(request.getMethod().toUpperCase());
		return handlerExecutions.get(new HandlerKey(requestUri, rm));
	}
}
