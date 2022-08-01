
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
	private Date created;
	private ArrayList<LineItem> shoppingcart;
	
	public ShoppingCart() {
		// System.out.println("ShoppingCart: constructor");
		created = new Date();
		// ArrayList for shopping cart to hold LineItems
		shoppingcart = new ArrayList<LineItem>(); 
	}
	
	public Date getDate() {
		// System.out.println("ShoppingCart: getDate");
		return created;
	}
	
	public ArrayList<LineItem> getShoppingCart() {
		// System.out.println("ShoppingCart: getShoppingCart");
		return shoppingcart;
	}
	
	public void updateCart(LineItem l) {
		// System.out.println("ShoppingCart: updateCart");
		// Add item to shopping cart
		shoppingcart.add(l);
	}
	
}
