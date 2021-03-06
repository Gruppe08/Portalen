// Prorgrammering
// Semesterprojekt 2015
// Ansvaret for denne klasse har tilhørt
// William
// Gruppe 08
import java.util.Scanner;

public class LoginMenu {

	Data db;
	Admin currentUser;
	Scanner input = new Scanner(System.in);
	EventControl ctrlEvent;
	UserControl ctrlUser;
	
	public LoginMenu(Data db){
		this.db = db;
		Scanner input = new Scanner(System.in);
		ctrlEvent = new EventControl(input, db);
		ctrlUser = new UserControl(input, db);
	}
	
	
	//Her kører vi vores login, hvor hvis man er user vil man få vist usermenuen og ellers får man vist adminmenuen

	public void login() {

		if (authenticate()) {
			
			if(currentUser instanceof User) {
				
				userMenu();
			} else {
				
				adminMenu(currentUser);
			}

		}
	}
	
	//Her ses login systemet
		public boolean authenticate() {

			String username;
			String password;

			input = new Scanner(System.in);
	//Her skal man indtaste usernavn og password
			System.out.println("Indtast brugernavn for at logge ind: ");
			username = input.nextLine();
			System.out.println("Skriv din kode: ");
			password = input.nextLine();

			for (Admin user : db.getuser()) {
	//Her ses om usernavn og password matcher, hvis ja så logger man ind 	
				if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
					currentUser = user;
					return true;
				}
			}
	//Hvis nej så bliver dette udskrevet
			System.out.println("Forkert brugernavn eller kode, prøv igen\n");
			StartMenu program = new StartMenu();
			program.run();
			return false;

		}

	//Her ses vores usermenu, hvor det er muligt at vælge en af følgende cases, for at blive sendt videre
	public void userMenu() {
		System.out.println("\n\n\nDu er nu logget ind som bruger\n------------------------------\n");
		do {
	        Scanner nyScan = new Scanner (System.in);
			printuserMenu();
			int choice = 0;
	        String input = nyScan.nextLine ();
	        while (true) {
	            if (choice <= 0) {
	                try {
	                    choice = Integer.parseInt (input);
	                    break;
	                }
	                catch (NumberFormatException e) {
	                }
	            }

	            System.out.println ("Fejl! Du skal indtaste et tal fra 1-9: \n");
				printuserMenu();
	            input = nyScan.nextLine ();

	        }

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
				ctrlEvent.searchEventRoom();
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
	public void adminMenu(Admin currentUser) {
		System.out.println("\n\n\nDu er nu logget ind som admin\n----------------------------\n");
		do {
	        Scanner nyScan = new Scanner (System.in);
			printAdminMenu();
			int choice = 0;
	        String input = nyScan.nextLine ();
	        while (true) {
	            if (choice <= 0) {
	                try {
	                    choice = Integer.parseInt (input);
	                    break;
	                }
	                catch (NumberFormatException e) {
	                }
	            }

	            System.out.println ("Fejl! Du skal indtaste et tal fra 1-4: \n");
				printAdminMenu();
	            input = nyScan.nextLine ();

	        }			switch (choice) {

			case 1:
				ctrlUser.listOfusere();
				break;
			case 2:
				ctrlUser.adduser();
				break;
			case 3:
				ctrlUser.deleteuser(currentUser);
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


	//Her printes usermenuen
	public void printuserMenu() {
		System.out.println(
				"1) Vis arrangementer\n" +
				"2) Tilføj nyt arrangement\n" +
				"3) Ændre eksisterende arrangement\n" +
				"4) Slet arrangement\n" +
				"5) Opdater besøgstal\n" +
				"6) Se arrangementer i samme lokale\n" +
				"7) Se arrangementer i samme genre\n"+
				"8) Se samlet besøgstal for genre\n" +
				"9) Log ud\n");

	}
	
	//Her printes adminmenuen
	public void printAdminMenu() {
		System.out.println(
				"1) Vis alle users og admin \n" +
				"2) Tilføj ny user\n" +
				"3) Slet user\n" +
				"4) Log ud\n");

	}
}
