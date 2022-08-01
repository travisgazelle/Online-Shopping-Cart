// Class to assist logic of main program
// To operate like a semi-functional store
import java.util.ArrayList;

public class ExistingAccounts {
	private ArrayList<Customer> customerAccounts;
	
	public ExistingAccounts() {
		// System.out.println("ExistingAccounts: constructor");
		// Container for existing accounts
		customerAccounts = new ArrayList<Customer>();
	}
	
	public void addAccount(Customer c) {
		// System.out.println("ExistingAccounts: addAccount");
		// Add new accounts created during program run
		customerAccounts.add(c);
	}
	
	public int findCustomer(String e) {
		// System.out.println("ExistingAccounts: findCustomer");
		// Return customer index if within ArrayList
		int index = -1;
		for(int i = 0; i < customerAccounts.size(); i++) {
			if(e.equalsIgnoreCase(customerAccounts.get(i).getEmail())) {
				index = i;
			}
		}
		return index;
	}
	
	public Customer getCustomer(int i) {
		// System.out.println("ExistingAccounts: getCustomer");
		// Return customer at index i to access account information
		return customerAccounts.get(i);
	}
	
}