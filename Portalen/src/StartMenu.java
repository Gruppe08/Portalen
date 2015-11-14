import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {

	Data db = new Data();
	Scanner input = new Scanner(System.in);
	EventKontrol ctrlEvent = new EventKontrol(input, db);



	public void run() {
		int valg;
		Scanner input = new Scanner(System.in);
		System.out.println("1) Vis alle arrangementer \n2) Login ");
		valg = input.nextInt();
		
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



	
