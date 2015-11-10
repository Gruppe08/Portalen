
	import java.util.ArrayList;

	public class Data {
		ArrayList<EventBruger> bruger;

		public void generate() {

			ArrayList<Event> events = new ArrayList<Event>();
			events.add(new Event("Pop Musik " , "Justin Bieber ", "Portalens Teatersal " , "2/2/2016"));

			bruger = new ArrayList<EventBruger>();
			bruger.add(new EventBruger("William Karberg", "123abc", events));
			bruger.add(new EventBruger("Simon Ottosen", "123abc", events));
			bruger.add(new EventBruger("Bianca Juul-Hansen", "123abc", events));
			bruger.add(new EventBruger("Peter Wynn Vuiff12", "123abc", events));
	}

	public ArrayList<EventBruger> getBrugere() {
			return bruger;
		}

		public void setBrugere(ArrayList<EventBruger> brugere) {
			this.bruger = brugere;
	}

}
