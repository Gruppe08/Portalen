import java.util.Scanner;

public class Program {

	Data db = new Data();
	Scanner input = new Scanner(System.in);
	EventKontrol ctrlEvent = new EventKontrol(input, db);
	AdminKontrol ctrlUser = new AdminKontrol(input, db);

	public void run() {
		db.generateUsers();

		if (db.login()) {
			
			if(db.getCurrentBruger() instanceof Bruger) {
				
				brugerMenu();
			} else {
				
				adminMenu();
			}

		}
	}

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
				ctrlEvent.deleteEvent();
				break;
			case 4:
				logOut();
				break;

			default:
				break;
			}

		} while (db.getCurrentBruger() != null);
		input.close();
		System.out.println("Du er nu logget ud");

	}
	
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
		input.close();
		System.out.println("Du er nu logget ud");

	}

	public void logOut() {
		db.setCurrentBruger(null);
	}

	public void printBrugerMenu() {
		System.out.println(
				"1) Vis arrangementer\n" + "2) Tilføj nyt arrangement\n" + "3) Slet arrangement\n" + "4) Log ud\n");

	}
	public void printAdminMenu() {
		System.out.println(
				"1) Vis alle brugere \n" + "2) Tilføj ny bruger\n" + "3) Slet bruger\n" + "4) Log ud\n");

	}
}
