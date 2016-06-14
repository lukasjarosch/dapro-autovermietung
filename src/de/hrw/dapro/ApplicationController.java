package de.hrw.dapro;

import de.hrw.dapro.Database.AbstractDatabase;

public class ApplicationController {
	
	private static ApplicationController m_instance = null;	
	private static AbstractDatabase m_databaseConnection = null;
	
	/**
	 * Private constructor to implement simple singleton
	 */
	private ApplicationController() {};
	
	/**
	 * Returns the instance of the {@link ApplicationController} 
	 * 
	 * @return {@link ApplicationController}
	 */
	public static synchronized ApplicationController getInstance() {
		if(m_instance == null) {
			m_instance = new ApplicationController();
		}
		return m_instance;
	}

	/**
	 * @return the m_databaseConnection
	 */
	public  AbstractDatabase database() {
		return m_databaseConnection;
	}

	/**
	 * @param m_databaseConnection the m_databaseConnection to set
	 */
	public void setDatabase(
			AbstractDatabase m_databaseConnection) {
		ApplicationController.m_databaseConnection = m_databaseConnection;
	}
	
}
