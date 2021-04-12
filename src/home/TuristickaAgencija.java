package home;

import java.util.ArrayList;

public class TuristickaAgencija {
	public static ArrayList<Klijent> klijenti = new ArrayList<Klijent>();
	public static ArrayList<Agent> agenti = new ArrayList<Agent>();
	public TuristickaAgencija() {
	}

	public static ArrayList<Klijent> getKlijenti() {
		return klijenti;
	}

	public static void setKlijenti(ArrayList<Klijent> klijenti) {
		TuristickaAgencija.klijenti = klijenti;
	}

	public static ArrayList<Agent> getAgenti() {
		return agenti;
	}

	public static void setAgenti(ArrayList<Agent> agenti) {
		TuristickaAgencija.agenti = agenti;
	}

	private String naziv;
}
