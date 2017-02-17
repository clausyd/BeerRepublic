package beerRep;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcions.FileHandling;
import myBeers.Beer;
import myBeers.Lager;
import myBeers.Stout;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class BeerGui extends JFrame {

	private JPanel contentPane;
	private JTextField barcode;
	private JTextField namebox;
	private JTextField country;
	private JTextField alVol;
	private JTextField colour;
	private JTextField price;
	private JTextField hopCount;
	public String item;
	BeerManager beerList = new BeerManager();
	public String[] choice = { "Larger", "Stout" };
	FileHandling files = new FileHandling();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					BeerGui frame = new BeerGui();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BeerGui() {
		beerList.readArrayListFromFile();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(907, 28, 17, 383);
		contentPane.add(scrollBar);

		JButton btNSave = new JButton("SEARCH");
		btNSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Beer beer;
				try {
					int barcodeIn = Integer.parseInt(barcode.getText());

					beer = beerList.searchBeers(barcodeIn);
					if (beer == null) {
						JOptionPane.showMessageDialog(null, "No Beer with That barcode");
					} else {
						JOptionPane.showMessageDialog(null, beer.toString());
					}

				} catch (IllegalArgumentException e5) {

					JOptionPane.showMessageDialog(null, "Must Enter Some Details");
				}
			}
		});
		btNSave.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btNSave.setBounds(24, 83, 110, 33);
		contentPane.add(btNSave);

		JLabel lblCountry = new JLabel("COUNTRY");
		lblCountry.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblCountry.setBounds(367, 177, 85, 28);
		contentPane.add(lblCountry);

		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblNewLabel.setBounds(367, 133, 58, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ALCOHOL VOLUME");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblNewLabel_1.setBounds(364, 226, 131, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblColour = new JLabel("COLOUR");
		lblColour.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblColour.setBounds(367, 283, 58, 25);
		contentPane.add(lblColour);

		JLabel lblNewLabel_2 = new JLabel("BARCODE");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblNewLabel_2.setBounds(367, 83, 71, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lb = new JLabel("HOP COUNT");
		lb.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lb.setBounds(367, 386, 87, 25);
		contentPane.add(lb);

		JLabel lblNewLabel_4 = new JLabel("PRICE");
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNewLabel_4.setBounds(367, 338, 58, 20);
		contentPane.add(lblNewLabel_4);

		barcode = new JTextField();
		barcode.setBounds(498, 81, 86, 20);
		contentPane.add(barcode);
		barcode.setColumns(10);

		namebox = new JTextField();
		namebox.setBounds(498, 131, 86, 20);
		contentPane.add(namebox);
		namebox.setColumns(10);

		country = new JTextField();
		country.setBounds(498, 182, 86, 20);
		contentPane.add(country);
		country.setColumns(10);

		alVol = new JTextField();
		alVol.setBounds(498, 229, 86, 20);
		contentPane.add(alVol);
		alVol.setColumns(10);

		colour = new JTextField();
		colour.setBounds(498, 286, 86, 20);
		contentPane.add(colour);
		colour.setColumns(10);

		price = new JTextField();
		price.setBounds(498, 339, 86, 20);
		contentPane.add(price);
		price.setColumns(10);

		hopCount = new JTextField();
		hopCount.setBounds(498, 389, 86, 20);
		contentPane.add(hopCount);
		hopCount.setColumns(10);

		JLabel LOGO = new JLabel("BEER REPUBLIC");
		LOGO.setFont(new Font("Algerian", Font.PLAIN, 28));
		LOGO.setBounds(259, 11, 219, 38);
		contentPane.add(LOGO);

		JList list = new JList();
		list.setBounds(624, 28, 300, 383);
		contentPane.add(list);

		JButton btnNewButton_1 = new JButton("REFRESH LIST");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Beer> tempBeerList;
				tempBeerList = beerList.returnBeer();

				DefaultListModel<String> l = new DefaultListModel<>();
				list.setModel(l);

				for (Beer b : tempBeerList)
					l.addElement(b.toString());

			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_1.setBounds(167, 133, 141, 33);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean deleted;
				try {
					deleted = beerList.remove(Integer.parseInt(barcode.getText()));
					if (deleted == true)

					{

						JOptionPane.showMessageDialog(null, "Beer Removed");
					} else

					{

						JOptionPane.showMessageDialog(null, "Beer not Removed");
					}
				} catch (IllegalArgumentException e4) {
					JOptionPane.showMessageDialog(null, "Must Such for a Beer First");
				}

			}
		});
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_2.setBounds(24, 133, 110, 33);
		contentPane.add(btnNewButton_2);

		JComboBox sortBox = new JComboBox();
		sortBox.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		sortBox.setModel(new DefaultComboBoxModel(new String[] { "Name", "Country" }));
		sortBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Beer tempBeer;

				if (((String) sortBox.getSelectedItem()).equals("Name")) {
					String Name = "";
					beerList.sortBy(Name);
					JOptionPane.showMessageDialog(null, beerList.getBeerList());
				} else if (((String) sortBox.getSelectedItem()).equals("Country")) {
					String Country = "";
					beerList.sortBy(Country);
					JOptionPane.showMessageDialog(null, beerList.getBeerList());

				}

			}
		});
		sortBox.setBounds(167, 229, 141, 33);
		contentPane.add(sortBox);

		JLabel lblNewLabel_5 = new JLabel("SORT BY");
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_5.setBounds(24, 245, 71, 33);
		contentPane.add(lblNewLabel_5);

		JComboBox AlcoVol = new JComboBox();
		AlcoVol.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		AlcoVol.setModel(new DefaultComboBoxModel(new String[] { "Highist", "Lowest" }));
		AlcoVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (AlcoVol.getSelectedItem().equals("Highist")) {
					String beer;
					beer = beerList.max();
					JOptionPane.showMessageDialog(null, beer.toString());
				} else if (AlcoVol.getSelectedItem().equals("Lowest")) {
					String beer;
					beer = beerList.min();
					JOptionPane.showMessageDialog(null, beer.toString());
				}

			}
		});
		AlcoVol.setBounds(167, 338, 141, 33);
		contentPane.add(AlcoVol);

		JLabel lblNewLabel_6 = new JLabel("ALCOHOL VOLUME");
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_6.setBounds(24, 338, 141, 33);
		contentPane.add(lblNewLabel_6);

		JComboBox hopCountBox = new JComboBox();
		hopCountBox.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		hopCountBox.setModel(new DefaultComboBoxModel(new String[] { "Highist", "Lowest" }));
		hopCountBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (hopCountBox.getSelectedItem().equals("Highist")) {
					Stout beer;
					beer = beerList.highistHopCon();
					JOptionPane.showMessageDialog(null, beer.toString());
				} else if (hopCountBox.getSelectedItem().equals("Lowest")) {
					Stout beer;
					beer = beerList.lowestHopCon();
					JOptionPane.showMessageDialog(null, beer.toString());
				}

			}
		});
		hopCountBox.setBounds(167, 283, 141, 33);
		contentPane.add(hopCountBox);

		JLabel lblNewLabel_7 = new JLabel("HOP COUNT");
		lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_7.setBounds(24, 283, 92, 36);
		contentPane.add(lblNewLabel_7);

		JComboBox priceBox = new JComboBox();
		priceBox.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		priceBox.setModel(new DefaultComboBoxModel(new String[] { "Highist", "Lowest" }));
		priceBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (priceBox.getSelectedItem().equals("Highist")) {
					Lager beer;
					beer = beerList.highistPrice();
					JOptionPane.showMessageDialog(null, beer.toString());
				} else if (priceBox.getSelectedItem().equals("Lowest")) {
					Lager beer;
					beer = beerList.lowestPrice();
					JOptionPane.showMessageDialog(null, beer.toString());
				}

			}
		});
		priceBox.setBounds(167, 386, 141, 33);
		contentPane.add(priceBox);

		JLabel lblNewLabel_8 = new JLabel("PRICE");
		lblNewLabel_8.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_8.setBounds(24, 386, 67, 28);
		contentPane.add(lblNewLabel_8);

		JComboBox addSelection = new JComboBox();
		addSelection.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		addSelection.setModel(new DefaultComboBoxModel(choice));
		addSelection.setBounds(167, 182, 141, 33);
		contentPane.add(addSelection);
		ActionListener et = null;

		JButton btnNewButton_3 = new JButton("ADD");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (((String) addSelection.getSelectedItem()).equals("Larger")) {

					boolean ifLagerAdded;
					try {
						int bar = Integer.parseInt(barcode.getText());
						String name = namebox.getText();
						String countryName = country.getText();
						double alcoVol = Double.parseDouble(alVol.getText());
						String col = colour.getText();
						double pri = Double.parseDouble(price.getText());

						Lager lager = new Lager(countryName, alcoVol, bar, name, col, pri);
						ifLagerAdded = beerList.addBeer(lager);

						if (ifLagerAdded == true) {
							JOptionPane.showMessageDialog(null, "Lager Added");

						} else if (ifLagerAdded == false) {
							JOptionPane.showMessageDialog(null, "Lager not Added");

						}
					} catch (IllegalArgumentException e9) {

						JOptionPane.showMessageDialog(null, "Must Enter Detail before");
					}

				} else if (((String) addSelection.getSelectedItem()).equals("Stout")) {
					boolean ifStoutAdded;
					try {
						int bar = Integer.parseInt(barcode.getText());
						String name = namebox.getText();
						String countryName = country.getText();
						double alcoVol = Double.parseDouble(alVol.getText());
						String col = colour.getText();
						double hopCon = Double.parseDouble(hopCount.getText());

						Stout stout = new Stout(countryName, alcoVol, bar, name, col, hopCon);
						ifStoutAdded = beerList.addBeer(stout);

						if (ifStoutAdded == true) {
							JOptionPane.showMessageDialog(null, "Stout Added");

						} else if (ifStoutAdded == false) {
							JOptionPane.showMessageDialog(null, "Stout not Added");

						}

					} catch (IllegalArgumentException e7) {

						JOptionPane.showMessageDialog(null, "Must Enter Detail before");
					}
				}
			}
		});

		btnNewButton_3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_3.setBounds(24, 182, 110, 33);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("EXIT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beerList.writeArrayListToFile();
				System.exit(0);

				;
			}
		});
		btnNewButton_4.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		btnNewButton_4.setBounds(24, 425, 110, 23);
		contentPane.add(btnNewButton_4);

		JComboBox updateField = new JComboBox();
		updateField.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		updateField.setModel(new DefaultComboBoxModel(
				new String[] { "Name", "Country", "Alcohol Volume", "Colour", "Price", "Hop Count" }));
		updateField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// Beer tempBeer = (Beer) list.getSelectedValue();
					int barcode1 = Integer.parseInt(barcode.getText());
					Beer tempBeer;
					tempBeer = beerList.searchBeers(barcode1);

					if (updateField.getSelectedItem().equals("Name")) {
						String entry = JOptionPane.showInputDialog(contentPane, "Update Name");

						tempBeer.setName(entry);
						;
					} else if (updateField.getSelectedItem().equals("Country")) {
						String countryIn = JOptionPane.showInputDialog(contentPane, "Update Country");
						tempBeer.setCountryName(countryIn);
						;
					}

					else if (updateField.getSelectedItem().equals("Alcohol Volume")) {

						String entry1 = JOptionPane.showInputDialog(contentPane, "Update Alcohal Voloume");
						tempBeer.setAlcoVol(Double.parseDouble(entry1));
					} else if (updateField.getSelectedItem().equals("Colour")) {

						String colourIn = JOptionPane.showInputDialog(contentPane, "Update Colour");
						tempBeer.setColour(colourIn);
						;
					} else if (updateField.getSelectedItem().equals("Price")) {

						String priceIn = JOptionPane.showInputDialog(contentPane, "Update Price");
						((Lager) tempBeer).setlPrice(Double.parseDouble(priceIn));
					} else if (updateField.getSelectedItem().equals("Hop Count")) {

						String hop = JOptionPane.showInputDialog(contentPane, "Update Hop Count");
						((Stout) tempBeer).setHopCon(Double.parseDouble(hop));
					}
				} catch (IllegalArgumentException e7) {
					JOptionPane.showMessageDialog(null, "Must Search for a Beer First" + "\n" + "Before you update");
				}

			}
		});

		updateField.setBounds(167, 83, 141, 33);
		contentPane.add(updateField);

	}
}
