package de.hrw.dapro.View;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import de.hrw.dapro.Controller.ReservierungenController;

public class ReservierungenView {

	public static void printMenu() {
		Scanner scan = new Scanner(System.in);
		boolean scanning = true;
		System.out.println("+------------------------------------+");
		System.out.println("|             Reservierungen         |");
		System.out.println("+------------------------------------+");
		System.out.println("| 0 - Zum Hauptmenü                  |");
		System.out.println("| 1 - Reservierungen anzeigen        |");
		System.out.println("| 2 - Reservierung anlegen           |");
		System.out.println("+------------------------------------+");

		while(scanning) {
			System.out.print("Auswahl: ");
			scanning = ReservierungenController.handleReservierungenMenu(scan);
		}
	}
	
	public static int authUserView() {
		Scanner scan = new Scanner(System.in);
		int userid = -1;

		System.out.println("\n+------------------------------------------+");
		System.out.println("|           Kunde authentifizieren         |");
		System.out.println("+------------------------------------------+");
		System.out.print("Kunden-ID: ");
		userid = scan.nextInt();
		if(ReservierungenController.authenticateUser(userid)) {
			System.out.println("+----------------- OK ---------------------+");
			return userid;
		}
		System.out.println("+-------------- NICHT OK ------------------+\n");
		return -1;
	}
	
	public static ArrayList<Object> addReservierung() {
		ArrayList<Object> reservierung = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int userid = authUserView();
		int autoid;
		Date start, ende;
		if(userid > 0) {
			System.out.println("\n+------------------------------------------+");
			System.out.println("|           Reservierung hinzufügen        |");
			System.out.println("+------------------------------------------+");
			System.out.println("Kunden-ID: " + userid);
			reservierung.add(userid);
			System.out.print("Auto-ID: ");
			autoid = scan.nextInt();
			reservierung.add(autoid);
			System.out.print("Begin [YYYY-MM-DD]: ");
			start = Date.valueOf(scan.next());
			reservierung.add(start);
			System.out.print("Ende [YYYY-MM-DD]: ");
			ende = Date.valueOf(scan.next());
			reservierung.add(ende);
			/*
			System.out.print("Start Kilometer: ");
			reservierung.add(scan.nextInt());
			System.out.print("Ende Kilometer: ");
			reservierung.add(scan.nextInt());
			System.out.print("Rechnungsbetrag: ");
			reservierung.add(scan.nextFloat());
			System.out.print("Bezahlt [y/n]: ");
			if(scan.next().equals("y")) {
				reservierung.add("1");
			} else { reservierung.add("0"); }
			*/
			reservierung.add("0"); // Bezahlt: FALSE
			
			System.out.println("+-------------- Wird geprüft --------------+");
			if(ReservierungenController.checkReservierung(autoid, start, ende)) {
				System.out.println("+----------------- OK ---------------------+");
				return reservierung;	
			}
			System.out.println("+----------------- NICHT OK ---------------+");
			return null;
		}
		return null;
	}
}
