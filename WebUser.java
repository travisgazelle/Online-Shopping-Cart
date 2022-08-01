
public class WebUser {
	private String login_id;
	private String password;
	private UserState state;
	
	public WebUser(String id, String pw) {
		// System.out.println("WebUser: constructor");
		login_id = id;
		password = pw;
		// Set state as NEW
		state = UserState.NEW;
	}
	
	public String getID() {
		// System.out.println("WebUser: getID");
		return login_id;
	}
	
	public UserState getUserState() {
		// System.out.println("WebUser: getUserState");
		return state;
	}
	
	public void setState(UserState s) {
		// System.out.println("WebUser: setState");
		state = s;
	}
	
	public boolean checkPassword(String pw) {
		// System.out.println("WebUser: checkPassword");
		// Verify password is correct
		if(password.equals(pw)) {
			// Update state to active
			state = UserState.ACTIVE;
			return true;
		}
		else
			return false;
	}

}
