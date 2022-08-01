
public class LineItem {
	private int quantity;
	private double price;
	private Product product;
	
	public LineItem(int q, double pri, Product pro) {
		// System.out.println("LineItem: constructor");
		quantity = q;
		price = pri;
		product = pro;
	}
	
	public int getQuantity() {
		// System.out.println("LineItem: getQuantity");
		return quantity;
	}
	
	public double getPrice() {
		// System.out.println("LineItem: getPrice");
		return price;
	}
	
	public Product getProduct() {
		// System.out.println("LineItem: getProduct");
		return product;
	}
	
}
