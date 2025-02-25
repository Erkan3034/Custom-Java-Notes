package Study_Exercises;

/*
 * Non-Static Inner Class*/

class BankAccount {
	private double balance;

	BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}

	// ======= NON-STATIC INNER CLASS'lar Outer Class NESNESİNE BAĞIMLIDIR======================\\
	
	class Customer { //Non-Static İnner Class(Outer Class Ögelerine Doğrudan Erişebilir)
		private String name;
		private String email;

		Customer(String name, String email) { //Constructor
			this.name = name;
			this.email = email;
		}

		void displayCustomerInfo() {
			System.out.println("Customer Name: " + name);
			System.out.println("Customer Email: " + email);
		}
	}

	void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited: $" + amount + ", New Balance: $" + balance);
	}

	void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn: $" + amount + ", New Balance: $" + balance);
		} else {
			System.out.println("Insufficient balance.");
		}
	}
}

public class NonStaticExample {
	public static void main(String[] args) {
		BankAccount account = new BankAccount(500);
		BankAccount.Customer customer = account.new Customer("John Doe", "john.doe@example.com"); //Inner Class Call(NESNEYE BAĞIMLIDIR

		customer.displayCustomerInfo();
		account.deposit(200);
		account.withdraw(150);
	}
}