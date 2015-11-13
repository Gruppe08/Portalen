import java.util.ArrayList;

public class Bruger extends Admin {

	
	private ArrayList<Event> events;

	public Bruger(String username, int password, ArrayList<Event> events) {
		super(username, password);
		this.events = events;
	
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

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
}
