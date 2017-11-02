package br.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	
	public BaseDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://127.0.0.1/livro";
		Connection con = DriverManager.getConnection(url,"root","");
		return con;
	}
	
	public static void main(String[] args) {
		BaseDao baseDao = new BaseDao();
		try {
			Connection con = baseDao.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
