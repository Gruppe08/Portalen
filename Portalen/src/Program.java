import java.util.Scanner;

public class Program {

	Data db;
	Admin currentUser;
	Scanner input = new Scanner(System.in);
	EventKontrol ctrlEvent;
	AdminKontrol ctrlUser;
	
	public Program(Data db){
		this.db = db;
		Scanner input = new Scanner(System.in);
		ctrlEvent = new EventKontrol(input, db);
		ctrlUser = new AdminKontrol(input, db);
	}
	
	
	//Her kører vi vores login, hvor hvis man er bruger vil man få vist brugermenuen og ellers får man vist adminmenuen

	public void login() {

		if (authenticate()) {
			
			if(currentUser instanceof Bruger) {
				
				brugerMenu();
			} else {
				
				adminMenu();
			}

		}
	}
	
	//Her ses login systemet
		public boolean authenticate() {

			String username;
			int password;

			input = new Scanner(System.in);
	//Her skal man indtaste brugernavn og password
			System.out.println("Indtast brugernavn for at logge ind: ");
			username = input.nextLine();
			System.out.println("Skriv dit password: ");
			password = input.nextInt();

			for (Admin bruger : db.getBruger()) {
	//Her ses om brugernavn og password matcher, hvis ja så logger man ind 	
				if (bruger.getUsername().equals(username) && bruger.getPassword() == password) {
					currentUser = bruger;
					return true;
				}
			}
	//Hvis nej så bliver dette udskrevet
			System.out.println("Forkert brugernavn eller kode, prøv igen\n");
			StartMenu program = new StartMenu();
			program.run();
			return false;

		}

	//Her ses vores brugermenu, hvor det er muligt at vælge en af følgende cases, for at blive sendt videre
	public void brugerMenu() {
		do {
			printBrugerMenu();
			int choice = input.nextInt();
			switch (choice) {

			case 1:
				ctrlEvent.listOfEvents();
				break;
			case 2:
				ctrlEvent.addEvent();
				break;
			case 3:
				ctrlEvent.changeEvent();
				break;
			case 4:
				ctrlEvent.deleteEvent();
				break;
			case 5:
				ctrlEvent.updateEventVisitor();
				break;
			case 6:
				ctrlEvent.searchEvent();
				break;
			case 7:
				ctrlEvent.searchEventGenre();
				break;
			case 8:
				ctrlEvent.visitorEvent();
				break;
			case 9:
				currentUser = null;
				break;

			default:
				break;
			}

		} while (currentUser != null);
		System.out.println("Du er nu logget ud");

	}
	
	
	//Her ses vores adminmenu, hvor det er muligt at vælge en af følgende cases, for at blive sendt videre
	public void adminMenu() {
		do {
			printAdminMenu();
			int choice = input.nextInt();
			switch (choice) {

			case 1:
				ctrlUser.listOfBrugere();
				break;
			case 2:
				ctrlUser.addBruger();
				break;
			case 3:
				ctrlUser.deleteBruger();
				break;
			case 4:
				currentUser = null;
				break;

			default:
				break;
			}

	} while (currentUser != null);
	System.out.println("Du er nu logget ud\n");

	}


	//Her printes brugermenuen
	public void printBrugerMenu() {
		System.out.println(
				"1) Vis arrangementer\n" + "2) Tilføj nyt arrangement\n" + "3) Ændre eksisterende arrangement\n" + "4) Slet arrangement\n" + "5) Opdater besøgstal\n" 
				+ "6) Søg efter event\n" + "7) Se arrangementer i samme genre\n"+ "8) Besøgstal efter genre\n" + "9) Log ud\n");

	}
	
	//Her printes adminmenuen
	public void printAdminMenu() {
		System.out.println(
				"1) Vis alle brugere \n" + "2) Tilføj ny bruger\n" + "3) Slet bruger\n" + "4) Log ud\n");

	}
}
