package de.hrw.dapro.View;

import java.util.ArrayList;

import de.hrw.dapro.Models.Kunde;

public class KundenTableView {
	private static String m_tableFormat 		= "| %-3d | %-20s | %-20s | %-5s | %-20s | %-20s | %-20s | %-15s |%n";
	private static String m_tableSeparator  = "+=====+======================+======================+=======+======================+======================+======================+=================+%n";
	private static String m_tableHeader 	= "| ID  | Vorname              | Nachname             | PLZ   | Ort                  | Strasse              | Email                | Telefon         |%n";
		

		public static void printKundenTable(ArrayList<Kunde> kunden) {

			System.out.format(m_tableSeparator);
			System.out.format(m_tableHeader);
			System.out.format(m_tableSeparator);
			for(Kunde kunde : kunden) {
				System.out.format(m_tableFormat, kunde.id(), kunde.vorname(), kunde.nachname(),
									kunde.plz(), kunde.ort(), kunde.strasse(), kunde.email(), kunde.telNr());
			}
			System.out.format(m_tableSeparator);
		}
}
