package me.dwarrowdelf.patterns.baeldung.builder.freebuilder;

import org.inferred.freebuilder.FreeBuilder;

/**
 * Reference: https://www.baeldung.com/java-builder-pattern-freebuilder
 */
@FreeBuilder
public interface Pet {

	String name();

	int age();

	String owner();

	class Builder extends Pet_Builder {

	}

}
