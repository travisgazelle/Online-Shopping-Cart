
import java.util.UUID;

public class Customer {
	private String id;
	private String address;
	private String phone;
	private String email;
	private Account account;
	private boolean webUserFlag = false;
	private WebUser webUser;
	
	public Customer(String a, String p, String e) {
		// System.out.println("Customer: constructor");
		id = UUID.randomUUID().toString();
		address = a;
		phone = p;
		email = e;
		// New account for customer at construction
		account = new Account(id, address);

	}
	
	public String getAddress() {
		// System.out.println("Customer: getAddress");
		return address;
	}
	
	public String getPhone() {
		// System.out.println("Customer: getPhone");
		return phone;
	}
	
	public String getEmail() {
		// System.out.println("Customer: getEmail");
		return email;
	}
	
	public String getId() {
		// System.out.println("Customer: getId");
		return id;
	}
	
	public Account getAccount() {
		// System.out.println("Customer: getAccount");
		// Return account associated with customer?
		return account;
	}
	
	public boolean getWebStatus() {
		// System.out.println("Customer: getWebStatus");
		// Flag to indicate status of web access
		return webUserFlag;
	}
	
	public void activateWebUser(String pw) {
		// System.out.println("Customer: activateWebUser");
		// Activate first-time web user
		webUser = new WebUser(this.id, pw);
		webUserFlag = true;
	}
	
	public WebUser getWebUser() {
		// System.out.println("Customer: getWebUser");
		return webUser;
	}

}
