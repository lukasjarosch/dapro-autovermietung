package de.hrw.dapro.Controller;

import java.util.Scanner;

import de.hrw.dapro.View.AutomodellTableView;
import de.hrw.dapro.View.KundenView;
import de.hrw.dapro.View.ReservierungenView;
import de.hrw.dapro.View.SearchView;

public class MenuController {
	
	public static void printAbout() {
		System.out.println("+========================+");
		System.out.println("| DAPRO - Autovermietung |");
		System.out.println("+------------------------+");
		System.out.println("| Lukas Jarosch - 23837  |");
		System.out.println("+========================+");
	}
	
	@SuppressWarnings("resource")
	public static void printMainMenu() {
		System.out.println("\n+==================================================+");
		System.out.println("|            HAUPTMENÜ                             |");
		System.out.println("+==================================================+");
		System.out.println("| modelle - Automodelle auflisten                  |");
		System.out.println("| suche   - Automodelle suchen                     |");
		System.out.println("| kunden  - Öffnet das Kundenmenü                  |");
		System.out.println("| reservierungen - Öffnet das Reservierungen-Menü  |");
		System.out.println("| about   - Über das Tool                          |");
		System.out.println("| exit    - Beenden                                |");
		System.out.println("+==================================================+");
		System.out.print("Auswahl: ");
		
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		System.out.println("\n");
		MenuController.handleInput(input);
	}
	
	private static void handleInput(String input) {
		switch(input) {
			case "about":
				MenuController.printAbout();
			break;

			case "exit":
				ApplicationController.getInstance().setRunning(false);
				break;
				
			case "modelle":
				AutomodellTableView.printTable(ApplicationController.getInstance().databaseController().getAutomodelle());
				break;
				
			case "kunden":
				KundenView.printMenu();
				break;
			
			case "reservierungen":
				ReservierungenView.printMenu();
				break;
				
			case "suche":
				SearchView.printSearchMenu();
				break;
		}
		
	}
}
