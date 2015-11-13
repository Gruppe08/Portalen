import java.util.Scanner;
public class EventKontrol {
	
	private Scanner input;
	private Data db; 
	
	public EventKontrol(Scanner input, Data db) {
		this.input = input;
		this.db = db;
	}
	public void listOfEvents() {
		if (db.getEvents().size() == 0) {
			System.out.println("Der er ingen arrangementer");
		} else {
			System.out.println("Her er alle eksisterende arrangementer: ");
			for (Event event : db.getEvents()) {
				System.out.println("Genre: " + event.getGenre());
				System.out.println("Kunstner: " + event.getKunstner());
				System.out.println("Lokale: " + event.getLokale());
				System.out.println("Dato: " + event.getDato());
				System.out.println("___________________________");
			}
		}
	}
	public void addEvent() {
		System.out.println("Skriv genre: ");
		String genre = input.next();
		System.out.println("Skriv kunstner: ");
		String kunstner = input.next();
		System.out.println("Vælg lokale: ");
		System.out.println("Tast 1 for Portalens Teatersal - Det er muligt at leje Portalens lokaler med plads til mellem 10 og 752 personer.");
		System.out.println("Tast 2 for Kabaret-scenen - 120 personer ved café-borde / 150 personer på stolerækker");
		System.out.println("Tast 3 for Mødelokale 1 - 80 personer ved café-borde / 120 personer på stolerækker");
		System.out.println("Tast 4 for Foyersalen (Portalens Biograf) - 80 personer på stolerækker");
		
		int lokale = input.nextInt();
		String nylokale = null;
		switch (lokale) {
		case 1:
			nylokale = "Portalens Teatersal";
			break;
		case 2:
			nylokale = "Kabaret-scenen";
			break;
		case 3:
			nylokale = "Mødelokale 1";
			break;
		case 4:
			nylokale = "Foyersalen (Portalens Biograf)";
			break;
		}
		System.out.println("Skriv dato: ");
		String dato = input.next();
		Event event = new Event(genre, kunstner, nylokale, dato);
		db.getEvents().add(event);
	}
	public void deleteEvent() {
		for (Event event : db.getEvents()) {
			System.out.println(db.getEvents().indexOf(event) + ": " + event.getGenre() + ", "
					+ event.getKunstner() + ", " + event.getLokale() + ", " + event.getDato());
		}
		System.out.print("Hvilket arrangement skal slettes? ");
		db.getEvents().remove(input.nextInt());
	}
}