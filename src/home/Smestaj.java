package home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import enumeracije.TipPansiona;

public abstract class Smestaj implements Zakupljivo, java.io.Serializable{
//region Polja
	protected int povrsina;
	protected int brojKreveta;
	protected TipPansiona tipPansiona;
	protected Adresa adresa;
//endregion
//region Konstruktori
	public Smestaj(int povrsina, int brojKreveta, TipPansiona tipPansiona, Adresa adresa) {
		super();
		this.povrsina = povrsina;
		this.brojKreveta = brojKreveta;
		this.tipPansiona = tipPansiona;
		this.adresa = adresa;
	}
//endregion
//region Getteri/Settteri
	public int getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(int povrsina) {
		this.povrsina = povrsina;
	}
	public int getBrojKreveta() {
		return brojKreveta;
	}
	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}
	public TipPansiona getTipPansiona() {
		return tipPansiona;
	}
	public void setTipPansiona(TipPansiona tipPansiona) {
		this.tipPansiona = tipPansiona;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	//endregion
//region Metode
	public int zakupi() {
	int vrednost;
	if(this.tipPansiona.compareTo(TipPansiona.NOCENJE)==0) {vrednost=1200;}
	else if(this.tipPansiona.compareTo(TipPansiona.NOCENJESADORUCKOM)==0) {vrednost=1700;}
	else if(this.tipPansiona.compareTo(TipPansiona.POLUPANSION)==0) {vrednost=2100;}
	else {vrednost=3600;}
	if(this.getClass().getSimpleName().equals("Hotel")) vrednost+=123*((Hotel)this).getBrojZvezdica();

	return vrednost;
}

//endregion

}