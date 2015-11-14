import java.util.Scanner;

public class Program {

	Data db = new Data();
	Scanner input = new Scanner(System.in);
	EventKontrol ctrlEvent = new EventKontrol(input, db);
	AdminKontrol ctrlUser = new AdminKontrol(input, db);
	
	
	//Her kører vi vores login, hvor hvis man er bruger vil man få vist brugermenuen og ellers får man vist adminmenuen

	public void login() {
		db.generateUsers();

		if (db.login()) {
			
			if(db.getCurrentBruger() instanceof Bruger) {
				
				brugerMenu();
			} else {
				
				adminMenu();
			}

		}
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
				logOut();
				break;

			default:
				break;
			}

		} while (db.getCurrentBruger() != null);
		StartMenu program = new StartMenu();
		program.run();
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
				logOut();
				break;

			default:
				break;
			}

	} while (db.getCurrentBruger() != null);
		StartMenu program = new StartMenu();
		program.run();
	System.out.println("Du er nu logget ud\n");

	}

	public void logOut() {
		db.setCurrentBruger(null);
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
