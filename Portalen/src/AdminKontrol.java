import java.util.Scanner;
public class AdminKontrol {
	
	private Scanner input;
	private Data db; 
	

	public AdminKontrol(Scanner input, Data db) {
		this.input = input;
		this.db = db;
	}
//Her udskives liste af eksisterende brugere (der bliver brugt en if/else metode)	
	public void listOfBrugere() {	
//Hvis der er ingen eksisterende brugere udskrives dette:
		if (db.getBruger().size() == 0) {
			System.out.println("Der er ingen brugere");
//Her hentes der information om eksisterende brugere, som derefter udskrives
		} else {
			System.out.println("Her er alle eksisterende brugere: ");
			for (Admin bruger : db.getBruger()) {
				System.out.println("Brugernavn: " + bruger.getUsername() + " Password: " + bruger.getPassword());

			}
			
		}
		}
//Her bliver muligt at tilføje ny bruger, med nyt password og nyt brugernavn
	public void addBruger() {
		System.out.println("Brugernavn: ");
		String username = input.next();
		System.out.println("Password: ");
		int password = input.nextInt();
//Her henter den information fra Bruger klassen og laver event=null
		Bruger bruger = new Bruger(username, password, null);
		db.getBruger().add(bruger);

		
	}
//Her slettes der en valgfri af de oprettet bruger
	public void deleteBruger() {
//Her bliver der hentet information om alle eksisterende brugere
		for (Admin bruger : db.getBruger()) {
			System.out.println(db.getBruger().indexOf(bruger) + ": " + bruger.getUsername() + ", "
					+ bruger.getPassword());
		}
//Her vælger adminen hvilken bruger der skal slettes
		System.out.print("Hvilken bruger skal slettes? ");
		db.getBruger().remove(input.nextInt());

}}