package home;

import java.util.ArrayList;

public abstract class Korisnik implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886297L;
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	protected static Korisnik prijavljen = null;
	protected String ime;
	protected String prezime;
	protected String korisnickoIme;
	protected String lozinka;
	protected String tip;
//endregion
//region Getteri/Settteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}
	public static void setKorisnici(ArrayList<Korisnik> korisnici) {
		Korisnik.korisnici = korisnici;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}

	public static Korisnik getPrijavljen() {
		return Korisnik.prijavljen;
	}

	public static void setPrijavljen(Korisnik prijavljen) {
		Korisnik.prijavljen = prijavljen;
	}

	public void odjava(){
		setPrijavljen(null);
	}

	//endregion
}
