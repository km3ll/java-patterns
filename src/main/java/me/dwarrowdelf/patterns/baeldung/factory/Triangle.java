package me.dwarrowdelf.patterns.baeldung.factory;

/**
 * Reference: https://www.baeldung.com/creational-design-patterns#factory-method
 */
public class Triangle implements Polygon {

	@Override
	public String getType() {
		return "Triangle";
	}

}
