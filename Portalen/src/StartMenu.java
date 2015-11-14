import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {

	Data db = new Data();
	Scanner input = new Scanner(System.in);
	EventKontrol ctrlEvent = new EventKontrol(input, db);



	public void run() {
		int valg;
		Scanner input = new Scanner(System.in);
		System.out.println("1) Vis alle arrangementer \n2) Login som bruger eller admin");
		valg = input.nextInt();
		
		if (valg == 1){
			Program program = new Program();
			program.kunde();
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



	
