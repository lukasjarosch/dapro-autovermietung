package de.hrw.dapro.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import de.hrw.dapro.Models.Kunde;
import de.hrw.dapro.View.KundenTableView;
import de.hrw.dapro.View.KundenView;

public class KundenController {

	public static boolean handleKundenmenu(Scanner scan) {
		switch(scan.nextInt()) {
		case 0:
			return false;
		case 1:
			System.out.println("+------------------------------------+\n");
			KundenTableView.printKundenTable(ApplicationController.getInstance().databaseController().getKunden());
			break;
		case 2:
			ArrayList<Object> data = KundenView.addCustomer();
			String[] columns = {"vorname", "nachname", "plz", "ort", "strasse", "email", "telnr"};
			ApplicationController.getInstance().database().insert("kunde", columns, data);
			break;
		default:
			break;
		}
		
		return true;
	}
}
