package de.hrw.dapro.View;

import java.util.ArrayList;

import de.hrw.dapro.Models.Leihvertrag;

public class ReservierungTableView {
	private static String m_tableFormat = "| %-3d | %-5d | %-5d | %-15s | %-15s | %-10d | %-10d | %-10.2f | %-7s |%n";
	private static String m_tableSeparator  = "+=====+=======+======+=================+=================+============+============+============+=========+%n";
	private static String m_tableHeader 	= "| ID  | Kunde | Auto | Beginn          | Ende            | Start [km] | Ende [km]  | Betrag [€] | Bezahlt |%n";
		

		public static void printKundenTable(ArrayList<Leihvertrag> vertraege) {

			System.out.format(m_tableSeparator);
			System.out.format(m_tableHeader);
			System.out.format(m_tableSeparator);
			for(Leihvertrag vertrag : vertraege) {
				System.out.format(m_tableFormat, vertrag.id(), vertrag.kundenId(), vertrag.autoId(),
						vertrag.beginn().toString(), vertrag.ende().toString(), vertrag.startKm(), 
						vertrag.endKm(), vertrag.rechnungsBetrag(), (vertrag.bezahlt() ? "JA" : "NEIN"));
			}
			System.out.format(m_tableSeparator);
		}

}
