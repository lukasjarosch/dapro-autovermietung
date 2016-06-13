package de.hrw.dapro.Models;

import java.sql.Date;

public class Leihvertrag {

	private int m_id;
	private int m_kundenId;
	private int m_autoId;
	private Date m_beginn;
	private Date m_ende;
	private int m_startKm;
	private int m_endKm;
	private float m_rechnungsBetrag;
	private boolean m_bezahlt;
	
	public Leihvertrag(int id, int kundenId, int autoId, Date beginn, 
			Date ende, int startKm, int endKm, float rechnungsBetrag, boolean bezahlt) 
	{
		this.m_id = id;
		this.m_kundenId = kundenId;
		this.m_autoId = autoId;
		this.m_beginn = beginn;
		this.m_ende = ende;
		this.m_startKm = startKm;
		this.m_endKm = endKm;
		this.m_rechnungsBetrag = rechnungsBetrag;
		this.m_bezahlt = bezahlt;
	}
	
	/**
	 * @return the id
	 */
	public int id() {
		return this.m_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.m_id = id;
	}

	/**
	 * @return the kundenId
	 */
	public int kundenId() {
		return this.m_kundenId;
	}

	/**
	 * @param kundenId the kundenId to set
	 */
	public void setKundenId(int kundenId) {
		this.m_kundenId = kundenId;
	}

	/**
	 * @return the autoId
	 */
	public int autoId() {
		return this.m_autoId;
	}

	/**
	 * @param autoId the autoId to set
	 */
	public void setAutoId(int autoId) {
		this.m_autoId = autoId;
	}

	/**
	 * @return the beginn
	 */
	public Date beginn() {
		return this.m_beginn;
	}

	/**
	 * @param beginn the beginn to set
	 */
	public void setBeginn(Date beginn) {
		this.m_beginn = beginn;
	}

	/**
	 * @return the ende
	 */
	public Date ende() {
		return this.m_ende;
	}

	/**
	 * @param ende the ende to set
	 */
	public void setEnde(Date ende) {
		this.m_ende = ende;
	}

	/**
	 * @return the startKm
	 */
	public int startKm() {
		return this.m_startKm;
	}

	/**
	 * @param startKm the startKm to set
	 */
	public void setStartKm(int startKm) {
		this.m_startKm = startKm;
	}

	/**
	 * @return the endKm
	 */
	public int endKm() {
		return this.m_endKm;
	}

	/**
	 * @param endKm the endKm to set
	 */
	public void setEndKm(int endKm) {
		this.m_endKm = endKm;
	}

	/**
	 * @return the rechnungsBetrag
	 */
	public float rechnungsBetrag() {
		return this.m_rechnungsBetrag;
	}

	/**
	 * @param rechnungsBetrag the rechnungsBetrag to set
	 */
	public void setRechnungsBetrag(float rechnungsBetrag) {
		this.m_rechnungsBetrag = rechnungsBetrag;
	}

	/**
	 * @return the bezahlt
	 */
	public boolean bezahlt() {
		return this.m_bezahlt;
	}

	/**
	 * @param bezahlt the bezahlt to set
	 */
	public void setBezahlt(boolean bezahlt) {
		this.m_bezahlt = bezahlt;
	}


}
