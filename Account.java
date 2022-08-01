
import java.util.ArrayList;
import java.util.Date;

public class Account {
	private String id;
	private String billing_address;
	private boolean is_closed = false;
	private Date open;
	private Date closed;
	private ShoppingCart cart;
	private ArrayList<Order> orders;
	private ArrayList<Payment> payments;
	
	public Account(String i, String ba) {
		// System.out.println("Account: constructor");
		id = i;
		billing_address = ba;
		open = new Date();
		// Shopping cart tied to account
		cart = new ShoppingCart();
		// List of orders
		orders = new ArrayList<Order>();
		// List of payments
		payments = new ArrayList<Payment>();
	}
	
	public void closeAccount() {
		// System.out.println("Account: closeAccount");
		closed = new Date();
		is_closed = true;
	}
	
	public void newOrder(Order o) {
		// System.out.println("Account: newOrder");
		// New order from account
		orders.add(o);
	}
		
	public String getId() {
		// System.out.println("Account: getId");
		return id;
	}
	
	public String getAddress() {
		// System.out.println("Account: getAddress");
		return billing_address;
	}
	
	public boolean getAccountStatus() {
		// System.out.println("Account: getAccountStatus");
		return is_closed;
	}
	
	public Date getDateOpen() {
		// System.out.println("Account: getDateOpen");
		return open;
	}
	
	public Date getDateClosed() {
		// System.out.println("Account: getDateClosed");
		return closed;
	}
	
	public ShoppingCart getCart() {
		// System.out.println("Account: getCart");
		return cart;
	}
	
	public ArrayList<Order> getOrders() {
		// System.out.println("Account: getOrders");
		return orders;
	}
	
	public ArrayList<Payment> getPayment() {
		// System.out.println("Account: getPayment");
		return payments;
	}
	
	public void addPayment(Payment p) {
		// System.out.println("Account: addPayment");
		// Add payment to list of cusomer payments
		payments.add(p);
	}
	
}
