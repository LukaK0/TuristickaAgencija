package home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Adresa implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886212L;
	public static ArrayList<Adresa> sve = new ArrayList<Adresa>();
	private String ulica;
	private String broj;
	private Mesto mesto;
	public static String path = "podaci/adrese.xml";
//endregion
//region Konstruktori
	public Adresa(Mesto mesto, String ulica, String broj) {
		this.ulica=ulica;
		this.broj=broj;
		this.mesto=mesto;
		upisi();
	}
//endregion
//region Getteri/Setteri
	public static ArrayList<Adresa> getSve() {
	return sve;
}
	public static void setSve(ArrayList<Adresa> sve) {
		Adresa.sve = sve;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public Mesto getMesto() {
		return mesto;
	}
	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
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

	public static void dodaj(Mesto mesto, String ulica, String broj){
	new Adresa(mesto, ulica, broj);
}

	@Override
	public String toString() {
		return ulica+" "+broj;
	}

//endregion
}

