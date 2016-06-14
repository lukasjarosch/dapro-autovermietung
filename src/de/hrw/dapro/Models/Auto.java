package de.hrw.dapro.Models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

import de.hrw.dapro.Database.MysqlDatabase;

public class Auto {

	private int m_id;
	private String m_kennzeichen;
	private int m_kmStand;
	private Date m_tuev;
	private Date m_kaufDatum;
	private int m_modellId;

	/**
	 * Constructor 
	 * 
	 * @param id
	 * @param kennzeichen
	 * @param kmStand
	 * @param tuev
	 * @param kaufDatum
	 * @param modellId
	 */
	public Auto(int id, String kennzeichen, int kmStand, Date tuev, Date kaufDatum, int modellId) {
		this.m_id = id;
		this.m_kennzeichen = kennzeichen;
		this.m_kmStand = kmStand;
		this.m_tuev = tuev;
		this.m_kaufDatum = kaufDatum;
		this.m_modellId = modellId;
	}
	
	/**
	 * Create {@link Auto} Objects from {@link ResultSet} and store them in an {@link ArrayList}
	 * 
	 * @param rs The Resultset
	 * @return {@link ArrayList} of {@link Auto}
	 */
	public static ArrayList<Auto> sqlFactory(ResultSet rs) 
	{
		ArrayList<Auto> autos = new ArrayList<>();
		try {
			while(rs.next()) {
					autos.add(new Auto(rs.getInt(1), rs.getString(2), 
							rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autos;
	}
	
	/**
	 * Implement toString for {@link Auto} objects
	 */
	public String toString() {
		return "#" + id() + " - " 
				+ kennzeichen() + " - " 
				+ kmStand() + "km - Tüv: " 
				+ tuev().toString() + " - Kaufdatum: " 
				+ kaufDatum().toString() + " - Modell: " 
				+ modellId();
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
	 * @return the m_kennzeichen
	 */
	public String kennzeichen() {
		return m_kennzeichen;
	}

	/**
	 * @param m_kennzeichen the m_kennzeichen to set
	 */
	public void setKennzeichen(String kennzeichen) {
		this.m_kennzeichen = kennzeichen;
	}

	/**
	 * @return the m_kmStand
	 */
	public int kmStand() {
		return m_kmStand;
	}

	/**
	 * @param m_kmStand the m_kmStand to set
	 */
	public void setKmStand(int kmStand) {
		this.m_kmStand = kmStand;
	}

	/**
	 * @return the m_tuev
	 */
	public Date tuev() {
		return m_tuev;
	}

	/**
	 * @param m_tuev the m_tuev to set
	 */
	public void setTuev(Date tuev) {
		this.m_tuev = tuev;
	}

	/**
	 * @return the m_kaufDatum
	 */
	public Date kaufDatum() {
		return m_kaufDatum;
	}

	/**
	 * @param m_kaufDatum the m_kaufDatum to set
	 */
	public void setKaufDatum(Date kaufDatum) {
		this.m_kaufDatum = kaufDatum;
	}

	/**
	 * @return the m_modellId
	 */
	public int modellId() {
		return m_modellId;
	}

	/**
	 * @param m_modellId the m_modellId to set
	 */
	public void setM_modellId(int m_modellId) {
		this.m_modellId = m_modellId;
	}
}
