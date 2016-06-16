package de.hrw.dapro.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import de.hrw.dapro.Models.Ausstattung;
import de.hrw.dapro.Models.Autoart;
import de.hrw.dapro.Models.Automodell;
import de.hrw.dapro.Models.ModellHatAusstattung;
import de.hrw.dapro.View.AutomodellTableView;
import sun.print.resources.serviceui;

public class SearchController {

	private ArrayList<Automodell> m_models = new ArrayList<>();
	private ArrayList<Autoart> m_arten = new ArrayList<>();
	private ApplicationController m_application = ApplicationController.getInstance();
	
	public SearchController() {
		reset();
	}
	
	public void reset() {
		m_models = m_application.databaseController().getAutomodelle();
		m_arten = m_application.databaseController().getAutoarten();
	}

	
	public static boolean handleSearch(SearchController search, Scanner scan) {
		switch (scan.nextInt()) {
		case 0:
			System.out.println("\n+----------------- SUCHE BEENDET ---------------------+\n");
			AutomodellTableView.printTable(search.getOrderedData());
			return false;
		case 1:
			System.out.print("Bezeichnung: ");
			search.addBezeichnungSelector(scan.next());
			break;
		case 2:
			System.out.print("Hersteller: ");
			search.addHerstellerSelector(scan.next().split(","));
			break;
		case 3:
			ArrayList<Autoart> arten = ApplicationController.getInstance().databaseController().getAutoarten();
			String choices = "";
			for(Autoart art: arten) {
				choices += art.art() + ", ";
			}
			choices = choices.substring(0, choices.length()-2);
			System.out.print("Autoart [" + choices + "]: ");
			search.addAutoartSelector(scan.next().split(","));
			break;
		case 4:
			System.out.print("Treibstoff: ");
			search.addTreibstoffSelector(scan.next().split(","));
			break;
		case 5:
			System.out.print("Max. €/Tag: ");
			search.addPreisTagSelector(scan.nextInt());
			break;
		case 6:
			System.out.print("Max. €/kM: ");
			search.addPreisKmSelector(scan.nextInt());
			break;
		case 7:
			System.out.print("Min. Sitzplätze: ");
			search.addSitzplaetzeSelector(scan.nextInt());
			break;
		default:
			break;
		}
		return true;
	}


	public ArrayList<Automodell> getOrderedData() {
		Collections.sort(m_models);
		Collections.reverse(m_models);
		return m_models;
	}
	
	public void addBezeichnungSelector(String bezeichnung) {
		for(Automodell tmp : m_models) {
			if(tmp.bezeichnung().toLowerCase().contains(bezeichnung.toLowerCase())) {
				tmp.setGuete(tmp.guete() + 1);
			}
		}
	}

	public void addHerstellerSelector(String[] hersteller) {
		for(Automodell tmp : m_models) {
			for(String selector : hersteller) {
				if(tmp.hersteller().equals(selector)) {
					tmp.setGuete(tmp.guete() + 1);
				}
			}
		}
	}
	
	public void addTreibstoffSelector(String[] treibstoff) {
		for(Automodell tmp : m_models) {
			for(String selector : treibstoff) {
				if(tmp.treibstoff().equals(selector)) {
					tmp.setGuete(tmp.guete() + 1);
				}
			}
		}
	}
	
	public void addPreisTagSelector(float maxPrice) {
		for(Automodell tmp : m_models) {
			if(tmp.preisTag() <= maxPrice) {
				tmp.setGuete(tmp.guete() + 1);
			}
		}
	}
	
	public void addPreisKmSelector(float maxPrice) {
		for(Automodell tmp : m_models) {
			if(tmp.preisKm() <= maxPrice) {
				tmp.setGuete(tmp.guete() + 1);
			}
		}
	}
	
	public void addKwSelector(int maxKw) {
		for(Automodell tmp : m_models) {
			if(tmp.kw() <= maxKw) {
				tmp.setGuete(tmp.guete() + 1);
			}
		}
	}
	
	public void addAchsenSelector(int maxAchsen) {
		for(Automodell tmp : m_models) {
			if(tmp.achsen() <= maxAchsen) {
				tmp.setGuete(tmp.guete() + 1);
			}
		}
	}
	
	public void addSitzplaetzeSelector(int minSitzplaetze) {
		for(Automodell tmp : m_models) {
			if(tmp.sitzplaetze() >= minSitzplaetze) {
				tmp.setGuete(tmp.guete() + 1);
			}
		}
	}

	public void addLadevolumenSelector(int minLadeVolumen) {
		for(Automodell tmp : m_models) {
			if(tmp.ladeVolumen() >= minLadeVolumen) {
				tmp.setGuete(tmp.guete() + 1);
			}
		}
	}
	
	public void addAutoartSelector(String[] autoarten) {
		ArrayList<Integer> matches = new ArrayList<>();

		for(Autoart art : m_arten) {
			for(String selector : autoarten) {
				if(art.art().equals(selector)) {
					matches.add(art.id());
				}
			}
		}
		
		for(Automodell tmp : m_models) {
			for(int id : matches) {
				if(tmp.autoartId() == id) {
					tmp.setGuete(tmp.guete() + 1);
				}
			}
		}
	}
	
	public void addZuladungSelector(int minZuladung) {
		for(Automodell tmp : m_models) {
			if(tmp.zuladung() >= minZuladung) {
				tmp.setGuete(tmp.guete() + 1);
			}
		}
	}
	
	public void addFuehrerscheinSelector(String[] klassen) {
		for(Automodell tmp : m_models) {
			for(String selector : klassen) {
				if(tmp.fuehrerschein().equals(selector)) {
					tmp.setGuete(tmp.guete() + 1);
				}
			}
		}
		
	}
}
