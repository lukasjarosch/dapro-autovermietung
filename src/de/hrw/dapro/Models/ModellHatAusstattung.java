package de.hrw.dapro.Models;

public class ModellHatAusstattung {

	private int m_modellId;
	private int m_ausstattungId;
	
	public ModellHatAusstattung(int modellId, int ausstattungId) {
		this.m_modellId = modellId;
		this.m_ausstattungId = ausstattungId;
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
	 * @return the ausstattungId
	 */
	public int ausstattungId() {
		return this.m_ausstattungId;
	}

	/**
	 * @param ausstattungId the ausstattungId to set
	 */
	public void setAusstattungId(int ausstattungId) {
		this.m_ausstattungId = ausstattungId;
	}
	
	
}
