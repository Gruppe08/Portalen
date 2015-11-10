
public class Event {
	
	private String genre;
	private String kunstner;
	private String lokale;
	private String dato;

	
	
	public Event(String genre, String kunstner, String lokale, String dato){
		this.genre = genre;
		this.kunstner = kunstner;
		this.lokale = lokale;
		this.dato = dato;
	}
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getKunstner() {
		return kunstner;
	}

	public void setKunstner(String kunstner) {
		this.kunstner = kunstner;
	}

		public String getLokale() {
			return lokale;
		}

		public void setLokale(String lokale) {
			this.lokale = lokale;
		}

	
	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}
}
	

