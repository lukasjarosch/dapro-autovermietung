package de.hrw.dapro.Controller;

import de.hrw.dapro.Database.AbstractDatabase;
import de.hrw.dapro.View.MainWindow;

public class ApplicationController {
	
	private static ApplicationController m_instance = null;	
	private static AbstractDatabase m_databaseConnection = null;
	private static MainWindow m_mainWindow = null;
	private DatabaseController m_databaseController = null;
	
	/**
	 * Private constructor to implement simple singleton
	 */
	private ApplicationController() {
		setMainWindow(MainWindow.getInstance());
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
	 * @return the m_mainWindow
	 */
	public MainWindow mainWindow() {
		return m_mainWindow;
	}
	
	/**
	 * @param window The MainWindow to set
	 */
	public void setMainWindow(MainWindow window) {
		ApplicationController.m_mainWindow = window;
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
	
}
