package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {
		
		if(conn == null) {
			
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
				
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
		
		return conn;
	}
	
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();				
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
	}
	

	// carregando dados do db.properties
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs); // mandando dados arquivo db.properties para o Properties do java.

			return props;
		} catch (IOException e) {
			// exce��o criada no DBException;
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatment(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
