import java.util.ArrayList;

public class Admin {

	
	
	protected String username;
	protected int password;

	public Admin(String username, int password) {
		this.username = username;
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;

	}

	
}
