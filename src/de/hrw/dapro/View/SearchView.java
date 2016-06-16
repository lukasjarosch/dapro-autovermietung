package de.hrw.dapro.View;

import java.util.Scanner;

import de.hrw.dapro.Controller.SearchController;

public class SearchView {
	private static SearchController m_search = new SearchController();

	public static void printSearchMenu() {
		Scanner scan = new Scanner(System.in);
		boolean scanning = true;
		m_search.reset();
		System.out.println("+-----------------------------------------------------+");
		System.out.println("|             Suche nach Automodellen                 |");
		System.out.println("+-----------------------------------------------------+");
		System.out.println("| 1 - Bezeichnung                                     |");
		System.out.println("| 2 - Hersteller                                      |");
		System.out.println("| 3 - Autoart                                         |");
		System.out.println("| 4 - Treibstoff                                      |");
		System.out.println("| 5 - Max. €/Tag                                      |");
		System.out.println("| 6 - Max. €/kM                                       |");
		System.out.println("| 7 - Min. Sitzplätze                                 |");
		System.out.println("| 0 - Suche abschließen und Ergebnis zeigen           |");
		System.out.println("+-----------------------------------------------------+\n");

		while(scanning) {
			System.out.print("Auswahl: ");
			scanning = SearchController.handleSearch(m_search, scan);
		}
	}
	
}
