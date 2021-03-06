// Prorgrammering
// Semesterprojekt 2015
// Ansvaret for denne klasse har tilhørt
// Bianca
// Gruppe 08
public class Event {

 //Her definerer vi, genre, kunstner, lokale, dato og derudover hvor mange besøgende arrangementet har.

	private String genre;
	private String kunstner;
	private String lokale;
	private String dato;
	private int visitor;


	public Event(String genre, String kunstner, String lokale, String dato, int visitor) {
		this.genre = genre;
		this.kunstner = kunstner;
		this.lokale = lokale;
		this.dato = dato;
		this.visitor = visitor;

	}

	//Her oprettes getter og setter for attributter
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
	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

}
