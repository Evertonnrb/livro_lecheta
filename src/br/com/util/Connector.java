package br.com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	
	public static Connection connectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/livro","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
