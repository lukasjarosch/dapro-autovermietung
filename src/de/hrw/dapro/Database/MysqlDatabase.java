package de.hrw.dapro.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;


public class MysqlDatabase extends AbstractDatabase {
	
	private Connection m_connection = null;
	
	public MysqlDatabase(String connectionString, String username, String password) {
		setConnectionString(connectionString);
		setUsername(username);
		setPassword(password);
	}

	@Override
	public void connect() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			if(!connectionString().isEmpty()) {
				setConnection(DriverManager.getConnection(connectionString(), username(), password()));
				System.out.println("[SQL]: Connection established to " + connectionString());
			}
		} catch (Exception e) {
			System.out.println("[SQL-ERROR]: Datenbankverbindung konnte nicht aufgebaut werden");
			e.printStackTrace();
		}
	}

	@Override
	public void disconnect() {
		try {
			if(connection() != null && !connection().isClosed()) {			
				connection().close();	
				System.out.println("[SQL]: Connection closed");
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
	
	/**
	 * 
	 * @param stmt
	 * @param values
	 * @return
	 * @throws SQLException
	 */
	private PreparedStatement setValues(PreparedStatement stmt, ArrayList<Object> values) throws SQLException {
		for(int i=0; i < values.size(); i++) {
			if(values.get(i).getClass().equals(String.class)) {
				stmt.setString(i+1, (String) values.get(i));
			} else if (values.get(i).getClass().equals(Date.class)) {
				stmt.setDate(i+1, (Date)values.get(i));
			} else if (values.get(i).getClass().equals(Integer.class)) {
				stmt.setInt(i+1, (Integer)values.get(i));
			} else if (values.get(i).getClass().equals(Float.class)) {
				stmt.setFloat(i+1, (Float)values.get(i));
			}
		}
		return stmt;
	}
	
	/**
	 * 
	 * @param count
	 * @return
	 */
	private String setPlaceholders(int count) {
		String placeholders = new String(new char[count]).replace("\0", "?,");
		placeholders = placeholders.substring(0, placeholders.length()-1);
		return placeholders;
	}

	
	@Override
	public void insert(String table, String[] columns, ArrayList<Object> values) {		
		String cols = String.join(",", Arrays.asList(columns));
		String placeholders = setPlaceholders(values.size());
		
		String stmt = "INSERT INTO " + table + " (" + cols + ") VALUES (" + placeholders + ");";
		
		try {
			PreparedStatement ps = connection().prepareStatement(stmt);
			ps = setValues(ps, values);			
			ps.executeUpdate();
			System.out.println("[SQL]: Inserted values into `" + table + "`");
		} catch (Exception e) {
			System.out.println("[SQL-ERROR]: Unable to execute INSERT query");
			e.printStackTrace();
		}
	}

	@Override
	public int insertLocked(String table,  String[] columns, ArrayList<Object> values) {
		String lock = "LOCK TABLES " + table + " WRITE;";
		String cols = String.join(",", Arrays.asList(columns));
		String placeholders = setPlaceholders(values.size());
		String stmt = "INSERT INTO " + table + " (" + cols + ") VALUES (" + placeholders + ");";
		String select = "SELECT LAST_INSERT_ID();";
		String unlock = "UNLOCK TABLES;";
		int id = -1;
		
		try {
			connection().setAutoCommit(false);
			System.out.println("[SQL]: ----- Begin transaction -----");
			
			// Lock table
			Statement s = connection().createStatement();
			s.executeQuery(lock);
			System.out.println("[SQL]: LOCK TABLE `" + table + "`");
			
			// Prepared statment
			PreparedStatement ps = connection().prepareStatement(stmt);
			ps = setValues(ps, values);
			ps.executeUpdate();
			System.out.println("[SQL]: INSERTED values into `" + table + "`");
			
			// Get inserted ID
			ResultSet rs = s.executeQuery(select);
			rs.next();
			id = rs.getInt(1);
			System.out.println("[SQL]: INSERTED ID: " + id);
			
			// Commit and unlock
			connection().commit();
			s.executeQuery(unlock);
			System.out.println("[SQL]: UNLOCK TABLE `" + table + "`");
			connection().setAutoCommit(true);
			System.out.println("[SQL]: ----- End transaction -----");
			
		} catch (SQLException e) {
			System.out.println("[SQL-ERROR]: Unable to execute locked INSERT query");
			e.printStackTrace();
		}
		
		return id;
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
