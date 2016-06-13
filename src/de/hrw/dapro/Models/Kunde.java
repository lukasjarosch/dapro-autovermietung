package de.hrw.dapro.Models;

public class Kunde {

	private int m_id;
	private String m_vorname;
	private String m_nachname;
	private int m_plz;
	private String m_ort;
	private String m_strasse;
	private String m_email;
	private String m_telNr;
	
	public Kunde(int id, String vorname, String nachname, int plz, String ort, String strasse, String email, String telNr) {
		this.m_id = id;
		this.m_vorname = vorname;
		this.m_nachname = nachname;
		this.m_plz = plz;
		this.m_ort = ort;
		this.m_strasse = strasse;
		this.m_email = email;
		this.m_telNr = telNr;
	}

	/**
	 * @return the m_id
	 */
	public int id() {
		return m_id;
	}

	/**
	 * @param m_id the m_id to set
	 */
	public void setId(int id) {
		this.m_id = id;
	}

	/**
	 * @return the m_vorname
	 */
	public String vorname() {
		return m_vorname;
	}

	/**
	 * @param m_vorname the m_vorname to set
	 */
	public void setVorname(String vorname) {
		this.m_vorname = vorname;
	}

	/**
	 * @return the m_nachname
	 */
	public String nachname() {
		return m_nachname;
	}

	/**
	 * @param m_nachname the m_nachname to set
	 */
	public void setNachname(String nachname) {
		this.m_nachname = nachname;
	}

	/**
	 * @return the m_plz
	 */
	public int plz() {
		return m_plz;
	}

	/**
	 * @param m_plz the m_plz to set
	 */
	public void setPlz(int plz) {
		this.m_plz = plz;
	}

	/**
	 * @return the m_ort
	 */
	public String ort() {
		return m_ort;
	}

	/**
	 * @param m_ort the m_ort to set
	 */
	public void setOrt(String ort) {
		this.m_ort = ort;
	}

	/**
	 * @return the m_strasse
	 */
	public String strasse() {
		return m_strasse;
	}

	/**
	 * @param m_strasse the m_strasse to set
	 */
	public void setStrasse(String strasse) {
		this.m_strasse = strasse;
	}

	/**
	 * @return the m_email
	 */
	public String email() {
		return m_email;
	}

	/**
	 * @param m_email the m_email to set
	 */
	public void setEmail(String email) {
		this.m_email = email;
	}

	/**
	 * @return the m_telNr
	 */
	public String telNr() {
		return m_telNr;
	}

	/**
	 * @param m_telNr the m_telNr to set
	 */
	public void setTelNr(String telNr) {
		this.m_telNr = telNr;
	}
}
