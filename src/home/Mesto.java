package home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Mesto implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886211L;
	public static ArrayList<Mesto> sve = new ArrayList<Mesto>();
	public static String path = "podaci/mesta.xml";
	private String imeMesto;
	private Drzava uDrzavi;
//endregion
//region Konstruktori
	public Mesto(String imeMesto, Drzava uDrzavi) {
		this.imeMesto=imeMesto;
		this.uDrzavi=uDrzavi;
		upisi();
	}

//endregion
//region Getteri/Settteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static ArrayList<Mesto> getSve() {
		return sve;
	}
	public static void setSve(ArrayList<Mesto> sve) {
		Mesto.sve = sve;
	}
	public String getImeMesto() {
		return imeMesto;
	}
	public void setImeMesto(String imeMesto) {
		this.imeMesto = imeMesto;
	}
	public Drzava getuDrzavi() {
		return uDrzavi;
	}
	public void setuDrzavi(Drzava uDrzavi) {
		this.uDrzavi = uDrzavi;
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

	public static void dodaj(String imeMesto, Drzava uDrzavi){
		Drzava.getSve().get(Drzava.getSve().indexOf(uDrzavi)).getMestaUDrzavi().add(new Mesto(imeMesto, uDrzavi));
		IO.sacuvajIzmene(Drzava.getPath(), Drzava.getSve());
	}
//endregion
}
