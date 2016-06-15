package de.hrw.dapro.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Ausstattung Model
 * 
 * @author Lukas
 */
public class Ausstattung{

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
	 * Create {@link Ausstattung} Objects from {@link ResultSet} and store them in an {@link ArrayList}
	 * 
	 * @param rs The ResultSet
	 * @return {@link ArrayList} of {@link Ausstattung}
	 */
	public static ArrayList<Ausstattung> sqlFactory(ResultSet rs) 
	{
		ArrayList<Ausstattung> ausstattung = new ArrayList<>();
		try {
			while(rs.next()) {
				ausstattung.add(new Ausstattung(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ausstattung;
	}
	
	/**
	 * Implement toString for {@link Ausstattung} objects
	 */
	public String toString() {
		return "#" + id() + " - " 
				+ bezeichnung();
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
