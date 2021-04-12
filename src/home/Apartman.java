package home;

import enumeracije.TipPansiona;

import java.io.*;
import java.util.ArrayList;

public class Apartman extends Smestaj implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886215L;
	public static ArrayList<Apartman> sve = new ArrayList<Apartman>();
	public static String path = "podaci/apartmani.xml";
//endregion
//region Konstruktori
	public Apartman(int povrsina, int brojKreveta, TipPansiona tipPansiona, Adresa adresa) {
		super(povrsina, brojKreveta, tipPansiona, adresa);
		upisi();
	}
//endregion
//region Getteri/Setteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static ArrayList<Apartman> getSve() {
		return sve;
	}
	public static void setSve(ArrayList<Apartman> sve) {
		Apartman.sve = sve;
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

	public static void dodaj(int povrsina, int brojKreveta, TipPansiona tipPansiona, Adresa adresa){
		new Apartman(povrsina, brojKreveta, tipPansiona, adresa);
	}
//endregion
}
