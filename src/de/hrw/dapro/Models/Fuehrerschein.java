package de.hrw.dapro.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Fuehrerschein{

	private int m_kundenId;
	private String m_klasse;
	
	public Fuehrerschein(int kundenId, String klasse) {
		this.m_kundenId = kundenId;
		this.m_klasse = klasse;
	}
	
	/**
	 * Create {@link Fuehrerschein} Objects from {@link ResultSet} and store them in an {@link ArrayList}
	 * 
	 * @param rs The ResultSet
	 * @return {@link ArrayList} of {@link Fuehrerschein}
	 */
	public static ArrayList<Fuehrerschein> sqlFactory(ResultSet rs) 
	{
		ArrayList<Fuehrerschein> modell = new ArrayList<>();
		try {
			while(rs.next()) {
				modell.add(new Fuehrerschein(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modell;
	}
	
	/**
	 * Implement toString for {@link Fuehrerschein} objects
	 */
	public String toString() {
		return "Kunde #" + kundenId() + " - Klasse: " + klasse();
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
