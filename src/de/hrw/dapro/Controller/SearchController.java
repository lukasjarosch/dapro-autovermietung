package de.hrw.dapro.Controller;

import java.util.ArrayList;
import java.util.Collections;

import de.hrw.dapro.Models.Ausstattung;
import de.hrw.dapro.Models.Autoart;
import de.hrw.dapro.Models.Automodell;
import de.hrw.dapro.Models.ModellHatAusstattung;

public class SearchController {

	private ArrayList<Automodell> m_models = new ArrayList<>();
	private ArrayList<Autoart> m_arten = new ArrayList<>();
	private ArrayList<ModellHatAusstattung> m_modHatAusst = new ArrayList<>();
	private ArrayList<Ausstattung> m_ausstattung = new ArrayList<>();
	private ApplicationController m_application = ApplicationController.getInstance();
	
	public SearchController() {
		m_models = m_application.databaseController().getAutomodelle();
		m_arten = m_application.databaseController().getAutoarten();
		m_modHatAusst = m_application.databaseController().getModellHatAusstattung();
		m_ausstattung = m_application.databaseController().getAusstattungen();
	}
	
	public ArrayList<Automodell> getOrderedData() {
		Collections.sort(m_models);
		return m_models;
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
