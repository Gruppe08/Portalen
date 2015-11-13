import java.util.ArrayList;

public class Admin extends EventBruger {
	
	private String addBruger;

	public Admin(String name, String password, ArrayList<Event> events){
	super(name,password,events);
	
	this.addBruger = addBruger;
}
	public void print(){
		System.out.println(addBruger);
	}
}
