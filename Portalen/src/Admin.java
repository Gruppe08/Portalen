import java.util.ArrayList;

public class Admin extends EventBruger {
	
	private String addUser;

	public Admin(String name, String password, ArrayList<Event> events){
	super(name,password,events);
	
	this.addUser = addUser;
}
	
}
