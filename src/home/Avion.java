package home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import enumeracije.TipKlaseAvionskogMesta;

public class Avion extends PrevoznoSredstvo implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886216L;
	public static ArrayList<Avion> sve = new ArrayList<Avion>();
	public static String path = "podaci/avioni.xml";
	private TipKlaseAvionskogMesta klasaAvionskogMesta;
//endregion
//region Konstruktori
	public Avion(boolean obrok, Adresa polaznaAdresa, Adresa odredisnaAdresa, TipKlaseAvionskogMesta klasaAvionskogMesta) {
		super(obrok, polaznaAdresa, odredisnaAdresa);
		this.klasaAvionskogMesta=klasaAvionskogMesta;
		upisi();
	}
//endregion
//region Getteri/Settteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static ArrayList<Avion> getSve() {
		return sve;
	}
	public static void setSve(ArrayList<Avion> sve) {
		Avion.sve = sve;
	}
	public TipKlaseAvionskogMesta getKlasaAvionskogMesta() {
		return klasaAvionskogMesta;
	}
	public void setKlasaAvionskogMesta(TipKlaseAvionskogMesta klasaAvionskogMesta) {
		this.klasaAvionskogMesta = klasaAvionskogMesta;
	}
	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Paket.path = path;
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

	public int zakupi() {
		int izracunato = super.zakupi();
		if(this.klasaAvionskogMesta.compareTo(TipKlaseAvionskogMesta.BIZNIS)==0) {izracunato+=1000;}
		else {izracunato+=250;}
		return izracunato;
	}

	public static void dodaj(boolean obrok, Adresa od, Adresa dokle, TipKlaseAvionskogMesta klasa){
		new Avion(obrok, od, dokle, klasa);
	}
//endregion
}
