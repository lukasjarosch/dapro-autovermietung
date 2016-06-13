package de.hrw.dapro.Models;

public class Autoart {

	private int m_id;
	private String m_art;
	
	public Autoart(int id, String art) {
		this.m_id = id;
		this.m_art = art;
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
	 * @return the art
	 */
	public String art() {
		return this.m_art;
	}

	/**
	 * @param art the art to set
	 */
	public void setArt(String art) {
		this.m_art = art;
	}
}
