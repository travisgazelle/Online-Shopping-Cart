
import java.util.ArrayList;
import java.util.Date;

public class Order {
	// Maintain static # of orders
	private static int orderNum = 1;
	private String number;
	private Date ordered;
	private Date shipped;
	private String ship_to;
	private OrderStatus status;
	private double total;
	private ArrayList<LineItem> order; 
	
	public Order(String a) {
		// System.out.println("Order: constructor");
		// Container for LineItems in order
		order = new ArrayList<LineItem>();
		number = Integer.toString(orderNum);
		ordered = new Date();
		ship_to = a;
		status = OrderStatus.NEW;
		orderNum += 1;
		total = 0.0;
	}
	
	public void setShipped() {
		// System.out.println("Order: setShipped");
		// Update order status + date shipped
		shipped = new Date();
		status = OrderStatus.SHIPPED;
	}
	
	public void setOrderStatus(OrderStatus s) {
		// System.out.println("Order: setOrderStatus");
		status = s;
	}
	
	public void addProduct(LineItem l) {
		// System.out.println("Order: addProduct");
		// Add product to order
		this.order.add(l);
	}
	
	public void setTotal(double t) {
		// System.out.println("Order: setTotal");
		// Update order total
		total = t;
	}
	
	public ArrayList<LineItem> getOrder() {
		// System.out.println("Order: getOrder");
		return order;
	}
	
	public String getOrderNumber() {
		// System.out.println("Order: getOrderNumber");
		return number;
	}
	
	public Date getDateOrdered() {
		// System.out.println("Order: getDateOrdered");
		return ordered;
	}
	
	public Date getDateShipped() {
		// System.out.println("Order: getDateShipped");
		return shipped;
	}
	
	public String getAddress() {
		// System.out.println("Order: getAddress");
		return ship_to;
	}
	
	public OrderStatus getOrderStatus() {
		// System.out.println("Order: getOrderStatus");
		// Returns the current status of the order
		return status;
	}
	
	public double getTotal() {
		// System.out.println("Order: getTotal");
		return total;
	}
	
}
