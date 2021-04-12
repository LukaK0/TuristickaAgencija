package home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import enumeracije.TipKlaseVoznogMesta;

public class Voz extends PrevoznoSredstvo implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886217L;
	public static ArrayList<Voz> sve = new ArrayList<Voz>();
	public static String path = "podaci/vozovi.xml";
	private TipKlaseVoznogMesta klasaVoznogMesta;
	//endregion
//region Konstruktori
	public Voz(boolean obrok, Adresa polaznaAdresa, Adresa odredisnaAdresa, TipKlaseVoznogMesta klasaVoznogMesta) {
	super(obrok, polaznaAdresa, odredisnaAdresa);
	this.klasaVoznogMesta=klasaVoznogMesta;
	upisi();
}
//endregion
//region Getteri/Settteri
	public static ArrayList<Voz> getSve() {
	return sve;
}
	public static void setSve(ArrayList<Voz> sve) {
		Voz.sve = sve;
	}
	public TipKlaseVoznogMesta getKlasaVoznogMesta() {
		return klasaVoznogMesta;
	}
	public void setKlasaVoznogMesta(TipKlaseVoznogMesta klasaVoznogMesta) {
		this.klasaVoznogMesta = klasaVoznogMesta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Paket.path = path;
	}
//endregion
//region Metode
	public int zakupi() {
	int izracunato = super.zakupi();
	if(this.klasaVoznogMesta.compareTo(TipKlaseVoznogMesta.PRVIRAZRED)==0) {izracunato+=210;}
	else if(this.klasaVoznogMesta.compareTo(TipKlaseVoznogMesta.SPAVACAKOLA)==0) {izracunato+=1000;}
	return izracunato;
}

	public void upisi(){
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path));
			sve.add(this);
			oos.writeObject(sve);
			oos.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ucitaj() {
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path));
			try {
				sve =(ArrayList) ois.readObject();
				ois.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void dodaj(boolean obrok, Adresa od, Adresa dokle, TipKlaseVoznogMesta klasa){
		new Voz(obrok, od, dokle, klasa);
	}
//endregion
}
