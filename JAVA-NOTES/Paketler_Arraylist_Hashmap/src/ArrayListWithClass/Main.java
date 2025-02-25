package ArrayListWithClass;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		customers.add(new Customer(1,"Serkan","Turgut"));		
		customers.add(new Customer(2,"Erkan","Turgut"));
		customers.add(new Customer(3,"Necip","Turgut"));
		
		for (Customer customer: customers) {
			System.out.print(customer._id + "-");
			System.out.print(customer._firstName + " ");
			System.out.println(customer._lastName);

		}

	}

}
