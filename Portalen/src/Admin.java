// Prorgrammering
// Semesterprojekt 2015
// Ansvaret for denne klasse har tilhørt
// Peter
// Gruppe 08
public class Admin {

	
	
	protected String username;
	protected String password;

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
		
	}
	//opretter getter og setter for username og password
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	
}
