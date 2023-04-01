package com.ineuron.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		String fileLocation = "D:\\College_Library\\src\\main\\java\\com\\ineuron\\properties\\application.properties";
		FileInputStream fis = null;
		Properties properties = new Properties();
		Connection conn = null;

		try {

			fis = new FileInputStream(fileLocation);
			properties.load(fis);
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

}
