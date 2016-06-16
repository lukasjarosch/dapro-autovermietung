package de.hrw.dapro.View;

import java.util.ArrayList;
import java.util.Scanner;

import de.hrw.dapro.Controller.KundenController;
import de.hrw.dapro.Models.Kunde;

public class KundenView {

	public static void printMenu() {
		Scanner scan = new Scanner(System.in);
		boolean scanning = true;
		System.out.println("+------------------------------------+");
		System.out.println("|             Kunden                 |");
		System.out.println("+------------------------------------+");
		System.out.println("| 0 - Zum Hauptmenü                  |");
		System.out.println("| 1 - Kunden anzeigen                |");
		System.out.println("| 2 - Kunde anlegen                  |");
		System.out.println("+------------------------------------+");

		while(scanning) {
			System.out.print("Auswahl: ");
			scanning = KundenController.handleKundenmenu(scan);
		}
	}
	
	public static ArrayList<Object> addCustomer() {
		ArrayList<Object> kunde = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n+------------------------------------+");
		System.out.println("|             Neuer Kunde            |");
		System.out.println("+------------------------------------+");
		System.out.print("Vorname: ");
		kunde.add(scan.next());
		System.out.print("Nachname: ");
		kunde.add(scan.next());
		System.out.print("PLZ: ");
		kunde.add(scan.next());
		System.out.print("Ort: ");
		kunde.add(scan.next());
		System.out.print("Strasse: ");
		kunde.add(scan.next());
		System.out.print("Email: ");
		kunde.add(scan.next());
		System.out.print("Telefon: ");
		kunde.add(scan.next());
		System.out.println("+------------------------------------+\n");
		
		return kunde;
	}
}
