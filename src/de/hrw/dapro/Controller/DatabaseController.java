package de.hrw.dapro.Controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import de.hrw.dapro.Models.Ausstattung;
import de.hrw.dapro.Models.Auto;
import de.hrw.dapro.Models.Autoart;
import de.hrw.dapro.Models.Automodell;
import de.hrw.dapro.Models.Fuehrerschein;
import de.hrw.dapro.Models.Kunde;
import de.hrw.dapro.Models.Leihvertrag;
import de.hrw.dapro.Models.ModellHatAusstattung;
import de.hrw.dapro.Models.Reservierung;


public class DatabaseController {
	
	/**
	 * Select all entries from {@link Ausstattung} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<Ausstattung> getAusstattungen()
	{
		ResultSet rs = ApplicationController.getInstance().database().selectAll("ausstattungen");
		return Ausstattung.sqlFactory(rs);
	}

	/**
	 * Select all entries from {@link Auto} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<Auto> getAutos()
	{
		ResultSet rs = ApplicationController.getInstance().database().selectAll("auto");
		return Auto.sqlFactory(rs);
	}

	/**
	 * Select all entries from {@link Autoart} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<Autoart> getAutoarten()
	{
		ResultSet rs = ApplicationController.getInstance().database().selectAll("autoarten");
		return Autoart.sqlFactory(rs);
	}

	/**
	 * Select all entries from {@link Automodell} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<Automodell> getAutomodelle()
	{
		ResultSet rs = ApplicationController.getInstance().database().selectAll("automodell");
		return Automodell.sqlFactory(rs);
	}

	/**
	 * Select all entries from {@link Fuehrerschein} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<Fuehrerschein> getFuehrerscheine()
	{
		ResultSet rs = ApplicationController.getInstance().database().selectAll("fuehrerscheine");
		return Fuehrerschein.sqlFactory(rs);
	}

	/**
	 * Select all entries from {@link Kunde} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<Kunde> getKunden()
	{
		ResultSet rs = ApplicationController.getInstance().database().selectAll("kunde");
		return Kunde.sqlFactory(rs);
	}

	/**
	 * Select all entries from {@link Leihvertrag} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<Leihvertrag> getLeihvertraege()
	{
		ResultSet rs = ApplicationController.getInstance().database().selectAll("leihvertrag");
		return Leihvertrag.sqlFactory(rs);
	}

	/**
	 * Select all entries from {@link ModellHatAusstattung} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<ModellHatAusstattung> getModellHatAusstattung()
	{
		ResultSet rs = ApplicationController.getInstance().database().selectAll("modhatausst");
		return ModellHatAusstattung.sqlFactory(rs);
	}

	/**
	 * Select all entries from {@link Reservierung} and return the models in an {@link ArrayList}
	 * @return {@link ArrayList}
	 */
	public ArrayList<Reservierung> getReservierungen()
	{	
		ResultSet rs = ApplicationController.getInstance().database().selectAll("reservierung");
		return Reservierung.sqlFactory(rs);
	}
}
