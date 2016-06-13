package de.hrw.dapro.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class MysqlDatabase extends AbstractDatabase {
	
	private Connection m_connection = null;

	@Override
	public void connect(String connectionString, String username,
			String password) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			if(!connectionString.isEmpty()) {
				setConnection(DriverManager.getConnection(connectionString, username, password));
			}
		} catch (Exception e) {
			System.out.println("[SQL-ERROR]: Datenbankverbindung konnte nicht aufgebaut werden");
			e.printStackTrace();
		}
	}

	@Override
	public void disconnect() {
		try {
			if(!connection().isClosed() && connection() != null) {			
				connection().close();			
			}
		} catch (SQLException e) {
			System.out.println("[SQL-ERROR]: Cannot close SQL connection. Too bad!");
		}		
	}

	@Override
	public ResultSet selectAll(String table) {
		String stmt = "SELECT * FROM " + table + ";";
		try {			
			PreparedStatement ps = connection().prepareStatement(stmt);
			return ps.executeQuery();
		} catch (Exception e) {
			System.out.println("[SQL-ERROR]: Unable to execute prepared statement: " + stmt);			
			return null;
		}
	}

	@Override
	public void insert(String table, String[] columns, String[] values) {		
		String cols = String.join(",", Arrays.asList(columns));
		String vals = String.join(",", Arrays.asList(values));
		String stmt = "INSERT INTO " + table + " (" + cols + ") VALUES (" + vals + ");"; 
		try {
			PreparedStatement ps;
			ps = connection().prepareStatement(stmt);
			ps.executeUpdate();			
		} catch (Exception e) {
			System.out.println("[SQL-ERROR]: Unable to execute INSERT query");
		}
	}

	@Override
	public int insertLocked(String table,  String[] columns, String[] values) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the connection
	 */
	public Connection connection() {
		return this.m_connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.m_connection = connection;
	}

}
