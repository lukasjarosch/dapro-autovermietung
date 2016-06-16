package de.hrw.dapro.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import de.hrw.dapro.Models.Kunde;
import de.hrw.dapro.Models.Leihvertrag;
import de.hrw.dapro.View.ReservierungTableView;
import de.hrw.dapro.View.ReservierungenView;

public class ReservierungenController {
	
	public static boolean authenticateUser(int userid) {
		ArrayList<Kunde> kunden = ApplicationController.getInstance().databaseController().getKunden();
		for(Kunde kunde : kunden) {
			if(kunde.id() == userid) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean checkReservierung(int autoid, Date start, Date ende) {
		ArrayList<Leihvertrag> vertraege = ApplicationController.getInstance().databaseController().getLeihvertraege();
		boolean available = true;

		for(Leihvertrag vertrag : vertraege) {
			if(vertrag.autoId() == autoid) {
				if(vertrag.ende().after(start)) {
					System.out.println("ENDE alter: " + vertrag.ende().toString());
					System.out.println("START neuer: " + start.toString());
					return false;
				}
			} 
		}
		return available;
	}

	public static boolean handleReservierungenMenu(Scanner scan) {
	switch (scan.nextInt()) {
		case 0:
			return false;
		case 1:
			System.out.println("+------------------------------------+\n");
			ReservierungTableView.printKundenTable(ApplicationController.getInstance().databaseController().getLeihvertraege());
			break;
		case 2:
			ArrayList<Object> data = ReservierungenView.addReservierung();
			if(data == null) {
				ReservierungenView.printMenu();
				break;
			}
			String[] columns = {"KundeID", "AutoID", "Beginn", "Ende", "bezahlt"};
			ApplicationController.getInstance().database().insertLocked("leihvertrag", columns, data);
			break;
		default:
			break;
		}
		return true;
	}
}
