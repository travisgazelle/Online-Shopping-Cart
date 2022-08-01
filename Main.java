import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int choice = -1;
		int again = -1;
		// Container to hold existing accounts to simulate working system
		ExistingAccounts accountAccess = new ExistingAccounts();
		Customer customer = new Customer("", "", "");
		Customer temp = new Customer("", "", "");
		boolean existing = false;
		boolean check = false;
		boolean valid = false;
		// ArrayList to hold products to display to user
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product("Jean Jacket", "Levi's", 65.99));
		products.add(new Product("Topsider", "Sperry", 70.99));
		products.add(new Product("Air Jordan", "Nike", 101.89));
		products.add(new Product("Sweater", "Calven Klein", 125.89));
		products.add(new Product("T-Shirt", "Hanes", 13.99));
		products.add(new Product("Socks", "Basics", 8.99));
		products.add(new Product("A's Baseball Cap", "New Era", 35.89));
		products.add(new Product("Sweats", "Adidas", 52.99));
		products.add(new Product("Tank Top", "Casuals", 6.89));
		products.add(new Product("Classics", "Vans", 60.89));
		// Menu option prompt
		System.out.println("Choose from the following options: ");
		System.out.println("Enter 1 to create a new account ");
		System.out.println("Enter 2 to access an existing account ");
		choice = keyboard.nextInt();
		keyboard.nextLine();
		// Handle bad input	
		while(choice < 1 || choice > 2) {
			System.out.println("Error, invalid choice ");
			System.out.println("Enter '1' to create a new account or '2' for an existing account ");
			choice = keyboard.nextInt();
			keyboard.nextLine();
		}
		// Switch case for user input	
		switch(choice) {
		case 1:
			// Create new account
			System.out.println("Enter your address ");
			String address = keyboard.nextLine();
			System.out.println("Enter your phone number ");
			String phone = keyboard.nextLine();
			System.out.println("Enter your email ");
			String email = keyboard.nextLine();
			temp = new Customer(address, phone, email);
			accountAccess.addAccount(temp);
			break;
				
		case 2:
			// Access existing account with email as key
			System.out.println("Enter your email address ");
			String checkEmail = keyboard.nextLine();
			int index = accountAccess.findCustomer(checkEmail);
			if(index == -1) {
				System.out.println("Account not found, please try again ");
				System.exit(0);;
			}
			else {
				customer = accountAccess.getCustomer(index);
				existing = true;
			}				
			break;
		}
		// Do-while loop to allow user to choose one or more options from menu
		do {
			System.out.println("Menu Options: Choose from the following options");
			System.out.println("1: View shopping cart ");
			System.out.println("2: Place a new order ");
			System.out.println("3: Check order status ");
			System.out.println("4: View products ");
			System.out.println("5: Make payment ");
			System.out.println("6: Add to shopping cart ");

			choice = keyboard.nextInt();
			keyboard.nextLine();
			// Handle bad input
			while(choice < 1 || choice > 6) {
				System.out.println("Error: ");
				System.out.println("1: Shopping cart 2: New order 3: Order status + "
						+ "4: View products 5: Make payment 6: Add to shopping cart ");
				choice = keyboard.nextInt();
				keyboard.nextLine();
			}
			// Access shopping cart
			switch(choice) {
			case 1:
				ArrayList<LineItem> tempCart;
				// Verify whether customer is web user
				check = customer.getWebStatus();
				// If not an active web user create password to activate
				if(check == false) {
					System.out.println("You are not an active web user ");
					System.out.println("Enter a password to activate web privileges ");
					String pw = keyboard.nextLine();
					// Activate web user if not already activated
					customer.activateWebUser(pw);
				}
				// If already a web user, check password
				System.out.println("Enter your password to view shopping cart: ");
				String password = keyboard.nextLine();
				valid = customer.getWebUser().checkPassword(password);
				// If password correct then get cart attached to customer account
				if(valid == true) {
					tempCart = customer.getAccount().getCart().getShoppingCart();	
				}
				else {
					System.out.println("Invalid password! ");
					break;
				}
				// Display cart
				System.out.println("Your cart contains:");
				for(int i = 0; i < tempCart.size(); i++) {
					System.out.println("Item " + (i + 1) + ": " + tempCart.get(i).getProduct().getName());
				}
				break;
			// Create new order
			case 2:
				int qty = 0;
				double total = 0.0;
				System.out.println("Please enter your shipping address for the order");
				String address = keyboard.nextLine();
				Order order = new Order(address);
				// Display products
				System.out.println("To create a new order, please select from the following items: ");
				for(int i = 0; i < products.size(); i++) {
					System.out.println(i + 1 + ": " + products.get(i).getName() + " " + products.get(i).getSupplier());
				}
				boolean cont = true;
				// While loop: add new line items to order
				while(cont == true) {
					System.out.println("Enter the item number that you would like: ");
					choice = keyboard.nextInt();
					keyboard.nextLine();
					System.out.println("Enter the quantity: ");
					qty = keyboard.nextInt();
					keyboard.nextLine();
					LineItem item = new LineItem(qty, (products.get(choice - 1).getPrice() * qty), products.get(choice - 1));
					total += (products.get(choice - 1).getPrice() * qty);
					order.addProduct(item);
					System.out.println("Would you like to add another product? 1 for yes, 2 for no ");
					choice = keyboard.nextInt();
					keyboard.nextLine();
					if(choice == 2) {
						cont = false;
					}
				}
				// Set order total and add order to customer account
				order.setTotal(total);
				customer.getAccount().newOrder(order);			
				break;
			// Check order status
			case 3:
				System.out.println("Please enter your order number: ");
				choice = keyboard.nextInt();
				keyboard.nextLine();
				// Check orders for given order number
				for(int i = 0; i < customer.getAccount().getOrders().size(); i++) {
					int x = Integer.parseInt(customer.getAccount().getOrders().get(i).getOrderNumber());
					// If order found, display status
					if(choice == x) {
						System.out.println("Order number: " + choice + " " + customer.getAccount().getOrders().get(i).getOrderStatus());
					}
				}
				break;
			// List product catalog
			case 4:
				System.out.println("Current Products:");
				for(int i = 0; i < products.size(); i++) {
					System.out.println(i + 1 + ": " + products.get(i).getName() + " " + products.get(i).getSupplier());
				}
				break;
			// Make payment
			case 5:
				// Payment(total, details)
				double paymentTotal = 0.0;
				String details = "";
				boolean found = false;
				System.out.println("Enter the order number for your payment ");
				choice = keyboard.nextInt();
				keyboard.nextLine();
				// Check orders for given order number
				for(int i = 0; i < customer.getAccount().getOrders().size(); i++) {
					int x = Integer.parseInt(customer.getAccount().getOrders().get(i).getOrderNumber());
					// If order found, get total + details
					if(choice == x) {
						System.out.println("Total: " + customer.getAccount().getOrders().get(i).getTotal());
						paymentTotal = customer.getAccount().getOrders().get(i).getTotal();
						details = customer.getAccount().getOrders().get(i).getOrderNumber();
						found = true;
					}
				}
				if(found == true) {
					Payment payment = new Payment(paymentTotal, details);
					customer.getAccount().addPayment(payment);
				}
				else {
					System.out.println("Order not found ");
				}
				break;
			// Add to shopping cart
			case 6:
				// Display products
				System.out.println("To add an item to your cart, please select from the following items: ");
				for(int i = 0; i < products.size(); i++) {
					System.out.println(i + 1 + ": " + products.get(i).getName() + " " + products.get(i).getSupplier());
				}
				System.out.println("Enter the item number that you want to add to your cart: ");
				choice = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("Enter the quantity: ");
				qty = keyboard.nextInt();
				keyboard.nextLine();
				LineItem item = new LineItem(qty, (products.get(choice - 1).getPrice() * qty), products.get(choice - 1));
				customer.getAccount().getCart().updateCart(item);
				break;
			}
			// Allow user to view menu options again or quit
			System.out.println("Continue? Enter '1' for yes or '2' to quit ");
			again = keyboard.nextInt();
			keyboard.nextLine();
			// Handle bad input
			while(again < 1 || again > 2) {
				System.out.println("Error, invalid choice ");
				System.out.println("Enter '1' for yes or '2' to quit ");
				again = keyboard.nextInt();
				keyboard.nextLine();
			}
			// Simulate shipping orders
			for(int i = 0; i < customer.getAccount().getOrders().size(); i++) {
				if(i % 2 == 0) {
					customer.getAccount().getOrders().get(i).setShipped();
				}
			}
		} while (again == 1);
		// Close scanner
		keyboard.close();
		// Display shipping status
		for(int i = 0; i < customer.getAccount().getOrders().size(); i++) {
			System.out.println("Order number " + (i + 1) + " " + customer.getAccount().getOrders().get(i).getOrderStatus());
		}
	}

}

