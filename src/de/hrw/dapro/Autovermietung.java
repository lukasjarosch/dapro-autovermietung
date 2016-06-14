package de.hrw.dapro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public static void main(String[] args) throws SQLException {
		
		// Init application
		ApplicationController application = ApplicationController.getInstance();
		application.setDatabase(new MysqlDatabase("jdbc:mysql://localhost:3306/dapro", "root", "root"));
		application.database().connect();
		
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
		application.database().disconnect();
	}

}
