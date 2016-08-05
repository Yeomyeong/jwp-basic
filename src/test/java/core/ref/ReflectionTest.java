package core.ref;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionTest {
	private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
	
	@Test
	public void showClass() {
		Class<Question> clazz = Question.class;
		logger.debug(clazz.getName());
		logger.debug(Arrays.toString(clazz.getDeclaredFields()));
		logger.debug(Arrays.toString(clazz.getConstructors()));
		logger.debug(Arrays.toString(clazz.getMethods()));
	}
}
