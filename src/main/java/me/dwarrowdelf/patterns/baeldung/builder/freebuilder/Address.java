package me.dwarrowdelf.patterns.baeldung.builder.freebuilder;

import org.inferred.freebuilder.FreeBuilder;

/**
 * Reference: https://www.baeldung.com/java-builder-pattern-freebuilder
 */
@FreeBuilder
public interface Address {

	String getCity();

	int getPinCode();

	class Builder extends Address_Builder {

	}

}
