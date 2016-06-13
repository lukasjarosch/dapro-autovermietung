package de.hrw.dapro.Models;

import java.sql.Date;

public class Reservierung {

	private int m_id;
	private int m_kundenId;
	private int m_modellId;
	private Date m_beginn;
	private Date m_ende;
	
	public Reservierung(int id, int kundenId, int modellId, Date beginn, Date ende) {
		this.m_id = id;
		this.m_kundenId = kundenId;
		this.m_kundenId = modellId;
		this.m_beginn = beginn;
		this.m_ende = ende;
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
	 * @return the modellId
	 */
	public int modellId() {
		return this.m_modellId;
	}

	/**
	 * @param modellId the modellId to set
	 */
	public void setModellId(int modellId) {
		this.m_modellId = modellId;
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
}
