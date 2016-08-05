package core.nmvc;

import com.google.common.collect.Lists;
import core.annotation.Controller;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by wymstar on 8/1/16.
 */
public class ControllerScanner {
    Logger log = LoggerFactory.getLogger(this.getClass());

    Reflections reflections;

    public ControllerScanner(String basePackage) {
        this.reflections = new Reflections(basePackage);
    }

    public Set<Object> getController () {
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Controller.class);
        Set<Object> controllerObjects = new HashSet<>();
        for (Class<?> clazz : annotated) {
            try {
                //TODO 여러 타입의 생성자도 가능하도록 수정
                controllerObjects.add(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
        return controllerObjects;
    }


}
