package de.hrw.dapro.Controller;

import de.hrw.dapro.Database.AbstractDatabase;

public class ApplicationController {
	
	private static ApplicationController m_instance = null;	
	private static AbstractDatabase m_databaseConnection = null;
	private DatabaseController m_databaseController = null;
	private boolean m_running = true;
	
	/**
	 * Private constructor to implement simple singleton
	 */
	private ApplicationController() {
		setDatabaseController(new DatabaseController());
	};
	
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
	 * The main application loop
	 */
	public void applicationLoop() {
		while(m_running == true) {
			MenuController.printMainMenu();
		}
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
	public void setDatabase(AbstractDatabase m_databaseConnection) {
		ApplicationController.m_databaseConnection = m_databaseConnection;
	}
	
	/**
	 * @return the databaseController
	 */
	public DatabaseController databaseController() {
		return this.m_databaseController;
	}

	/**
	 * @param databaseController the databaseController to set
	 */
	public void setDatabaseController(DatabaseController databaseController) {
		this.m_databaseController = databaseController;
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return this.m_running;
	}

	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.m_running = running;
	}
	
}
