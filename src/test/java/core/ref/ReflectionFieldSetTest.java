package core.ref;

import next.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by wymstar on 7/28/16.
 */
public class ReflectionFieldSetTest {
    @Test
    public void test() throws Exception {
        Class<Student> clazz = Student.class;

        Student instance = clazz.newInstance();
        Field field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        field.set(instance, 234);

        Assert.assertEquals(234, instance.getAge());
    }
}
