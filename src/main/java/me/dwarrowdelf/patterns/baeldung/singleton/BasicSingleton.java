package me.dwarrowdelf.patterns.baeldung.singleton;

/**
 * Reference:
 * https://www.baeldung.com/creational-design-patterns#1-singleton-pattern-example
 */
public class BasicSingleton {

	private BasicSingleton() {
	}

	private static class SingletonHolder {

		public static final BasicSingleton instance = new BasicSingleton();

	}

	public static BasicSingleton getInstance() {
		return SingletonHolder.instance;
	}

}
