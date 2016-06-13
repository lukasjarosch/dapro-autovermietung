package de.hrw.dapro.Models;

/**
 * Ausstattung Model
 * 
 * @author Lukas
 */
public class Ausstattung {

	private int m_id;
	private String m_Bezeichnung;
	
	/**
	 * Konstruktor
	 * 
	 * @param id
	 * @param bezeichnung
	 */
	public Ausstattung(int id, String bezeichnung) 
	{
		this.m_id = id;
		this.m_Bezeichnung = bezeichnung;
	}

	/**
	 * @return the m_id
	 */
	public int getId() {
		return m_id;
	}

	/**
	 * @param m_id the m_id to set
	 */
	public void setId(int m_id) {
		this.m_id = m_id;
	}

	/**
	 * @return the m_Bezeichnung
	 */
	public String bezeichnung() {
		return m_Bezeichnung;
	}

	/**
	 * @param m_Bezeichnung the m_Bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.m_Bezeichnung = m_Bezeichnung;
	}
	
	 
}
