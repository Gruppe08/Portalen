import java.util.ArrayList;

public class EventBruger {

	private String name;
	private String password;
	private ArrayList<Event> events;

	public EventBruger(String name, String password, ArrayList<Event> events) {

		this.name = name;
		this.password = password;
		this.events = events;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
}
