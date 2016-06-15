package de.hrw.dapro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hrw.dapro.Controller.ApplicationController;
import de.hrw.dapro.Controller.SearchController;
import de.hrw.dapro.Database.MysqlDatabase;
import de.hrw.dapro.Models.Ausstattung;
import de.hrw.dapro.Models.Auto;
import de.hrw.dapro.Models.Autoart;
import de.hrw.dapro.Models.Automodell;
import de.hrw.dapro.Models.Fuehrerschein;
import de.hrw.dapro.Models.Kunde;
import de.hrw.dapro.Models.Leihvertrag;
import de.hrw.dapro.Models.ModellHatAusstattung;
import de.hrw.dapro.Models.Reservierung;

public class Autovermietung {
	
	private static ApplicationController m_application = null;

	public static void main(String[] args) throws SQLException 
	{
		m_application = ApplicationController.getInstance();
		m_application.setDatabase(new MysqlDatabase("jdbc:mysql://localhost:3306/dapro", "root", "root"));
		m_application.database().connect();
		
		SearchController search = new SearchController();

		String[] hersteller = {"VW", "Opel"};
		String[] treibstoff = {"Diesel"};
		String[] autoart = {"LKW"};
		String[] fuehrerschein = {"B"};

		search.addHerstellerSelector(hersteller);
		search.addTreibstoffSelector(treibstoff);
		search.addPreisTagSelector(80.0f);
		search.addPreisKmSelector(0.05f);
		search.addKwSelector(100);
		search.addAchsenSelector(2);
		search.addSitzplaetzeSelector(5);
		search.addLadevolumenSelector(500);
		search.addAutoartSelector(autoart);
		search.addZuladungSelector(400);
		search.addFuehrerscheinSelector(fuehrerschein);
		ArrayList<Automodell> result = search.getOrderedData();
		
		//m_application.mainWindow().show();

		// Insert example
		/*
			String cols[] = {"KundeID", "ModellID", "Beginn", "Ende"};
			ArrayList<Object> values = new ArrayList<>();
			values.add(1);
			values.add(2);
			values.add(Date.valueOf("2016-12-31"));
			values.add(Date.valueOf("2012-1-1"));
			application.database().insertLocked("reservierung", cols, values);
		 */


		// Clean up
		m_application.database().disconnect();
	}
	
	/**
	 * Dumps all database tables to the console
	 */
	protected void dumpDatabase() 
	{
		// Init application
		ApplicationController application = ApplicationController.getInstance();
		if(application.database().equals(null)) {
			application.setDatabase(new MysqlDatabase("jdbc:mysql://localhost:3306/dapro", "root", "root"));
			application.database().connect();
		}		
	
		// Start application	
	
		// Auto --------------------
		System.out.println("----- AUTOS -----");
		ResultSet rs = application.database().selectAll("auto");
		ArrayList<Auto> autos = Auto.sqlFactory(rs);
		for(Auto tmp : autos) {
			System.out.println(tmp.toString());
		}
	
		// Ausstattungen -----------------
		System.out.println("----- AUSSTATTUNGEN -----");
		rs = application.database().selectAll("ausstattungen");
		ArrayList<Ausstattung> ausstattungen = Ausstattung.sqlFactory(rs);
		for(Ausstattung tmp : ausstattungen) {
			System.out.println(tmp.toString());
		}
	
		// Autoart -----------------
		System.out.println("----- AUTOARTEN -----");
		rs = application.database().selectAll("autoarten");
		ArrayList<Autoart> autoarten = Autoart.sqlFactory(rs);
		for(Autoart tmp : autoarten) {
			System.out.println(tmp.toString());
		}	
	
	
		// Automodell -----------------
		System.out.println("----- AUTOMODELLE -----");
		rs = application.database().selectAll("automodell");
		ArrayList<Automodell> automodell = Automodell.sqlFactory(rs);
		for(Automodell tmp : automodell) {
			System.out.println(tmp.toString());
		}
	
		// Führerscheine -----------------
		System.out.println("----- FÜHRERSCHEINE -----");
		rs = application.database().selectAll("fuehrerscheine");
		ArrayList<Fuehrerschein> fuehrerschein = Fuehrerschein.sqlFactory(rs);
		for(Fuehrerschein tmp : fuehrerschein) {
			System.out.println(tmp.toString());
		}
	
		// Kunden -----------------
		System.out.println("----- KUNDEN -----");
		rs = application.database().selectAll("kunde");
		ArrayList<Kunde> kunden = Kunde.sqlFactory(rs);
		for(Kunde tmp : kunden) {
			System.out.println(tmp.toString());
		}
	
		// Leihvertrag  -----------------
		System.out.println("----- LEIHVERTRÄGE -----");
		rs = application.database().selectAll("leihvertrag");
		ArrayList<Leihvertrag> leihvertrag = Leihvertrag.sqlFactory(rs);
		for(Leihvertrag tmp : leihvertrag) {
			System.out.println(tmp.toString());
		}
	
		// ModellHatAusstattung  -----------------
		System.out.println("----- ModellHatAusstattung -----");
		rs = application.database().selectAll("modhatausst");
		ArrayList<ModellHatAusstattung> ausstattung = ModellHatAusstattung.sqlFactory(rs);
		for(ModellHatAusstattung tmp : ausstattung) {
			System.out.println(tmp.toString());
		}
	
		// Reservierung  -----------------
		System.out.println("----- RESERVIERUNG -----");
		rs = application.database().selectAll("reservierung");
		ArrayList<Reservierung> reservierung = Reservierung.sqlFactory(rs);
		for(Reservierung tmp : reservierung) {
			System.out.println(tmp.toString());
		}
	}
	
}
