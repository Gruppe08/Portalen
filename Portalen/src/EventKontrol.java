import java.util.Scanner;
import java.util.Set;
public class EventKontrol {
	
	private Scanner input;
	private Data db; 
	
	public EventKontrol(Scanner input, Data db) {
		this.input = input;
		this.db = db;
	}
	//Her er det muligt at få udskrevet alle events
	public void listOfEvents() {								
	//Hvis den ikke har arrangementer, så udskriv nedenstående besked
		if (db.getEvents().size() == 0) {						
			System.out.println("Der er ingen arrangementer\n____________");
		} else {												
	//Hvis der findes arrangenemter, så udskriv dem
			System.out.println("Her er alle eksisterende arrangementer: ");
			for (Event event : db.getEvents()) {
				System.out.println("Genre: " + event.getGenre());
				System.out.println("Kunstner: " + event.getKunstner());
				System.out.println("Lokale: " + event.getLokale());
				System.out.println("Dato: " + event.getDato());
				System.out.println("Besøgende: " + event.getVisitor());
			

				System.out.println("___________________________");
			}
		}
	}
	//Et nyt afsnit til at tilføje events
	public void addEvent() {	
		System.out.println("Vælg genre: ");
		System.out.println("Tast 1 for Musik (Rock, Pop, Jazz m.m)");
		System.out.println("Tast 2 for Comedy (Stand-up, Sketchshow m.m)");
		System.out.println("Tast 3 for Scenekunst (Teater, Musicals m.m)");
		System.out.println("Tast 4 for Børneunderholdning (Trylleri, Cirkusklovne m.m)");
		//Her har vi indsat en switch som bliver brugt til at vælge hvilken genre det skal være
		String genre = input.next();
		String nygenre = "Ingen genre";
		switch (genre) {
		case "1":
			nygenre = "Musik";
			break;
		case "2":
			nygenre = "Comedy";
			break;
		case "3":
			nygenre = "Scenekunst";
			break;
		case "4":
			nygenre = "Børneunderholdning";
			break;
		}
		System.out.println("Skriv kunstner: ");
		input.nextLine();
		String kunstner = input.nextLine();
		
		System.out.println("Vælg lokale: ");
		System.out.println("Tast 1 for Portalens Teatersal - Det er muligt at leje Portalens lokaler med plads til mellem 10 og 752 personer.");
		System.out.println("Tast 2 for Kabaret-scenen - 120 personer ved café-borde / 150 personer på stolerækker");
		System.out.println("Tast 3 for Mødelokale 1 - 80 personer ved café-borde / 120 personer på stolerækker");
		System.out.println("Tast 4 for Foyersalen (Portalens Biograf) - 80 personer på stolerækker");
		//Her har vi indsat endnu en switch som denne gang bliver den brugt til at vælge lokale
		String lokale = input.next();
		String nylokale = "Intet lokale";
		switch (lokale) {
		case "1":
			nylokale = "Portalens Teatersal";
			break;
		case "2":
			nylokale = "Kabaret-scenen";
			break;
		case "3":
			nylokale = "Mødelokale 1";
			break;
		case "4":
			nylokale = "Foyersalen (Portalens Biograf)";
			break;
		}
		System.out.println("Skriv dato, i følgende format: DD/MM/YYYY: ");
		
		String dato = input.next();
		//Vi sætter visitor til 0, da eventet jo bliver oprettet med 0 besøgende som start
		int visitor = 0;
		//Her sætter vi så et helt nyt event hvor vi opdaterer alle de krav vi har sat i Event.java
		Event event = new Event(nygenre, kunstner, nylokale, dato, visitor);
		db.getEvents().add(event);
	}
	//Dette afsnit ændrer eventet
	public void changeEvent() {	
		for (Event event : db.getEvents()) {
			System.out.println(db.getEvents().indexOf(event) + ": " + event.getGenre() + ", "
					+ event.getKunstner() + ", " + event.getLokale() + ", " + event.getDato() + ", " + event.getVisitor());
		}
		System.out.print("Hvilket arrangement skal ændres? ");
		//Her vælger vi at slette det gamle event og bede brugeren om at indtaste de nye information som skal erstattes
		db.getEvents().remove(input.nextInt()); 
		System.out.println("Vælg type optræden: ");
		System.out.println("Tast 1 for Musik (Rock, Pop, Jazz m.m)");
		System.out.println("Tast 2 for Comedy (Stand-up, Sketchshow m.m)");
		System.out.println("Tast 3 for Scenekunst (Teater, Musicals m.m)");
		System.out.println("Tast 4 for Børneunderholdning (Trylleri, Cirkusklovne m.m)");
		
		String genre = input.next();
		String nygenre = "Ingen genre";
		switch (genre) {
		case "1":
			nygenre = "Musik";
			break;
		case "2":
			nygenre = "Comedy";
			break;
		case "3":
			nygenre = "Scenekunst";
			break;
		case "4":
			nygenre = "Børneunderholdning";
			break;
		}
		System.out.println("Skriv den nye kunstner: ");
		input.nextLine();
		String kunstner = input.nextLine();
		System.out.println("Vælg nyt lokale: ");
		System.out.println("Tast 1 for Portalens Teatersal - Det er muligt at leje Portalens lokaler med plads til mellem 10 og 752 personer.");
		System.out.println("Tast 2 for Kabaret-scenen - 120 personer ved café-borde / 150 personer på stolerækker");
		System.out.println("Tast 3 for Mødelokale 1 - 80 personer ved café-borde / 120 personer på stolerækker");
		System.out.println("Tast 4 for Foyersalen (Portalens Biograf) - 80 personer på stolerækker");
		
		String lokale = input.next();
		String nylokale = "Ingen lokale";
		switch (lokale) {
		case "1":
			nylokale = "Portalens Teatersal";
			break;
		case "2":
			nylokale = "Kabaret-scenen";
			break;
		case "3":
			nylokale = "Mødelokale 1";
			break;
		case "4":
			nylokale = "Foyersalen (Portalens Biograf)";
			break;
		}
		System.out.println("Skriv den nye dato, i følgende format: DD/MM/YYYY: ");
		String dato = input.next();
		System.out.println("Eventet er nu oprettet\n");										//Endnu ikke løst

		while (db.getEvents().equals(dato + nylokale)) {
			System.out.println("Denne er desværre allerede optaget, prøv igen");
		}
		
		int visitor = 0;
		Event event = new Event(nygenre, kunstner, nylokale, dato, visitor);
		db.getEvents().add(event);
	}


public void updateEventVisitor() {															//Endnu ikke løst
	for (Event event : db.getEvents()) {
		System.out.println(db.getEvents().indexOf(event) + ": " + event.getGenre() + ", "
				+ event.getKunstner() + ", " + event.getLokale() + ", " + event.getDato() + ", " + event.getVisitor());
		
		db.getEvents().remove(input.nextInt()); 

	event.setVisitor(20);
//	db.getEvents().setVisitor(20)(input.nextInt()); //Bedste løsning!
//	db.getEvents().set(visitor());
//	Visitor visitor = new Event(visitor);
//	db.getEvents().add(event);

	}
	//int visitor = input.nextInt();
	
	for (Event event : db.getEvents()) {
		System.out.println(db.getEvents().indexOf(event) + ": " + event.getGenre() + ", "
				+ event.getKunstner() + ", " + event.getLokale() + ", " + event.getDato() + ", " + event.getVisitor());
	}
	System.out.print("Hvilket arrangement skal slettes? ");
	int visit = input.nextInt();
	System.out.print("Hvilket arrangement skal slettes? ");
	//db.getEvents().set(input.nextInt(), visit); 
	//db.getEvents().get()(1, 1); 
	db.getEvents().set(visit, null);

}
public void searchEvent() {																	//Endnu ikke løst
	System.out.println("Indtast dit søgeord: ");
	String search = input.next();
	if (db.getEvents().contains(search)) {
		System.out.println("Udskriv her alle arrangementerne");
	}
	else
		System.out.println("Intet arrangement hedder dette\n____________");
}
	public void searchEventGenre() {														//Endnu ikke løst
		System.out.println("Vælg genre: ");
		System.out.println("Tast 1 for Musik (Rock, Pop, Jazz m.m)");
		System.out.println("Tast 2 for Comedy (Stand-up, Sketchshow m.m)");
		System.out.println("Tast 3 for Scenekunst (Teater, Musicals m.m)");
		System.out.println("Tast 4 for Børneunderholdning (Trylleri, Cirkusklovne m.m)");
		
		String valget = input.next();
		String valg = null;
		switch (valget) {
		case "1":
			valg = "Musik";
			break;
		case "2":
			valg = "Comedy";
			break;
		case "3":
			valg = "Scenekunst";
			break;
		case "4":
			valg = "Børneunderholdning";
			break;
		}
		if (db.getEvents().contains(valg)) {
			System.out.println("Udskriv alle arrangementer af denne type");
		}
		else
			System.out.println("Der findes ingen arrangementer af denne type\n_________");
}
	public void visitorEvent() {															//Endnu ikke løst
		System.out.println("Vælg genre: ");
		System.out.println("Tast 1 for Musik (Rock, Pop, Jazz m.m)");
		System.out.println("Tast 2 for Comedy (Stand-up, Sketchshow m.m)");
		System.out.println("Tast 3 for Scenekunst (Teater, Musicals m.m)");
		System.out.println("Tast 4 for Børneunderholdning (Trylleri, Cirkusklovne m.m)");
		
		String valget = input.next();
		String valg = null;
		switch (valget) {
		case "1":
			valg = "Musik";
			break;
		case "2":
			valg = "Comedy";
			break;
		case "3":
			valg = "Scenekunst";
			break;
		case "4":
			valg = "Børneunderholdning";
			break;
		}
		if (db.getEvents().contains(valg)) {
			for (Event event : db.getEvents()) {
				System.out.println(db.getEvents().indexOf(event) + event.getVisitor());
			}
		}
		else
			System.out.println("Der findes ingen arrangementer af denne type\n_________");

		
	}
	public void deleteEvent() {
		for (Event event : db.getEvents()) {
			System.out.println(db.getEvents().indexOf(event) + ": " + event.getGenre() + ", "
					+ event.getKunstner() + ", " + event.getLokale() + ", " + event.getDato() + ", " + event.getVisitor());
		}
		System.out.print("Hvilket arrangement skal slettes? ");
		db.getEvents().remove(input.nextInt());
	}
}