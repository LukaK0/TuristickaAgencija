package home;

import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;

public class Paket implements java.io.Serializable, IO,Zakupljivo {
//region Polja
	protected static final long serialVersionUID = -1980325513659886219L;
	public static ArrayList<Paket> sve = new ArrayList<>();
	public static String path = "podaci/paketi.xml";
	private ArrayList<Aranzman> aranzmaniUPaketu = new ArrayList<>();
	private double povrat;
	private Agent kreiraoA;
	private Klijent kreiraoK;
	private Klijent zakupio;
//endregion
//region Konstruktori
	public Paket(double povrat, Agent kreiraoA) {
		super();
		this.povrat = povrat;
		this.kreiraoA = kreiraoA;
		this.kreiraoK = null;
		this.zakupio = null;
		upisi();
	}
	public Paket(double povrat, Klijent kreiraoK) {
		super();
		this.povrat = povrat;
		this.kreiraoA = null;
		this.kreiraoK = kreiraoK;
		this.zakupio = null;
		upisi();
	}
//endregion
//region Getteri/Settteri
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static ArrayList<Paket> getSve() {
		return sve;
	}
	public static void setSve(ArrayList<Paket> sve) {
		Paket.sve = sve;
	}
	public ArrayList<Aranzman> getAranzmaniUPaketu() {
		return aranzmaniUPaketu;
	}
	public void setAranzmaniUPaketu(ArrayList<Aranzman> aranzmaniUPaketu) {
		this.aranzmaniUPaketu = aranzmaniUPaketu;
	}
	public double getPovrat() {
		return povrat;
	}
	public void setPovrat(double povrat) {
		this.povrat = povrat;
	}
	public Agent getKreiraoA() {
		return kreiraoA;
	}
	public void setKreiraoA(Agent kreiraoA) {
		this.kreiraoA = kreiraoA;
	}
	public Klijent getKreiraoK() {
		return kreiraoK;
	}
	public void setKreiraoK(Klijent kreiraoK) {
		this.kreiraoK = kreiraoK;
	}
	public Klijent getZakupio() {
		return zakupio;
	}
	public void setZakupio(Klijent zakupio) {
		this.zakupio = zakupio;
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

	public int zakupi() throws ParseException {
		int ukupno=0;

		for(Aranzman i:aranzmaniUPaketu) {
			int danaUSmestaju = i.getDanaUSmestaju();
			if(i.getSmestajHotel()!=null) {ukupno+=i.getSmestajHotel().zakupi()*danaUSmestaju;}
			else if (i.getSmestajApartman()!=null){ukupno+=i.getSmestajApartman().zakupi()*danaUSmestaju;}
			if(i.getPrevoznoAvion()!=null) {ukupno+=i.getPrevoznoAvion().zakupi();}
			else if (i.getPrevoznoVoz()!=null) {ukupno+=i.getPrevoznoVoz().zakupi();}
		}
		return ukupno;
	}

	public void otkazi() {
		this.zakupio=null;
		IO.sacuvajIzmene(Paket.getPath(), Paket.getSve());
	}

	public static void otkazi(ArrayList<String> list){
			Paket p = findPaket(list);

			int vratiti = 0;
		try {
			vratiti = p.zakupi() * (int) p.getPovrat() / 100;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		p.getZakupio().setNovcanoStanje(p.getZakupio().getNovcanoStanje()+vratiti);
			IO.sacuvajIzmene(Klijent.getPath(), Klijent.getSve());
			p.otkazi();

	}

	public static Paket findPaket(ArrayList<String> list){
		Paket pk=null;
		for(Paket p: sve) {
			if (Integer.parseInt(list.get(0)) != p.getAranzmaniUPaketu().size()) continue;
			if (Double.parseDouble(list.get(1).substring(0, list.get(1).length() - 1)) != p.getPovrat()) continue;
			try {
				if (Integer.parseInt(list.get(2)) != p.zakupi()) continue;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(p.getKreiraoA()==null && !list.get(3).equals(p.getKreiraoK().getKorisnickoIme())) continue;
			if(p.getKreiraoK()==null && !list.get(3).equals(p.getKreiraoA().getKorisnickoIme())) continue;
			pk=p;
		}
		return pk;
	}

	public static ArrayList<Paket> getSlobodni(){
		ArrayList<Paket> slobodni = new ArrayList<>();
		for(Paket p:Paket.getSve()){
			if(p.getZakupio()==null) slobodni.add(p);
		}
		return slobodni;
	}

//endregion
}
