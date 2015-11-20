import java.util.Scanner;
public class User_Control {
	
	private Scanner input;
	private Data db; 
	

	public User_Control(Scanner input, Data db) {
		this.input = input;
		this.db = db;
	}
//Her udskives liste af eksisterende usere (der bliver brugt en if/else metode)	
	public void listOfusere() {	
//Hvis der er ingen eksisterende usere udskrives dette:
		if (db.getuser().size() == 0) {
			System.out.println("Der er ingen brugere");
//Her hentes der information om eksisterende usere, som derefter udskrives
		} else {
			System.out.println("Her er alle eksisterende brugere og admins: ");
			for (Admin user : db.getuser()) {
				System.out.println("Username: " + user.getUsername() + " \nPassword: " + user.getPassword() + "\n-------");

			}
			
		}
		}
//Her bliver muligt at tilføje ny user, med nyt password og nyt usernavn
	public void adduser() {
		System.out.println("Username: ");
		String username = input.nextLine();
		System.out.println("Password: ");
		String password = input.nextLine();
//Her henter den information fra user klassen og laver event=null
		User user = new User(username, password, null);
		db.getuser().add(user);
		System.out.println("\nBrugeren " + username + " er blevet oprettet\n-------------");
		
	}
//Her slettes der en valgfri af de oprettet user
	public void deleteuser() {
//Her bliver der hentet information om alle eksisterende usere
		for (Admin user : db.getuser()) {
			System.out.println(db.getuser().indexOf(user) + ": " + user.getUsername() + ", "
					+ user.getPassword());
		}
//Her vælger adminen hvilken user der skal slettes
		System.out.print("Hvilken bruger skal slettes? ");
		db.getuser().remove(input.nextInt());
		System.out.print("Brugeren er blevet slettet \n");
}}