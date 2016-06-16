package de.hrw.dapro.View;

import java.util.ArrayList;

import de.hrw.dapro.Models.Automodell;

public class AutomodellTableView {
	private static String m_tableFormat 	= "| %-3d | %-20s | %-17s | %-3d | %-10d | %-3d | %-10s | %6.2f | %6.2f | %6d | %11d | %8d | %6s | %4d |%n";
	private static String m_tableSeparator  = "+=====+======================+===================+=====+============+=====+============+========+========+========+=============+==========+========+======+%n";
	private static String m_tableHeader 	= "| ID  | Bezeichnung          | Hersteller        | Art | Sitzplätze | kW  | Treibstoff | €/Tag  | €/km   | Achsen | Ladevolumen | Zuladung | Klasse | Güte |%n";
	

	public static void printTable(ArrayList<Automodell> models) {

		System.out.format(m_tableSeparator);
		System.out.format(m_tableHeader);
		System.out.format(m_tableSeparator);
		for(Automodell modell : models) {
			System.out.format(m_tableFormat, modell.id(), modell.bezeichnung(), modell.hersteller(), modell.autoartId(),
					modell.sitzplaetze(), (int)modell.kw(), modell.treibstoff(), modell.preisTag(), modell.preisKm(),
					modell.achsen(), modell.ladeVolumen(), modell.zuladung(), modell.fuehrerschein(), (int)modell.guete());
		}
		System.out.format(m_tableSeparator + "\n");
	}
}
