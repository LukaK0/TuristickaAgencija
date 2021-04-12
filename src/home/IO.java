package home;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public interface IO {
	void upisi();

	static void sacuvajIzmene(String path, ArrayList sve) {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(sve);
			oos.close();
		}
		catch (IOException e) {
			System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
		}
	}
}
