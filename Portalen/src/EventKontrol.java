import java.util.Scanner;

public class EventKontrol {

	EventBruger currentBruger;
	private Scanner input;

	public EventKontrol(Scanner input) {
		this.input = input;
	}

	public void listOfEvents() {
		if (currentBruger.getEvents().size() == 0) {
			System.out.println("Der er ingen arrangementer");
		} else {
			System.out.println("Her er eksisterende arrangementer: ");
			
			for (Event event : currentBruger.getEvents()) {
				System.out.println("Genre: " + event.getGenre());
									
				System.out.println("Kunstner: " + event.getKunstner());
									
				System.out.println("Lokale: " + event.getLokale());  
								
				System.out.println(	"Dato: " + event.getDato());

				System.out.println("___________________________");
			}
		}
	}

	public void addEvent() {
		System.out.println("Skriv genre: ");
		String genre = input.next();

		System.out.println("Skriv kunstner: ");
		String kunstner = input.next();

		System.out.println("Skriv lokale: ");
		String lokale = input.next();

		System.out.println("Skriv dato: ");
		String dato = input.next();

		Event event = new Event(genre, kunstner, lokale, dato);
		currentBruger.getEvents().add(event);

	}

	public void deleteEvent() {
		for (Event event : currentBruger.getEvents()) {
			System.out.println(currentBruger.getEvents().indexOf(event) + ": " + event.getGenre() + ", "
					+ event.getKunstner() + ", " + event.getLokale() + ", " + event.getDato());

		}
		System.out.print("Hvilket arrangement skal slettes? ");
		currentBruger.getEvents().remove(input.nextInt());

	}
}
