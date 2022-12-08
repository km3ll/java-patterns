package me.dwarrowdelf.patterns.baeldung.factory;

/**
 * Reference: https://www.baeldung.com/creational-design-patterns#factory-method
 */
public class Square implements Polygon {

	@Override
	public String getType() {
		return "Square";
	}

}
