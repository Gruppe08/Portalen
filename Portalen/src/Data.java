import java.util.ArrayList;

public class Data {

	private ArrayList<Admin> brugere;
	ArrayList<Event> events;

	public void generateUsers() {
//	//Her vises alle arrangementer som er oprettet på forhånd, 
//	hvor de bliver fordelt i kategorierne: Genre, kunstner, lokale og dato
		events = new ArrayList<Event>();
		events.add(new Event("Musik", "Justin Bieber", "Portalens Teatersal", "10/12/2015", 10));
		events.add(new Event("Musik", "Adele", "Portalens Teatersal", "05/07/2020", 43));
		events.add(new Event("Comedy", "Jonathan Spang", "Kabaret-scenen", "09/12/2026", 24));
		events.add(new Event("Comedy", "Anden", "Kabaret-scenen", "08/03/2052", 30));
		events.add(new Event("Scenekunst", "Nøddeknækkeren", "Mødelokale 1", "01/02/2005", 450));
		events.add(new Event("Scenekunst", "Snedronningen", "Mødelokale 1", "05/06/2006", 52));
		events.add(new Event("Børneunderholdning", "Trylleshow", "Foyersalen (Portalens Biograf)", "05/06/2053", 231));
		events.add(new Event("Børneunderholdning", "William Karberg", "Foyersalen (Portalens Biograf)", "26/02/2013", 250));

//Her vises alle brugere og admins, hvor man ser deres brugernavn (Sring) og passwords(Int)	
		brugere = new ArrayList<Admin>();
		brugere.add(new Bruger("a", 1, events));
		brugere.add(new Bruger("William Karberg", 1234, events));
		brugere.add(new Bruger("Simon Ottosen", 1234, events));
		brugere.add(new Bruger("Bianca Juul-Hansen", 1234, events));
		brugere.add(new Bruger("Peter Wynn Viuff", 1234, events));
		brugere.add(new Admin("b", 2));

	}

		
//Getters & Setters
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public ArrayList<Admin> getBruger() {
		return brugere;

	}

	public void setBruger(ArrayList<Admin> bruger) {
		this.brugere = bruger;

	}

}
