package home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Drzava implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886210L;
	public static ArrayList<Drzava> sve = new ArrayList<Drzava>();
	public static String path = "podaci/drzave.xml";
	private String imeDrzava;
	private ArrayList<Mesto> mestaUDrzavi = new ArrayList<Mesto>();
//endregion
//region Konstruktori
	public Drzava(String imeDrzava) {
		this.imeDrzava=imeDrzava;
		upisi();
	}
//endregion
//region Getteri/Settteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static ArrayList<Drzava> getSve() {
		return sve;
	}
	public static void setSve(ArrayList<Drzava> sve) {
		Drzava.sve = sve;
	}
	public String getImeDrzava() {
		return imeDrzava;
	}
	public void setImeDrzava(String imeDrzava) {
		this.imeDrzava = imeDrzava;
	}
	public ArrayList<Mesto> getMestaUDrzavi() {
		return mestaUDrzavi;
	}
	public void setMestaUDrzavi(ArrayList<Mesto> mestaUDrzavi) {
		this.mestaUDrzavi = mestaUDrzavi;
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

	public static void dodaj(String ime){
		new Drzava(ime);
	}

	//endregion
}
