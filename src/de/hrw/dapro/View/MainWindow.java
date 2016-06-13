package de.hrw.dapro.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainWindow {

	private JFrame frame;
	private JTable tblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 931, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{457, 457, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung");
		GridBagConstraints gbc_lblBezeichnung = new GridBagConstraints();
		gbc_lblBezeichnung.anchor = GridBagConstraints.EAST;
		gbc_lblBezeichnung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBezeichnung.gridx = 0;
		gbc_lblBezeichnung.gridy = 0;
		panel.add(lblBezeichnung, gbc_lblBezeichnung);
		
		JComboBox cbBezeichnung = new JComboBox();
		GridBagConstraints gbc_cbBezeichnung = new GridBagConstraints();
		gbc_cbBezeichnung.insets = new Insets(0, 0, 5, 0);
		gbc_cbBezeichnung.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbBezeichnung.gridx = 1;
		gbc_cbBezeichnung.gridy = 0;
		panel.add(cbBezeichnung, gbc_cbBezeichnung);
		
		JLabel lblHersteller = new JLabel("Hersteller");
		GridBagConstraints gbc_lblHersteller = new GridBagConstraints();
		gbc_lblHersteller.anchor = GridBagConstraints.EAST;
		gbc_lblHersteller.insets = new Insets(0, 0, 5, 5);
		gbc_lblHersteller.gridx = 0;
		gbc_lblHersteller.gridy = 1;
		panel.add(lblHersteller, gbc_lblHersteller);
		
		JComboBox cbHersteller = new JComboBox();
		GridBagConstraints gbc_cbHersteller = new GridBagConstraints();
		gbc_cbHersteller.insets = new Insets(0, 0, 5, 0);
		gbc_cbHersteller.anchor = GridBagConstraints.SOUTH;
		gbc_cbHersteller.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbHersteller.gridx = 1;
		gbc_cbHersteller.gridy = 1;
		panel.add(cbHersteller, gbc_cbHersteller);
		
		JLabel lblAutoart = new JLabel("Autorart");
		GridBagConstraints gbc_lblAutoart = new GridBagConstraints();
		gbc_lblAutoart.anchor = GridBagConstraints.EAST;
		gbc_lblAutoart.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutoart.gridx = 0;
		gbc_lblAutoart.gridy = 2;
		panel.add(lblAutoart, gbc_lblAutoart);
		
		JComboBox cbAutoart = new JComboBox();
		GridBagConstraints gbc_cbAutoart = new GridBagConstraints();
		gbc_cbAutoart.insets = new Insets(0, 0, 5, 0);
		gbc_cbAutoart.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbAutoart.gridx = 1;
		gbc_cbAutoart.gridy = 2;
		panel.add(cbAutoart, gbc_cbAutoart);
		
		JLabel lblSitzplaetze = new JLabel("Sitzplätze");
		GridBagConstraints gbc_lblSitzplaetze = new GridBagConstraints();
		gbc_lblSitzplaetze.anchor = GridBagConstraints.EAST;
		gbc_lblSitzplaetze.insets = new Insets(0, 0, 5, 5);
		gbc_lblSitzplaetze.gridx = 0;
		gbc_lblSitzplaetze.gridy = 3;
		panel.add(lblSitzplaetze, gbc_lblSitzplaetze);
		
		JComboBox cbSitzplaetze = new JComboBox();
		GridBagConstraints gbc_cbSitzplaetze = new GridBagConstraints();
		gbc_cbSitzplaetze.insets = new Insets(0, 0, 5, 0);
		gbc_cbSitzplaetze.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSitzplaetze.gridx = 1;
		gbc_cbSitzplaetze.gridy = 3;
		panel.add(cbSitzplaetze, gbc_cbSitzplaetze);
		
		JLabel lblTreibstoff = new JLabel("Treibstoff");
		GridBagConstraints gbc_lblTreibstoff = new GridBagConstraints();
		gbc_lblTreibstoff.anchor = GridBagConstraints.EAST;
		gbc_lblTreibstoff.insets = new Insets(0, 0, 5, 5);
		gbc_lblTreibstoff.gridx = 0;
		gbc_lblTreibstoff.gridy = 4;
		panel.add(lblTreibstoff, gbc_lblTreibstoff);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		panel.add(comboBox, gbc_comboBox);
		
		JButton btnReservieren = new JButton("Ausgewähltes Fahrzeug reservieren");
		GridBagConstraints gbc_btnReservieren = new GridBagConstraints();
		gbc_btnReservieren.anchor = GridBagConstraints.WEST;
		gbc_btnReservieren.insets = new Insets(0, 0, 0, 5);
		gbc_btnReservieren.gridx = 0;
		gbc_btnReservieren.gridy = 5;
		panel.add(btnReservieren, gbc_btnReservieren);
		
		JButton btnSuchen = new JButton("Suchen");
		GridBagConstraints gbc_btnSuchen = new GridBagConstraints();
		gbc_btnSuchen.fill = GridBagConstraints.BOTH;
		gbc_btnSuchen.gridx = 1;
		gbc_btnSuchen.gridy = 5;
		panel.add(btnSuchen, gbc_btnSuchen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		tblData.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Bezeichnung", "Hersteller", "Autoart", "Sitzpl\u00E4tze", "kW", "Treibstoff", "Preis / Tag", "Preis / km", "Achsen", "Ladevolumen", "Zuladung", "F\u00FChrerschein"
				}
			));				
	}

}
