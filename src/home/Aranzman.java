package home;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Aranzman implements java.io.Serializable, IO {
//region Polja
	protected static final long serialVersionUID = -1980325513659886218L;
	public static ArrayList<Aranzman> sve = new ArrayList<Aranzman>();
	public static String path = "podaci/aranzmani.xml";
	private boolean osiguranje;
	private boolean grupni;
	private String datumPolaska;
	private String datumPovratka;
	private Voz prevoznoVoz;
	private Avion prevoznoAvion;
	private Hotel smestajHotel;
	private Apartman smestajApartman;
//endregion
//region Konstruktori
	public Aranzman(boolean osiguranje, boolean grupni, String datumPolaska, String datumPovratka, Voz prevoznoVoz, Hotel smestajHotel) {
	super();
	this.osiguranje = osiguranje;
	this.grupni = grupni;
	this.datumPolaska = datumPolaska;
	this.datumPovratka = datumPovratka;
	this.prevoznoVoz = prevoznoVoz;
	this.prevoznoAvion = null;
	this.smestajHotel = smestajHotel;
	this.smestajApartman = null;
	upisi();
}
	public Aranzman(boolean osiguranje, boolean grupni, String datumPolaska, String datumPovratka, Voz prevoznoVoz, Apartman smestajApartman) {
		super();
		this.osiguranje = osiguranje;
		this.grupni = grupni;
		this.datumPolaska = datumPolaska;
		this.datumPovratka = datumPovratka;
		this.prevoznoVoz = prevoznoVoz;
		this.prevoznoAvion = null;
		this.smestajHotel = null;
		this.smestajApartman = smestajApartman;
		upisi();
	}
	public Aranzman(boolean osiguranje, boolean grupni, String datumPolaska, String datumPovratka, Avion prevoznoAvion, Hotel smestajHotel) {
		super();
		this.osiguranje = osiguranje;
		this.grupni = grupni;
		this.datumPolaska = datumPolaska;
		this.datumPovratka = datumPovratka;
		this.prevoznoVoz = null;
		this.prevoznoAvion = prevoznoAvion;
		this.smestajHotel = smestajHotel;
		this.smestajApartman = null;
		upisi();
	}
	public Aranzman(boolean osiguranje, boolean grupni, String datumPolaska, String datumPovratka, Avion prevoznoAvion, Apartman smestajApartman) {
		super();
		this.osiguranje = osiguranje;
		this.grupni = grupni;
		this.datumPolaska = datumPolaska;
		this.datumPovratka = datumPovratka;
		this.prevoznoVoz = null;
		this.prevoznoAvion = prevoznoAvion;
		this.smestajHotel = null;
		this.smestajApartman = smestajApartman;
		upisi();
	}
//endregion
//region Getteri/Settteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static ArrayList<Aranzman> getSve() {
		return sve;
	}
	public static void setSve(ArrayList<Aranzman> sve) {
		Aranzman.sve = sve;
	}
	public boolean isOsiguranje() {
		return osiguranje;
	}
	public void setOsiguranje(boolean osiguranje) {
		this.osiguranje = osiguranje;
	}
	public boolean isGrupni() {
		return grupni;
	}
	public void setGrupni(boolean grupni) {
		this.grupni = grupni;
	}
	public String getDatumPolaska() {
		return datumPolaska;
	}
	public void setDatumPolaska(String datumPolaska) {
		this.datumPolaska = datumPolaska;
	}
	public String getDatumPovratka() {
		return datumPovratka;
	}
	public void setDatumPovratka(String datumPovratka) {
		this.datumPovratka = datumPovratka;
	}
	public Voz getPrevoznoVoz() {
		return prevoznoVoz;
	}
	public void setPrevoznoVoz(Voz prevoznoVoz) {
		this.prevoznoVoz = prevoznoVoz;
	}
	public Avion getPrevoznoAvion() {
		return prevoznoAvion;
	}
	public void setPrevoznoAvion(Avion prevoznoAvion) {
		this.prevoznoAvion = prevoznoAvion;
	}
	public Hotel getSmestajHotel() {
		return smestajHotel;
	}
	public void setSmestajHotel(Hotel smestajHotel) {
		this.smestajHotel = smestajHotel;
	}
	public Apartman getSmestajApartman() {
		return smestajApartman;
	}
	public void setSmestajApartman(Apartman smestajApartman) {
		this.smestajApartman = smestajApartman;
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

	public int getDanaUSmestaju() throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
		Date t1, t2;
		t1 = ft.parse(this.datumPolaska);
		t2 = ft.parse(this.datumPovratka);
		return (int)( (t2.getTime() - t1.getTime())/(1000 * 60 * 60 * 24));
	}

	public static void dodaj(boolean osiguranje, boolean grupni, String datumOd, String datumDo, PrevoznoSredstvo prevoz, Smestaj smestaj){
		String tipSmestaja = smestaj.getClass().getSimpleName();
		String tipPrevoza = prevoz.getClass().getSimpleName();
		if(tipPrevoza.equalsIgnoreCase("avion") && tipSmestaja.equalsIgnoreCase("apartman")) new Aranzman(osiguranje, grupni, datumOd, datumDo, (Avion)prevoz, (Apartman)smestaj);
		else if(tipPrevoza.equalsIgnoreCase("avion") && tipSmestaja.equalsIgnoreCase("hotel")) new Aranzman(osiguranje, grupni, datumOd, datumDo, (Avion)prevoz, (Hotel)smestaj);
		else if(tipPrevoza.equalsIgnoreCase("voz") && tipSmestaja.equalsIgnoreCase("apartman")) new Aranzman(osiguranje, grupni, datumOd, datumDo, (Voz)prevoz, (Apartman)smestaj);
		else if(tipPrevoza.equalsIgnoreCase("voz") && tipSmestaja.equalsIgnoreCase("hotel")) new Aranzman(osiguranje, grupni, datumOd, datumDo, (Voz)prevoz, (Hotel)smestaj);
	}
//endregion



	

	


}
