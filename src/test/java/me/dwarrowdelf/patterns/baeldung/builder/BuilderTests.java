package me.dwarrowdelf.patterns.baeldung.builder;

import me.dwarrowdelf.patterns.baeldung.builder.basic.BankAccount;
import me.dwarrowdelf.patterns.baeldung.builder.basic.Employee;
import me.dwarrowdelf.patterns.baeldung.builder.freebuilder.Address;
import me.dwarrowdelf.patterns.baeldung.builder.freebuilder.Owner;
import me.dwarrowdelf.patterns.baeldung.builder.freebuilder.Pet;
import org.junit.Test;

import java.util.Optional;
import static org.junit.Assert.*;

/**
 * References:
 * https://www.baeldung.com/creational-design-patterns#1-builder-pattern-example
 * https://www.baeldung.com/java-builder-pattern-freebuilder
 */
public class BuilderTests {

	@Test
	public void accountBasicBuilder_should_create_an_instance() {

		BankAccount newAccount = new BankAccount.Builder("John", "110011").withEmail("john@testdrive.com")
				.withNewsletter(true).build();
		assertNotNull(newAccount.getName());

	}

	@Test
	public void employeeBasicBuilder_should_create_an_instance() {

		Employee.Builder builder = new Employee.Builder();
		Employee employee = builder.setName("John").setAge(37).setDepartment("Builder pattern").build();
		assertEquals("John", employee.getName());
		assertEquals(37, employee.getAge());

	}

	@Test
	public void petFreeBuilder_should_create_an_instance() {

		Pet.Builder builder = new Pet.Builder();
		Pet pet = builder.name("Onix").age(3).owner("John").build();
		assertEquals("Onix", pet.name());
		assertEquals(3, pet.age());

	}

	@Test
	public void ownerFreeBuilder_should_create_an_instance() {

		Address.Builder addressBuilder = new Address.Builder();
		addressBuilder.setCity("New York");
		addressBuilder.setPinCode(110011);

		Owner.Builder ownerBuilder = new Owner.Builder();
		// Auto-generated setters and getters
		Owner owner = ownerBuilder.setName("John").setLastName("Wick").setAge(33).setDiscount(1000000)
				.mapDiscount(value -> value * 0.01) // Mapper methods
				.addAccessTokens(1221819L) // Collections
				.addAccessTokens(1223441L, 134567L).putAssetsSerialIdMapping("Laptop", 12345L) // Maps
				.setEmail("johnwick@gmail.com") // Constraint checks
				.setAddress(addressBuilder) // Nested builders
				.mutateAddress(address -> address.setPinCode(112200)) // Mutate nested
																		// object
				.build();

		assertEquals("John", owner.getName());
		assertEquals("Wick", owner.getLastName());
		assertEquals(33, owner.getAge());
		assertTrue(owner.getDiscount().isPresent());
		assertEquals(Optional.of(10000D), owner.getDiscount());
		assertEquals("Default", owner.getDepartment()); // Default values
		assertFalse(owner.getDateOfJoining().isPresent()); // Optional field
		assertNull(owner.getCurrentProject()); // @Nullable
		assertTrue(owner.getAccessTokens().contains(1221819L)); // Collections
		assertTrue(owner.getAssetsSerialIdMapping().containsKey("Laptop")); // Maps
		assertEquals("johnwick@gmail.com", owner.getEmail()); // // Constraint checks
		assertEquals("New York", owner.getAddress().getCity()); // Nested builders
		assertEquals(112200, owner.getAddress().getPinCode()); // Mutated nested object

	}

	@Test
	public void ownerFreeBuilder_should_create_a_partial_object() {

		Owner.Builder builder = new Owner.Builder();
		Owner owner = builder.setName("John").setLastName("Wick").setAge(33).buildPartial();

		assertEquals("John", owner.getName());
		assertEquals("Wick", owner.getLastName());
		assertEquals(33, owner.getAge());
		assertFalse(owner.getDiscount().isPresent());
		assertEquals("Default", owner.getDepartment());
		assertNull(owner.getCurrentProject());

	}

}