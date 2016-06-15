package de.hrw.dapro.Models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reservierung  {

	private int m_id;
	private int m_kundenId;
	private int m_modellId;
	private Date m_beginn;
	private Date m_ende;
	
	public Reservierung(int id, int kundenId, int modellId, Date beginn, Date ende) {
		this.m_id = id;
		this.m_kundenId = kundenId;
		this.m_modellId = modellId;
		this.m_beginn = beginn;
		this.m_ende = ende;

	}

	/**
	 * Create {@link Reservierung} Objects from {@link ResultSet} and store them in an {@link ArrayList}
	 * 
	 * @param rs The ResultSet
	 * @return {@link ArrayList} of {@link Reservierung}
	 */
	public static ArrayList<Reservierung> sqlFactory(ResultSet rs) 
	{
		ArrayList<Reservierung> modell = new ArrayList<>();
		try {
			while(rs.next()) {
				modell.add(new Reservierung(rs.getInt(1), rs.getInt(2),
						rs.getInt(3), rs.getDate(4), rs.getDate(5)));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modell;
	}
	
	/**
	 * Implement toString for {@link Leihvertrag} objects
	 */
	public String toString() {
		return "#" + id() + " - Kunde: " + kundenId() + " - Modell: "
				+ modellId() + " - Beginn: " + beginn().toString() + " - Ende: "
				+ ende().toString();
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
