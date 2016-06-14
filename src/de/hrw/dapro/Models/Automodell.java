package de.hrw.dapro.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Automodell implements Comparable<Automodell> {
	
	private int m_id;
	private int m_autoartId;
	private String m_hersteller;
	private String m_bezeichnung;
	private int m_sitzplaetze;
	private float m_kw;
	private String m_treibstoff;
	private float m_preisTag;
	private float m_preisKm;
	private int m_achsen;
	private int m_ladeVolumen;
	private int m_zuladung;
	private String m_fuehrerschein;
	private float m_guete = 0.0f;
	

	public Automodell(int id,  String bezeichnung, String hersteller, int autoartId, 
			 int sitzplaetze, float kw, String treibstoff,
			float preisTag, float preisKm, int achsen, int ladeVolumen,
			int zuladung, String fuehrerschein
			) 
	{
		this.m_id = id;		
		this.m_hersteller = hersteller;
		this.m_autoartId = autoartId;
		this.m_bezeichnung = bezeichnung;
		this.m_sitzplaetze = sitzplaetze;
		this.m_kw = kw;
		this.m_treibstoff = treibstoff;
		this.m_preisTag = preisTag;
		this.m_preisKm = preisKm;
		this.m_achsen = achsen;
		this.m_ladeVolumen = ladeVolumen;
		this.m_zuladung = zuladung;
		this.m_fuehrerschein = fuehrerschein;
	}

	/**
	 * Vergleicht zwei Automodelle anhand ihrer internen Güte
	 * 
	 * @return int 	<0: compare ist besser
	 * 				=0: beide Modelle gleich
	 * 				>0: compare ist schlechter
	 */
	@Override
	public int compareTo(Automodell compare) {
		return ((int) (this.guete() - compare.guete()) * 100);
	}
	
	/**
	 * Create {@link Automodell} Objects from {@link ResultSet} and store them in an {@link ArrayList}
	 * 
	 * @param rs The ResultSet
	 * @return {@link ArrayList} of {@link Automodell}
	 */
	public static ArrayList<Automodell> sqlFactory(ResultSet rs) 
	{
		ArrayList<Automodell> modell = new ArrayList<>();
		try {
			while(rs.next()) {
				modell.add(new Automodell(rs.getInt(1), rs.getString(2),
						 rs.getString(3), rs.getInt(4),
						rs.getInt(5), rs.getFloat(6),
						rs.getString(7), rs.getFloat(8),
						rs.getFloat(9), rs.getInt(10),
						rs.getInt(11), rs.getInt(12),
						rs.getString(13)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modell;
	}
	
	/**
	 * Implement toString for {@link Automodell} objects
	 */
	public String toString() {
		return "#" + id() + " - Autoart: " 
				+ autoartId() + " - "
				+ hersteller() + " - "
				+ bezeichnung() + " - Sitze: " 
				+ sitzplaetze() + " - "
				+ kw() + "kW - " 
				+ treibstoff() + " - "
				+ preisTag() + "€/Tag - " 
				+ preisKm() + "€/km - "
				+ achsen() + " Achsen - "
				+ ladeVolumen() + " Ladevolumen - "
				+ zuladung() + " Zuladung - Führerschein: "
				+ fuehrerschein();
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
	 * @return the autoartId
	 */
	public int autoartId() {
		return this.m_autoartId;
	}

	/**
	 * @param autoartId the autoartId to set
	 */
	public void setAutoartId(int autoartId) {
		this.m_autoartId = autoartId;
	}

	/**
	 * @return the hersteller
	 */
	public String hersteller() {
		return this.m_hersteller;
	}

	/**
	 * @param hersteller the hersteller to set
	 */
	public void setHersteller(String hersteller) {
		this.m_hersteller = hersteller;
	}

	/**
	 * @return the bezeichnung
	 */
	public String bezeichnung() {
		return this.m_bezeichnung;
	}

	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.m_bezeichnung = bezeichnung;
	}

	/**
	 * @return the sitzplaetze
	 */
	public int sitzplaetze() {
		return this.m_sitzplaetze;
	}

	/**
	 * @param sitzplaetze the sitzplaetze to set
	 */
	public void setSitzplaetze(int sitzplaetze) {
		this.m_sitzplaetze = sitzplaetze;
	}

	/**
	 * @return the kw
	 */
	public float kw() {
		return this.m_kw;
	}

	/**
	 * @param kw the kw to set
	 */
	public void setKw(float kw) {
		this.m_kw = kw;
	}

	/**
	 * @return the treibstoff
	 */
	public String treibstoff() {
		return this.m_treibstoff;
	}

	/**
	 * @param treibstoff the treibstoff to set
	 */
	public void setTreibstoff(String treibstoff) {
		this.m_treibstoff = treibstoff;
	}

	/**
	 * @return the preisTag
	 */
	public float preisTag() {
		return this.m_preisTag;
	}

	/**
	 * @param preisTag the preisTag to set
	 */
	public void setPreisTag(float preisTag) {
		this.m_preisTag = preisTag;
	}

	/**
	 * @return the preisKm
	 */
	public float preisKm() {
		return this.m_preisKm;
	}

	/**
	 * @param preisKm the preisKm to set
	 */
	public void setPreisKm(float preisKm) {
		this.m_preisKm = preisKm;
	}

	/**
	 * @return the achsen
	 */
	public int achsen() {
		return this.m_achsen;
	}

	/**
	 * @param achsen the achsen to set
	 */
	public void setAchsen(int achsen) {
		this.m_achsen = achsen;
	}

	/**
	 * @return the ladeVolumen
	 */
	public int ladeVolumen() {
		return this.m_ladeVolumen;
	}

	/**
	 * @param ladeVolumen the ladeVolumen to set
	 */
	public void setLadeVolumen(int ladeVolumen) {
		this.m_ladeVolumen = ladeVolumen;
	}

	/**
	 * @return the zuladung
	 */
	public int zuladung() {
		return this.m_zuladung;
	}

	/**
	 * @param zuladung the zuladung to set
	 */
	public void setZuladung(int zuladung) {
		this.m_zuladung = zuladung;
	}

	/**
	 * @return the fuehrerschein
	 */
	public String fuehrerschein() {
		return this.m_fuehrerschein;
	}

	/**
	 * @param fuehrerschein the fuehrerschein to set
	 */
	public void setFuehrerschein(String fuehrerschein) {
		this.m_fuehrerschein = fuehrerschein;
	}
	

	/**
	 * @return the guete
	 */
	public float guete() {
		return this.m_guete;
	}

	/**
	 * @param guete the guete to set
	 */
	public void setGuete(float guete) {
		this.m_guete = guete;
	}

}
