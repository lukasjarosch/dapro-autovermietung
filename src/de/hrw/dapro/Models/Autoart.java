package de.hrw.dapro.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Autoart {

	private int m_id;
	private String m_art;
	
	public Autoart(int id, String art) {
		this.m_id = id;
		this.m_art = art;
	}
	
	/**
	 * Create {@link Autoart} Objects from {@link ResultSet} and store them in an {@link ArrayList}
	 * 
	 * @param rs The ResultSet
	 * @return {@link ArrayList} of {@link Autoart}
	 */
	public static ArrayList<Autoart> sqlFactory(ResultSet rs) 
	{
		ArrayList<Autoart> autoart = new ArrayList<>();
		try {
			while(rs.next()) {
				autoart.add(new Autoart(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autoart;
	}
	
	/**
	 * Implement toString for {@link Autoart} objects
	 */
	public String toString() {
		return "#" + id() + " - " 
				+ art();
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
