import java.util.Scanner;

public class Program {

	Data db = new Data();
	Scanner input = new Scanner(System.in);
	EventKontrol ctrl = new EventKontrol(input);

	public void run() {
		db.generate();

		if (authUser()) {
			do {
				printMenu();
				int choice = input.nextInt();
				switch (choice) {

				case 1:
					ctrl.listOfEvents();
					break;
				case 2:
					ctrl.addEvent();
					break;
				case 3:
					ctrl.deleteEvent();
					break;
				case 4:
					logOut();
					break;

				default:
					break;
				}

			} while (ctrl.currentBruger != null);
			input.close();
			System.out.println("Du er nu logget ud");

		}
	}

	public boolean authUser() {
		for (EventBruger bruger : db.getBrugere()) {
			ctrl.currentBruger = bruger;
			return true;
		}
		return false;
	}

	public void logOut() {
		ctrl.currentBruger = null;
	}

	public void printMenu() {
		System.out.println( "1) Se arrangementer\n" + "2) Tilføj nyt arrangement\n" + "3) Slet arrangement\n" + "4) Log out\n");

	}
}
