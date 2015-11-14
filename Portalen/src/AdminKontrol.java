import java.util.ArrayList;
import java.util.Scanner;
public class AdminKontrol {
	
	private Scanner input;
	private Data db; 
	

	public AdminKontrol(Scanner input, Data db) {
		this.input = input;
		this.db = db;
	}
	public void listOfBrugere() {
		if (db.getBruger().size() == 0) {
			System.out.println("Der er ingen brugere");
		} else {
			System.out.println("Her er alle eksisterende brugere: ");
			for (Admin bruger : db.getBruger()) {				//Admin skal muligvis ændres til brugere +Linje38
				System.out.println("Brugernavn: " + bruger.getUsername() + " Password: " + bruger.getPassword());

			}
			
		}
		}
	public void addBruger() {
		System.out.println("Brugernavn: ");
		String username = input.next();
		System.out.println("Password: ");
		int password = input.nextInt();
		Bruger bruger = new Bruger(username, password, null);
		db.getBruger().add(bruger);

		
	}
	public void deleteBruger() {
		for (Admin bruger : db.getBruger()) {
			System.out.println(db.getBruger().indexOf(bruger) + ": " + bruger.getUsername() + ", "
					+ bruger.getPassword());
		}
		System.out.print("Hvilken bruger skal slettes? ");
		db.getBruger().remove(input.nextInt());

}}