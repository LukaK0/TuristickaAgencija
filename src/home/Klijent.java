package home;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Klijent extends Korisnik {
//region Polja
	protected static final long serialVersionUID = -1980325513659886299L;
	public static ArrayList<Klijent> sve = TuristickaAgencija.getKlijenti();
	public static String path = "podaci/klijenti.xml";
	private int novcanoStanje=0;
	//endregion
//region Konstruktori
	public Klijent(String ime, String prezime, String korisnickoIme, String lozinka, int novcanoStanje) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tip = "Klijent";
		this.novcanoStanje = novcanoStanje;
		upisi();

	}
//endregion
//region Getteri/Settteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public int getNovcanoStanje() {
		return novcanoStanje;
	}
	public void setNovcanoStanje(int novcanoStanje) {
		this.novcanoStanje = novcanoStanje;
	}
	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Paket.path = path;
	}

	public static ArrayList<Klijent> getSve() {
		return sve;
	}

	public static void setSve(ArrayList<Klijent> sve) {
		Klijent.sve = sve;
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
				sve =(ArrayList) ois.readObject();
				ois.close();
			} catch (ClassNotFoundException e) {
				System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
			}
		}
		catch (IOException e) {
			System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
		}
	}

	public void kreirajPaket(Aranzman aranzman) {
		double uPovrat = 40;
		Paket noviPaket = new Paket(uPovrat, this);
		noviPaket.getAranzmaniUPaketu().add(aranzman);
		zakupiPaket(noviPaket);
		IO.sacuvajIzmene(Paket.getPath(), Paket.getSve());
	}

	public boolean zakupiPaket(Paket izabranPaket){
		try {
			if(this.getNovcanoStanje()>=izabranPaket.zakupi()) {
				this.setNovcanoStanje(this.getNovcanoStanje()-izabranPaket.zakupi());
				izabranPaket.setZakupio(this);
				IO.sacuvajIzmene(Paket.getPath(), Paket.getSve());
				IO.sacuvajIzmene(path, sve);
				return true;
			}
			else return false;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean zakupiPaket(ArrayList<String> list){
		if(zakupiPaket(Paket.findPaket(list))) return true;
		else return false;
	}

	public void otkaziPaket(ArrayList<String> paket){
		int brisi =	Paket.getSve().indexOf(Paket.findPaket(paket));
		int vratiti=0;
		try {
			vratiti = Paket.getSve().get(brisi).zakupi()*(int) Paket.getSve().get(brisi).getPovrat()/100;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.setNovcanoStanje(this.getNovcanoStanje()+vratiti);
		IO.sacuvajIzmene(Klijent.getPath(), Klijent.getSve());
		Paket.getSve().get(brisi).otkazi();
	}

	public void uplata(int iznos){
		if(iznos>0){
			novcanoStanje+=iznos;
			IO.sacuvajIzmene(path, sve);
			}
	}

	public boolean equals(Klijent dr) {
		if (!(dr instanceof Klijent)) {
			return false;
		}
		Klijent pr = dr;
		return this.ime.equals(pr.ime) && this.prezime.equals(pr.prezime) && this.tip.equals(pr.tip) && this.korisnickoIme.equals(pr.korisnickoIme) && this.lozinka.equals(pr.lozinka);
	}

	public int getZakupljenih(){
		int vel=0;
		for (Paket p:Paket.getSve())
		{
			if(this.equals(p.getZakupio())) vel+=1;
		}
		return vel;
	}

	public ArrayList<Paket> getZakupljeni(){
		ArrayList<Paket> zakupljeni = new ArrayList<>();
		for(Paket p:Paket.getSve()){
			if(p.getZakupio()==null) continue;
			if(p.getZakupio().equals(this)) zakupljeni.add(p);
		}
		return zakupljeni;
	}
//endregion

}
