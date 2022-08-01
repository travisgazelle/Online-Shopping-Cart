
import java.util.Date;
import java.util.UUID;

public class Payment {
	private String id;
	private Date paid;
	private double total;
	private String details;
	
	public Payment(double t, String d) {
		// System.out.println("Payment: constructor");
		id = UUID.randomUUID().toString();
		paid = new Date();
		total = t;
		details = d;
	}
	
	public String getId() {
		// System.out.println("Payment: getId");
		return id;
	}
	
	public Date getDatePaid() {
		// System.out.println("Payment: getDatePaid");
		return paid;
	}
	
	public double getTotal() {
		// System.out.println("Payment: getTotal");
		return total;
	}
	
	public String getDetails() {
		// System.out.println("Payment: getDetails");
		return details;
	}
	
}
