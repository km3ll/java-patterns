package me.dwarrowdelf.patterns.baeldung.singleton;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Reference:
 * https://www.baeldung.com/creational-design-patterns#1-singleton-pattern-example
 */
public class SingletonTests {

	@Test
	public void classSingleton_should_create_one_instance() {
		// Given
		ClassSingleton singleton1 = ClassSingleton.getInstance();
		assertEquals("Initial class info", singleton1.getInfo());
		// When
		ClassSingleton singleton2 = ClassSingleton.getInstance();
		singleton2.setInfo("New class info");
		// Then
		assertEquals("New class info", singleton1.getInfo());
		assertEquals("New class info", singleton2.getInfo());
	}

	@Test
	public void enumSingleton_should_create_one_instance() {
		// Given
		EnumSingleton singleton1 = EnumSingleton.INSTANCE.getInstance();
		assertEquals("Initial class info", singleton1.getInfo());
		// When
		EnumSingleton singleton2 = EnumSingleton.INSTANCE.getInstance();
		singleton2.setInfo("New class info");
		// Then
		assertEquals("New class info", singleton1.getInfo());
		assertEquals("New class info", singleton2.getInfo());
	}

}