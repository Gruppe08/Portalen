import java.util.ArrayList;
import java.util.Scanner;

public class Data {

	private ArrayList<Admin> brugere;
	private Admin currentBruger;
	ArrayList<Event> events;

	public void generateUsers() {

		events = new ArrayList<Event>();
		events.add(new Event("Pop", "Bieber", "SP12", "12/12/2016"));
		
		brugere = new ArrayList<Admin>();
		brugere.add(new Bruger("a", 1, events));
		brugere.add(new Bruger("William Karberg", 1234, events));
		brugere.add(new Bruger("Simon Ottosen", 1234, events));
		brugere.add(new Bruger("Bianca Juul-Hansen", 1234, events));
		brugere.add(new Bruger("Peter Wynn Viuff", 1234, events));
		brugere.add(new Admin("b", 2));

	}

	public boolean login() {

		String username;
		int password;

		Scanner input = new Scanner(System.in);

		System.out.println("Indtast brugernavn for at logge ind: ");
		username = input.nextLine();
		System.out.println("Skriv dit password: ");
		password = input.nextInt();

		for (Admin bruger : brugere) {
			
			if (bruger.getUsername().equals(username) && bruger.getPassword() == password) {
				setCurrentBruger(bruger);
				return true;
			}
		}
		System.out.println("Forkert brugernavn eller kode, prøv igen\n");
		StartMenu program = new StartMenu();
		program.run();
		return false;

	}
		

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
