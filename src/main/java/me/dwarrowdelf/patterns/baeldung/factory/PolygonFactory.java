package me.dwarrowdelf.patterns.baeldung.factory;

/**
 * Reference: https://www.baeldung.com/creational-design-patterns#factory-method
 */
public class PolygonFactory {

	public Polygon getPolygon(int numberOfSides) {
		if (numberOfSides == 3) {
			return new Triangle();
		}
		else if (numberOfSides == 4) {
			return new Square();
		}
		else if (numberOfSides == 5) {
			return new Pentagon();
		}
		else {
			return null;
		}
	}

}
