package KHMJ.DataLayer;

import java.sql.*;

public class BaseDL {

	private Connection getDBConnection() {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/khmj";

		// Database credentials
		final String USER = "root";
		final String PASS = "";

		Connection sqlConnection = null;

		try {
			Class.forName(JDBC_DRIVER);
			sqlConnection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return sqlConnection;
	}

	public Statement GetSqlStatement() {
		Statement sqlStatement = null;

		try {
			Connection sqlConnection = getDBConnection();
			sqlStatement = sqlConnection.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sqlStatement;
	}
}
