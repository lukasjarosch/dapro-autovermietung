package de.hrw.dapro.Models;

public class Fuehrerschein {

	private int m_kundenId;
	private String m_klasse;
	
	public Fuehrerschein(int kundenId, String klasse) {
		this.m_kundenId = kundenId;
		this.m_klasse = klasse;
	}

	/**
	 * @return the m_kundenId
	 */
	public int kundenId() {
		return m_kundenId;
	}

	/**
	 * @param m_kundenId the m_kundenId to set
	 */
	public void setKundenId(int kundenId) {
		this.m_kundenId = kundenId;
	}

	/**
	 * @return the m_klasse
	 */
	public String klasse() {
		return m_klasse;
	}

	/**
	 * @param m_klasse the m_klasse to set
	 */
	public void setKlasse(String klasse) {
		this.m_klasse = klasse;
	}
}
