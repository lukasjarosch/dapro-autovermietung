package de.hrw.dapro.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModellHatAusstattung {

	private int m_modellId;
	private int m_ausstattungId;
	
	public ModellHatAusstattung(int modellId, int ausstattungId) {
		this.m_modellId = modellId;
		this.m_ausstattungId = ausstattungId;
	}
	
	/**
	 * Create {@link ModellHatAusstattung} Objects from {@link ResultSet} and store them in an {@link ArrayList}
	 * 
	 * @param rs The ResultSet
	 * @return {@link ArrayList} of {@link ModellHatAusstattung}
	 */
	public static ArrayList<ModellHatAusstattung> sqlFactory(ResultSet rs) 
	{
		ArrayList<ModellHatAusstattung> modell = new ArrayList<>();
		try {
			while(rs.next()) {
				modell.add(new ModellHatAusstattung(rs.getInt(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modell;
	}
	
	/**
	 * Implement toString for {@link ModellHatAusstattung} objects
	 */
	public String toString() {
		return "Modell:" + modellId() + " - Ausstattung: " 
				+ ausstattungId();
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
