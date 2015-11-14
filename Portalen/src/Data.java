import java.util.ArrayList;
import java.util.Scanner;

public class Data {

	private ArrayList<Admin> brugere;
	private Admin currentBruger;
	ArrayList<Event> events;
	private Scanner input;

	public void generateUsers() {
//	//Her vises alle arrangementer som er oprettet på forhånd, 
//	hvor de bliver fordelt i kategorierne: Genre, kunstner, lokale og dato
		events = new ArrayList<Event>();
		events.add(new Event("Musik", "Justin Bieber", "Portalens Teatersal", "10/12/2015", 10));
		events.add(new Event("Musik", "Adele", "Portalens Teatersal", "05/07/2020", 10));
		events.add(new Event("Comedy", "Jonathan Spang", "Kabaret-scenen", "09/12/2026", 10));
		events.add(new Event("Comedy", "Anden", "Kabaret-scenen", "08/03/2052", 10));
		events.add(new Event("Scenekunst", "Nøddeknækkeren", "Mødelokale 1", "01/02/2005", 10));
		events.add(new Event("Scenekunst", "Snedronningen", "Mødelokale 1", "05/06/2006", 10));
		events.add(new Event("Børneunderholdning", "Trylleshow", "Foyersalen (Portalens Biograf)", "05/06/2053", 10));
		events.add(new Event("Børneunderholdning", "William Karberg", "Foyersalen (Portalens Biograf)", "26/02/2013", 10));

//Her vises alle brugere og admins, hvor man ser deres brugernavn (Sring) og passwords(Int)	
		brugere = new ArrayList<Admin>();
		brugere.add(new Bruger("a", 1, events));
		brugere.add(new Bruger("William Karberg", 1234, events));
		brugere.add(new Bruger("Simon Ottosen", 1234, events));
		brugere.add(new Bruger("Bianca Juul-Hansen", 1234, events));
		brugere.add(new Bruger("Peter Wynn Viuff", 1234, events));
		brugere.add(new Admin("b", 2));

	}
//Her ses login systemet
	public boolean login() {

		String username;
		int password;

		input = new Scanner(System.in);
//Her skal man indtaste brugernavn og password
		System.out.println("Indtast brugernavn for at logge ind: ");
		username = input.nextLine();
		System.out.println("Skriv dit password: ");
		password = input.nextInt();

		for (Admin bruger : brugere) {
//Her ses om brugernavn og password matcher, hvis ja så logger man ind 	
			if (bruger.getUsername().equals(username) && bruger.getPassword() == password) {
				setCurrentBruger(bruger);
				return true;
			}
		}
//Hvis nej så bliver dette udskrevet
		System.out.println("Forkert brugernavn eller kode, prøv igen\n");
		StartMenu program = new StartMenu();
		program.run();
		return false;

	}
		
//Getters & Setters
	public Admin getCurrentBruger() {
		return currentBruger;
	}

	public void setCurrentBruger(Admin bruger) {
		this.currentBruger = bruger;
	}
	
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
