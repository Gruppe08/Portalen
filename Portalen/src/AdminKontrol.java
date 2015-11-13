import java.util.Scanner;

public class AdminKontrol {

																	//Change
	private Scanner input;
	private Data db;
	
	public AdminKontrol(Scanner input, Data db) {													//Change
		this.input = input;
		this.db = db;
	}

	public void listOfBrugere() {
		if (currentAdmin.getBruger().size() == 0) {										//Change
			System.out.println("Der er ingen brugere");
		} else {
			System.out.println("Her er alle eksisterende brugere: ");

			for (Bruger bruger : currentAdmin.getBruger()) {
				System.out.println("Brugernavn: " + bruger.getBruger + "Password: " + bruger.getPassword());
				System.out.println("___________________________");
			}
		}
	}

	public void addBruger() {
		System.out.println("Skriv brugernavn: ");
		String brugernavn = input.next();

		System.out.println("Skriv password: ");
		String password = input.next();
		
		Bruger bruger = new Bruger(brugernavn, password);
		currentAdmin.getBruger().add(bruger);

	}

	public void deleteBruger() {
		for (Bruger bruger : currentAdmin.getBruger()) {
			System.out.println(currentAdmin.getBruger().indexOf(bruger) + "brugernavn: " + bruger.getBruger + "Password: " + bruger.getPassword);

		}
		System.out.print("Hvilken bruger skal slettes? ");
		currentAdmin.getBruger().remove(input.nextInt());

	}
}
