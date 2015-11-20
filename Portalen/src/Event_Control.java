import java.util.Scanner;
public class Event_Control {
	
	private Scanner input;
	private Data db; 
	
	public Event_Control(Scanner input, Data db) {
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
		//Vi sætter visitor til 0, da eventet jo bliver oprettet med 0 besøgende som start
		int visitor = 0;
		System.out.println("Skriv dato, i følgende format: DD/MM/YYYY: ");
		String dato = input.next();
		// Vi bruger en boolean for at se om vores if statement er sandt, da vi ikke kan oprettet et event i et for-loop
		boolean check = false;
		for (Event event : db.getEvents())
		{
		if (event.getDato().equals(dato) && event.getLokale().equals(nylokale)){
			System.out.println("\nHer er allerede booket. Du bliver sendt tilbage til menuen\n-------------\n");
			check = true; 
		}
		}
		//Da vi har sagt at boolean er true i vores if-statement ovenover, siger vi her at den ikke må være true, hvis eventet skal oprettes
		if (check != true){
			Event add = new Event(nygenre, kunstner, nylokale, dato, visitor);
			db.getEvents().add(add);
			System.out.println("\nEventet er nu blevet oprettet\n-------------\n");
		}
		//Her sætter vi så et helt nyt event hvor vi opdaterer alle de krav vi har sat i Event.java
	//	Event event = new Event(nygenre, kunstner, nylokale, dato, visitor);
		//db.getEvents().add(event);
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
			int visitor = 0;
			System.out.println("Skriv dato, i følgende format: DD/MM/YYYY: ");
			String dato = input.next();
			//Vi sætter visitor til 0, da eventet jo bliver oprettet med 0 besøgende som start
			boolean check = false;
			for (Event event : db.getEvents())
			{
			if (event.getDato().equals(dato) && event.getLokale().equals(nylokale)){
				System.out.println("\nHer er allerede booket. Du bliver sendt tilbage til menuen\n-------------\n");
				check = true;
			}
			}
			
			if (check != true){
				Event add = new Event(nygenre, kunstner, nylokale, dato, visitor);
				db.getEvents().add(add);
				System.out.println("\nEventet er nu blevet oprettet\n-------------\n");
			}} 


public void updateEventVisitor() {		
	for (Event event : db.getEvents()) {
		System.out.println(db.getEvents().indexOf(event) + ": " + event.getGenre() + ", "
				+ event.getKunstner() + ", " + event.getLokale() + ", " + event.getDato() + ", " + event.getVisitor());
	}
		System.out.println("\nHvilket event vil du opdatere besøgstal på?");
		int valg = input.nextInt();
		System.out.println("\nHvad skal det nye besøgstal være?\n");
        Scanner nyScan = new Scanner (System.in);
        String input = nyScan.nextLine ();
        int visit = 0;
        while (true) {
            if (visit >= 0) {
                try {
                    visit = Integer.parseInt (input);
                    break;
                }
                catch (NumberFormatException e) {
                }
            }

            System.out.println ("Fejl! Du skal indtaste et tal: ");
            input = nyScan.nextLine ();

        }

		db.getEvents().get(valg).setVisitor(visit);
		System.out.println("\nBesøgstallet er nu opdateret til " + visit + "\n-------------\n");
    }




public void searchEventRoom() {																	
	System.out.println("Vælg lokale: ");
	System.out.println("Tast 1 for Portalens Teatersal - Det er muligt at leje Portalens lokaler med plads til mellem 10 og 752 personer.");
	System.out.println("Tast 2 for Kabaret-scenen - 120 personer ved café-borde / 150 personer på stolerækker");
	System.out.println("Tast 3 for Mødelokale 1 - 80 personer ved café-borde / 120 personer på stolerækker");
	System.out.println("Tast 4 for Foyersalen (Portalens Biograf) - 80 personer på stolerækker");
	
	String valget = input.next();
	String valg = null;
	switch (valget) {
	case "1":
		valg = "Portalens Teatersal";
		break;
	case "2":
		valg = "Kabaret-scenen";
		break;
	case "3":
		valg = "Mødelokale 1";
		break;
	case "4":
		valg = "Foyersalen (Portalens Biograf)";
		break;
	}
for (Event event : db.getEvents())
{
if (event.getLokale().equals(valg)){
	System.out.println("Genre: " + event.getGenre());
	System.out.println("Kunstner: " + event.getKunstner());
	System.out.println("Lokale: " + event.getLokale());
	System.out.println("Dato: " + event.getDato());
	System.out.println("Besøgende: " + event.getVisitor());
	System.out.println("___________________________");
	}}

}
	public void searchEventGenre() {														
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
	for (Event event : db.getEvents())
	{
	if (event.getGenre().equals(valg)){
		System.out.println("Genre: " + event.getGenre());
		System.out.println("Kunstner: " + event.getKunstner());
		System.out.println("Lokale: " + event.getLokale());
		System.out.println("Dato: " + event.getDato());
		System.out.println("Besøgende: " + event.getVisitor());
		System.out.println("___________________________");
		}}}

	public void visitorEvent() {															//Endnu ikke løst
		System.out.println("Vælg genre: ");
		System.out.println("Tast 1 for Musik (Rock, Pop, Jazz m.m)");
		System.out.println("Tast 2 for Comedy (Stand-up, Sketchshow m.m)");
		System.out.println("Tast 3 for Scenekunst (Teater, Musicals m.m)");
		System.out.println("Tast 4 for Børneunderholdning (Trylleri, Cirkusklovne m.m)");
		
		String valget = input.next();
		String valg = "Ingen kategori";
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
		int total = 0;
	for (Event event : db.getEvents())
	{
	if (event.getGenre().equals(valg)){
		total += event.getVisitor();
		}
	}
	System.out.println("\nI kategorien " + valg + " er der i alt " + total + " besøgende\n------------");
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