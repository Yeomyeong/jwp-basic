package core.nmvc;

import com.google.common.collect.Lists;
import core.annotation.Controller;
import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by wymstar on 8/1/16.
 */
public class ControllerScannerTest {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void ready() throws Exception {
        Reflections reflections = new Reflections("core.nmvc");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Controller.class);
        ArrayList<Class<?>> list = Lists.newArrayList(annotated);

        Assert.assertEquals(MyController.class, list.get(0));
    }

    @Test
    public void test_getController() throws Exception {
        ControllerScanner scanner = new ControllerScanner("core.nmvc");
        Set<Object> controllers = scanner.getController();

        Assert.assertEquals(controllers.toArray()[0].getClass(), MyController.class);
    }
}
