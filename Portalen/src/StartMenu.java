import java.util.Scanner;

public class StartMenu {

	Data db = new Data(); //hej
	Scanner input = new Scanner(System.in);
	EventKontrol ctrlEvent = new EventKontrol(input, db);
	private Scanner scanner;



	public void run() {
		int valg;
		System.out.println("1) Vis alle arrangementer \n2) Login ");
		scanner = new Scanner(System.in);
		valg = scanner.nextInt();
		
		if (valg == 1){
			System.out.println("Nope");

		}

		
		
		if (valg == 2) {
			Program program = new Program();
			program.login();
			
		}
		else{
			System.out.println("Idiot");
		}

	}
}



	
