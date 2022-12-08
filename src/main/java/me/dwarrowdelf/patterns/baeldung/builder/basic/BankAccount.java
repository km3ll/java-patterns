package me.dwarrowdelf.patterns.baeldung.builder.basic;

/**
 * Reference:
 * https://www.baeldung.com/creational-design-patterns#1-builder-pattern-example
 */
public class BankAccount {

	private String name;

	private String accountNumber;

	private String email;

	private boolean newsletter;

	private BankAccount(String name, String accountNumber, String email, boolean newsletter) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.email = email;
		this.newsletter = newsletter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public static class Builder {

		private String name;

		private String accountNumber;

		private String email;

		private boolean newsletter;

		// Mandatory fields
		public Builder(String name, String accountNumber) {
			this.name = name;
			this.accountNumber = accountNumber;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withNewsletter(boolean newsletter) {
			this.newsletter = newsletter;
			return this;
		}

		public BankAccount build() {
			return new BankAccount(name, accountNumber, name, newsletter);
		}

	}

}
