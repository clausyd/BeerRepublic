package funcions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import beerRep.BeerManager;
import myBeers.Beer;

public class FileHandling implements Serializable {
	//ger beerList = new BeerManager();
	
	
	

	public FileHandling() {
		super();
	}

//	public static void writeArrayListToFile(List<Beer> beerList) {
//	
//
//		try {
//			File drink = new File("myBeer.dat");
//			FileOutputStream fos = new FileOutputStream(drink);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(beerList);
//
//			JOptionPane.showMessageDialog(null, "Written to file!");
//			oos.close();
//			fos.close();
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//		}
//	}
//
//	public static List<Beer> readArrayListFromFile() {
//
//		try {
//			File drink = new File("myBeer.dat");
//			FileInputStream fis = new FileInputStream(drink);
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			List<Beer> beerList =  (List<Beer>) ois.readObject();
//
//			
//			JOptionPane.showMessageDialog(null, "Read from file!");
//			ois.close();
//			fis.close();
//			return beerList;
//		
//		} 
//		catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//		}
//		
//
//	}
}
