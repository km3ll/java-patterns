package me.dwarrowdelf.patterns.baeldung.builder.freebuilder;

import org.inferred.freebuilder.FreeBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Reference: https://www.baeldung.com/java-builder-pattern-freebuilder
 */
@FreeBuilder
public interface Owner {

	// Java Bean naming convention for methods
	String getName();

	String getLastName();

	int getAge();

	// Mapper method
	Optional<Double> getDiscount();

	// Default values
	String getDepartment();

	// Optional field
	Optional<String> getDateOfJoining();

	// Nullable for backward compatibility
	@Nullable
	String getCurrentProject();

	// Collections
	List<Long> getAccessTokens();

	// Maps
	Map<String, Long> getAssetsSerialIdMapping();

	// Constraint checks
	String getEmail();

	// Nested builders
	Address getAddress();

	class Builder extends Owner_Builder {

		public Builder() {
			setDepartment("Default");
		}

		@Override
		public Builder setEmail(String email) {
			if (checkValidEmail(email)) {
				return super.setEmail(email);
			}
			else {
				throw new IllegalArgumentException(("Invalid email: " + email));
			}
		}

		private boolean checkValidEmail(String email) {
			return email.contains("@");
		}

	}

}
