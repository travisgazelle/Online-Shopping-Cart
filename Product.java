
import java.util.UUID;

public class Product {
	private String id;
	private String name;
	private String supplier;
	private double price;
	
	public Product(String n, String s, double p) {
		// System.out.println("Product: constructor");
		id = UUID.randomUUID().toString();
		name = n;
		supplier = s;
		price = p;
	}
	
	public String getId() {
		// System.out.println("Product: getId");
		return id;
	}
	
	public String getName() {
		// System.out.println("Product: getName");
		return name;
	}
	
	public String getSupplier() {
		// System.out.println("Product: getSupplier");
		return supplier;
	}
	
	public double getPrice() {
		// System.out.println("Product: getPrice");
		return price;
	}
	
}
