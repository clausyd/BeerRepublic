package myBeers;

import java.io.Serializable;

public class Stout extends Beer implements Serializable {

	public double hopCon;

	public Stout(String countryName, double alcoVol, int barcode, String name, String colour, double hopCon) {
		super(countryName, alcoVol, barcode, name, colour);

		this.hopCon = hopCon;
	}

	public void setHopCon(double hopCon) {
		this.hopCon = hopCon;
	}

	@Override
	public String toString() {
		return super.toString() + hopCon + "\n";
	}

	public double getHopCon() {
		return hopCon;
	}

	public String analyze() {

		return hopCon + "Hop Content" + alcoVol + "Alcohol Content";
	}

}
