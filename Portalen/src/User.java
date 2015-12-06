// Prorgrammering
// Semesterprojekt 2015
// Ansvaret for denne klasse har tilhørt
// Peter
// Gruppe 08
import java.util.ArrayList;

//Her giver vi useren samme rettigheder som Admin dog har useren ikke ret til at at oprette eller slette andre usere.

public class User extends Admin {

	//Her oprettes et ArrayList som indeholder de forskellige arrangementer, som der er -og bliver oprettet.

	private ArrayList<Event> events;

	public User(String username, String password, ArrayList<Event> events) {
		super(username, password);
		this.events = events;
	
	}
//Her oprettes getter og setter for username, password og arraylisten


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

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
}