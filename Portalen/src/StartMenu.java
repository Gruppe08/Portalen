// Prorgrammering
// Semesterprojekt 2015
// Ansvaret for denne klasse har tilhørt
// Simon
// Gruppe 08
import java.util.Scanner;

public class StartMenu {

	Data db = new Data(); 
	Scanner input = new Scanner(System.in);
	EventControl ctrlEvent = new EventControl(input, db);
	private Scanner scanner;


// Her opretter vi startmenuen 
	public void run() {
		db.generateUsers();
		boolean continueLoop = true;
		
		do	{
			
		String valg;
		System.out.println("1) Vis alle arrangementer \n2) Login ");
		scanner = new Scanner(System.in);
		valg = scanner.next();
		
		if (valg.equals("1")){
			listOfEvents();

		}
		
		
		else if (valg.equals("2")){
			LoginMenu program = new LoginMenu(db);
			program.login();
			
		}
		else{
			System.out.println("\nDu skal taste enten 1 eller 2");
		}
		}while(continueLoop);

	}
	
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
					System.out.println("___________________________");
				}
			}
		}
}



	
