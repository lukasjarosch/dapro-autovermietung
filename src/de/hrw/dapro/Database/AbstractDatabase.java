package de.hrw.dapro.Database;

import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class AbstractDatabase {
	
	protected String m_connectionString;
	protected String m_username;
	protected String m_password;
		
	/**
	 * Init the database connection
	 */
	public abstract void connect();
	
	/**
	 * Disconnect from the database
	 */
	public abstract void disconnect();
	
	/**
	 * Select all from the table
	 * 
	 * Query: 'SELECT * FROM <table>' 
	 * 
	 * @param table
	 * @return ArrayList Template...cast as needed
	 */
	public abstract ResultSet selectAll(String table);
	
	/**
	 * Insert into the database
	 * 
	 * Query: 'INSERT INTO <table> (<columns>) VALUES (<values>);'
	 * 
	 * @param table
	 * @param columns
	 * @param values
	 */
	public abstract void insert(String table, String[] columns,  ArrayList<Object> values);
	
	/**
	 * Inserts a record but locks the table.
	 * 
	 * Query: 	LOCK TABLES <table> WRITE;
	 * 			INSERT INTO <table> (<columns>) VALUES (<values>);
	 * 			SELECT LAST_INSERT_ID;
	 * 			UNLOCK TABLES;
	 * 
	 * @param table
	 * @param columns
	 * @param values
	 * @return Success state: 	>=0: Success
	 * 							<0: Fail
	 */
	public abstract int insertLocked(String table,  String[] columns,  ArrayList<Object> values);

	/**
	 * @return the connectionString
	 */
	public String connectionString() {
		return this.m_connectionString;
	}

	/**
	 * @param connectionString the connectionString to set
	 */
	public void setConnectionString(String connectionString) {
		this.m_connectionString = connectionString;
	}

	/**
	 * @return the username
	 */
	public String username() {
		return this.m_username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.m_username = username;
	}

	/**
	 * @return the password
	 */
	protected String password() {
		return this.m_password;
	}

	/**
	 * @param password the password to set
	 */
	protected void setPassword(String password) {
		this.m_password = password;
	}
	
	
	
}
