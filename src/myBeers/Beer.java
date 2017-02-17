package myBeers;

import java.io.Serializable;
import java.util.Comparator;

import javax.swing.JOptionPane;

public abstract class Beer implements Serializable {

	public String countryName;
	public double alcoVol;
	public int barcode;
	public String name;
	public String colour;

	public Beer(String countryName, double alcoVol, int barcode, String name, String colour) {
		super();
		this.countryName = countryName;
		this.name = name;
		this.barcode = barcode;
		this.alcoVol = alcoVol;
		this.colour = colour;
		
		
//	 if(countryName == "" || countryName == null  || name == "" || name == null || barcode == -999 || 
//			 alcoVol == -999 || colour == "" || colour == null )
//		 throw new IllegalArgumentException( "Must Enter Detail before"); 
//		
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setAlcoVol(double alcoVol) {
		this.alcoVol = alcoVol;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return barcode +"  " + name + "     " + countryName + "  " +  "  " + "ABV"+alcoVol + "  " + colour + "  ";
	}
	

	public String getCountryName() {
		return countryName;
	}

	public double getAlcoVol() {
		return alcoVol;
	}

	public int getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}

	public String getColour() {
		return colour;
	}

	public abstract String analyze();

}
