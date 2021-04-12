package home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import enumeracije.TipPansiona;

public class Hotel extends Smestaj implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886214L;
	public static ArrayList<Hotel> sve = new ArrayList<Hotel>();
	public static String path = "podaci/hoteli.xml";
	private int brojZvezdica;
//endregion
//region Konstruktori
	public Hotel(int povrsina, int brojKreveta, int brojZvezdica, TipPansiona tipPansiona, Adresa adresa) {
		super(povrsina, brojKreveta, tipPansiona, adresa);
		this.brojZvezdica=brojZvezdica;
		upisi();
	}
//endregion
//region Getteri/Settteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static ArrayList<Hotel> getSve() {
		return sve;
	}
	public static void setSve(ArrayList<Hotel> sve) {
		Hotel.sve = sve;
	}
	public int getBrojZvezdica() {
		return brojZvezdica;
	}
	public void setBrojZvezdica(int brojZvezdica) {
		this.brojZvezdica = brojZvezdica;
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

	public static void dodaj(int povrsina, int brojKreveta, TipPansiona tipPansiona, Adresa adresa, int brojZvezdica){
		new Hotel(povrsina, brojKreveta, brojZvezdica, tipPansiona, adresa);
	}
//endregion
}
