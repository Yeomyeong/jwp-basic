package core.ref;

import next.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import static org.junit.Assert.fail;

/**
 * Created by wymstar on 7/28/16.
 */
public class ReflectionConstructorTest {
    @Test(expected = InstantiationException.class)
    public void exceptionTest () throws Exception{
        User.class.newInstance();
    }

    @Test
    public void test() throws Exception{
        Class<User> clazz = User.class;

        Constructor<User>[] constructors = (Constructor<User>[]) clazz.getDeclaredConstructors();
        if (constructors.length == 0)
            fail();

        Constructor<User> constructor = constructors[0];
        System.out.println(Arrays.toString(constructor.getGenericParameterTypes()));
        User instance = constructor.newInstance("wymstar", "1234", "우여명", "wymstar@naver.com");

        Assert.assertEquals(instance.getUserId(), "wymstar");
        Assert.assertEquals(instance.getPassword(), "1234");
        Assert.assertEquals(instance.getName(), "우여명");
        Assert.assertEquals(instance.getEmail(), "wymstar@naver.com");
    }
}
