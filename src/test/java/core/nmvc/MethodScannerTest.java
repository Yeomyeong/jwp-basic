package core.nmvc;

import core.annotation.RequestMapping;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wymstar on 8/1/16.
 */
public class MethodScannerTest {
    @Test
    public void test_ready() throws Exception {
        Logger log = LoggerFactory.getLogger(this.getClass());
        List<Object> list = Collections.singletonList(new MyController());
        List<Method> rmMethods = new ArrayList<>();
        for (Object obj : list) {
            Class<?> clazz = obj.getClass();

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                RequestMapping rmAnno = method.getAnnotation(RequestMapping.class);
                if ( method.isAnnotationPresent(RequestMapping.class) ) {
                    rmMethods.add(method);
                }
            }
        }
    }
}
