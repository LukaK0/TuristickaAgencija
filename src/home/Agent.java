package home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import enumeracije.TipKlaseAvionskogMesta;
import enumeracije.TipKlaseVoznogMesta;
import enumeracije.TipPansiona;

public class Agent extends Korisnik {
	//region Polja
	protected static final long serialVersionUID = -1980325513659886298L;
	public static ArrayList<Agent> sve = TuristickaAgencija.getAgenti();
	public static String path = "podaci/agenti.xml";
	//endregion
	//region Konstruktori
	public Agent(String ime, String prezime, String korisnickoIme, String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tip = "Agent";
		upisi();
	}
	//endregion
	//region Getteri/Setteri
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
	public static ArrayList<Agent> getSve() {
		return sve;
	}
	public static String getPath() {
		return path;
	}
	public static void setPath(String path) {
		Paket.path = path;
	}
	public static void setSve(ArrayList<Agent> sve) {
		Agent.sve = sve;
	}

	//endregion
	//region Metode
	public void upisi(){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path));
			sve.add(this);
			oos.writeObject(sve);
			oos.close();
		}
		catch (IOException e) {
			System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
		}
	}
	public static void ucitaj() {
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path));
			try {
				sve =(ArrayList<Agent>) ois.readObject();
				ois.close();
			} catch (ClassNotFoundException e) {
				System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
			}
		}
		catch (IOException e) {
			System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
		}
	}

	public void dodaj(String uKor, String loz, String ime, String prezime){
		new Agent(ime, prezime, uKor, loz);
	}

	public void kreirajDrzava(String ime) {
		Drzava.dodaj(ime);
	}
	public void kreirajMesto(String ime, Drzava drzava){
		Mesto.dodaj(ime, drzava);
	}
	public void kreirajAdresa(Mesto mesto, String ulica, String broj){
		Adresa.dodaj(mesto, ulica, broj);
	}
	public void kreirajSmestaj(int povrsina, int brojKreveta, TipPansiona tipPansiona, Adresa adresa){
		Apartman.dodaj(povrsina, brojKreveta, tipPansiona, adresa);
	}
	public void kreirajSmestaj(int povrsina, int brojKreveta, TipPansiona tipPansiona, Adresa adresa, int brojZvezdica){
		Hotel.dodaj(povrsina, brojKreveta, tipPansiona, adresa, brojZvezdica);
	}
	public void kreirajPrevoz(boolean obrok, Adresa od, Adresa dokle, Object klasa){
		if(klasa.getClass().getSimpleName().equalsIgnoreCase("tipklaseavionskogmesta")) Avion.dodaj(obrok, od, dokle, (TipKlaseAvionskogMesta)klasa);
		else Voz.dodaj(obrok, od, dokle, (TipKlaseVoznogMesta) klasa);
	}
	public void kreirajAranzman(boolean osiguranje, boolean grupni, String datumOd, String datumDo, PrevoznoSredstvo prevoz, Smestaj smestaj){
		Aranzman.dodaj(osiguranje, grupni, datumOd, datumDo, prevoz, smestaj);
	}
	public void kreirajPaket(Aranzman aranzman, double uPovrat) {
		Paket noviPaket = new Paket(uPovrat, this);
		noviPaket.getAranzmaniUPaketu().add(aranzman);
		IO.sacuvajIzmene(Paket.getPath(), Paket.getSve());
	}

	//endregion











}
