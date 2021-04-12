package home;

import enumeracije.TipKlaseAvionskogMesta;

import java.text.ParseException;

public abstract class PrevoznoSredstvo implements Zakupljivo, java.io.Serializable{
//region Polja
	protected boolean obrok;
	protected Adresa polaznaAdresa;
	protected Adresa odredisnaAdresa;
//endregion
//region Konstruktori
	public PrevoznoSredstvo(boolean obrok, Adresa polaznaAdresa, Adresa odredisnaAdresa) {
	super();
	this.obrok = obrok;
	this.polaznaAdresa = polaznaAdresa;
	this.odredisnaAdresa = odredisnaAdresa;
}
//endregion
//region Getteri/Settteri
	public boolean isObrok() {
		return obrok;
	}
	public void setObrok(boolean obrok) {
		this.obrok = obrok;
	}
	public Adresa getPolaznaAdresa() {
		return polaznaAdresa;
	}
	public void setPolaznaAdresa(Adresa polaznaAdresa) {
		this.polaznaAdresa = polaznaAdresa;
	}
	public Adresa getOdredisnaAdresa() {
		return odredisnaAdresa;
	}
	public void setOdredisnaAdresa(Adresa odredisnaAdresa) {
		this.odredisnaAdresa = odredisnaAdresa;
	}
	//endregion

	public int zakupi() {
		int izracunato=0;
		int iObrok;
		if(obrok) iObrok=1;
		else iObrok=0;
		izracunato=540*iObrok+640;
		return izracunato;
	}
}
