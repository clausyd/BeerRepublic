package beerRep;

import java.util.List;

import javax.swing.JOptionPane;

import myBeers.Beer;
import myBeers.Lager;
import myBeers.Stout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class BeerManager implements Serializable {

	private List<Beer> beerList;

	public BeerManager() {
		beerList = new ArrayList<Beer>();
	}

	public static Comparator<Beer> countryComparator = new Comparator<Beer>() {
		public int compare(Beer a, Beer b) {
			return a.countryName.compareTo(b.countryName);
		}
	};

	public static Comparator<Beer> AlcoholComparator = new Comparator<Beer>() {
		public int compare(Beer a, Beer b) {
			return a.getAlcoVol() < b.getAlcoVol() ? -1 : a.getAlcoVol() == b.getAlcoVol() ? 0 : 1;
		}
	};


	public static Comparator<Lager> priceComparator = new Comparator<Lager>() {
		public int compare(Lager a, Lager b) {
			return  a.getlPrice() < b.getlPrice() ? -1 : a.getlPrice() == b.getlPrice() ? 0 : 1;
		}
	};

	public static Comparator<Stout> hopCountComparator = new Comparator<Stout>() {
		public int compare(Stout a, Stout b) {
			return  a.getHopCon() < b.getHopCon() ? -1 : a.getHopCon() == b.getHopCon() ? 0 :1;
		}
	};

	public static Comparator<Beer> nameComparator = new Comparator<Beer>() {
		public int compare(Beer a, Beer b) {
			return a.name.compareTo(b.name);
		}
	};

	public static Comparator<Beer> barcodeComparator = new Comparator<Beer>() {
		public int compare(Beer a, Beer b) {
			return a.barcode - (b.barcode);
		}
	};

	public boolean addBeer(Beer beerIn) {
		Beer beer = beerIn;
		int index = search(beer);
		if (index == 0) {
			return false;
		} else {
			beerList.add(beer);
			return true;
		}

	}

	public List<Beer> returnBeer() {
		return beerList;
	}

	public boolean remove(int barcodeIn) {

		Iterator<Beer> beer = beerList.iterator();

		while (beer.hasNext()) {

			if (beer.next().barcode == (barcodeIn))
				;
			{
				beer.remove();
				return true;
			}
		}
		return false;
	}

	public int search(Beer beer) {

		int index;
		Collections.sort(beerList, nameComparator);
		index = Collections.binarySearch(beerList, beer, barcodeComparator);

		return index;
	}

	public Beer searchBeers(int barcodeIn) {
		for (int i = 0; i < beerList.size(); i++) {

			Beer beer = beerList.get(i);

			int tempBarcode = beer.barcode;

			if (tempBarcode == (barcodeIn)) {
				return beer;

			}

		}
		return null;
	}

	public void sortBy(String name) {

		if (name.equalsIgnoreCase("Country")) {

			Collections.sort(beerList, countryComparator);

		}

		else if (name.equalsIgnoreCase("Name")) {

			Collections.sort(beerList, nameComparator);

		}
	}

	public List<Beer> getBeerList() {
		return beerList;
	}

	public void setBeerList(List<Beer> beerList) {
		this.beerList = beerList;
	}

	public String max() {
		Beer beer = Collections.max(beerList, AlcoholComparator);
		return beer.toString();
	}

	public String min() {
		
		Beer beer = Collections.min(beerList, AlcoholComparator);
		return beer.toString();
	}

	public Stout highistHopCon()
	 {
		List<Stout> stoutList = new ArrayList<>();
		for(Beer bbb : beerList)
			if(bbb instanceof Stout) stoutList.add(((Stout)bbb));
		
	 Stout stout = Collections.max(stoutList, hopCountComparator);
	return stout;
	 }
	
	public Stout lowestHopCon()
	 {
		List<Stout> stoutList = new ArrayList<>();
		for(Beer bbb : beerList)
			if(bbb instanceof Stout) stoutList.add(((Stout)bbb));
		
	 Stout stout = Collections.min(stoutList, hopCountComparator);
	return stout;
	 }

	 public Lager highistPrice()
	 {
	 List<Lager> lagerList = new ArrayList<>();
		for(Beer bbb : beerList)
			if(bbb instanceof Lager) lagerList.add(((Lager)bbb));
	 
	      Lager lager = Collections.max(lagerList, priceComparator);
	      return lager;
	}
	 
	 public Lager lowestPrice()
	 {
	 List<Lager> lagerList = new ArrayList<>();
		for(Beer bbb : beerList)
			if(bbb instanceof Lager) lagerList.add(((Lager)bbb));
	 
	      Lager lager = Collections.min(lagerList, priceComparator);
	      return lager;
	}

	
	 
	 
	 
	 
	 public void writeArrayListToFile() {

		try {
			File drink = new File("myBeer.dat");
			FileOutputStream fos = new FileOutputStream(drink);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(beerList);

			JOptionPane.showMessageDialog(null, "Written to file!");
			oos.close();
			fos.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

	}

	public void readArrayListFromFile() {

		try {
			File drink = new File("myBeer.dat");
			FileInputStream fis = new FileInputStream(drink);
			ObjectInputStream ois = new ObjectInputStream(fis);
			beerList = (List<Beer>) ois.readObject();

			JOptionPane.showMessageDialog(null, "Read from file!");
			ois.close();
			fis.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

	}
}
