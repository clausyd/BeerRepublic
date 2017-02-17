package myBeers;

import java.io.Serializable;

public class Lager extends Beer implements Serializable {

	public double lPrice;

	public Lager(String countryName, double alcoVol, int barcode, String name, String colour, double lPrice) {
		super(countryName, alcoVol, barcode, name, colour);
		this.lPrice = lPrice;
	}

	public double getlPrice() {
		return lPrice;
	}

	public void setlPrice(double lPrice) {
		this.lPrice = lPrice;
	}

	@Override
	public String toString() {
		return super.toString() +"€"+lPrice + "\n";
	}

	@Override
	public String analyze() {

		return colour + "Colour" + alcoVol + "Alcohol Content";
	}

}
