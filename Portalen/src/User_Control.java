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
			System.out.println("Der er ingen usere");
//Her hentes der information om eksisterende usere, som derefter udskrives
		} else {
			System.out.println("Her er alle eksisterende usere og admins: ");
			for (Admin user : db.getuser()) {
				System.out.println("usernavn: " + user.getUsername() + " Password: " + user.getPassword());

			}
			
		}
		}
//Her bliver muligt at tilføje ny user, med nyt password og nyt usernavn
	public void adduser() {
		System.out.println("usernavn: ");
		String username = input.next();
		System.out.println("Password: ");
		String password = input.next();
//Her henter den information fra user klassen og laver event=null
		User user = new User(username, password, null);
		db.getuser().add(user);

		
	}
//Her slettes der en valgfri af de oprettet user
	public void deleteuser() {
//Her bliver der hentet information om alle eksisterende usere
		for (Admin user : db.getuser()) {
			System.out.println(db.getuser().indexOf(user) + ": " + user.getUsername() + ", "
					+ user.getPassword());
		}
//Her vælger adminen hvilken user der skal slettes
		System.out.print("Hvilken user skal slettes? ");
		db.getuser().remove(input.nextInt());

}}