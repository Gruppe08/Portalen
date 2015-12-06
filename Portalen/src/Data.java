// Prorgrammering
// Semesterprojekt 2015
// Ansvaret for denne klasse har tilhørt
// William
// Gruppe 08
import java.util.ArrayList;

public class Data {

	private ArrayList<Admin> users;
	ArrayList<Event> events;

	public void generateUsers() {
//	Her vises alle arrangementer som er oprettet på forhånd, 
//	hvor de bliver fordelt i kategorierne: Genre, kunstner, lokale og dato
		events = new ArrayList<Event>();
		events.add(new Event("Musik", "Justin Bieber", "Portalens Teatersal", "10/12/2015", 10));
		events.add(new Event("Musik", "Adele", "Portalens Teatersal", "05/07/2020", 43));
		events.add(new Event("Comedy", "Jonathan Spang", "Kabaret-scenen", "09/12/2026", 24));
		events.add(new Event("Comedy", "Anden", "Kabaret-scenen", "08/03/2052", 30));
		events.add(new Event("Scenekunst", "Nøddeknækkeren", "Mødelokale 1", "01/02/2005", 450));
		events.add(new Event("Scenekunst", "Snedronningen", "Mødelokale 1", "05/06/2006", 52));
		events.add(new Event("Børneunderholdning", "Mystiske Mr. Mox", "Foyersalen (Portalens Biograf)", "05/06/2053", 231));
		events.add(new Event("Børneunderholdning", "William Karberg", "Foyersalen (Portalens Biograf)", "26/02/2013", 250));

//Her vises alle users og admins, hvor man ser deres usernavn (Sring) og passwords(Int)	
		users = new ArrayList<Admin>();
		users.add(new User("user", "user", events));
		users.add(new User("William Karberg", "kode", events));
		users.add(new User("Simon Ottosen", "1234", events));
		users.add(new User("Bianca Juul-Hansen", "1234", events));
		users.add(new User("Peter Wynn Viuff", "1234", events));
		users.add(new Admin("admin", "admin"));

	}

		
//Getters & Setters
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public ArrayList<Admin> getuser() {
		return users;

	}

	public void setuser(ArrayList<Admin> user) {
		this.users = user;

	}

}
