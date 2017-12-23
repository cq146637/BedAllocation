package com.keshe.tool;

import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Connmethod {
	private final static String URL = "jdbc:mysql://bdm290150513.my3w.com:3306/bdm290150513_db?useSSL=false";
	private final static String USERNAME = "bdm290150513";
	private final static String PASSWORD = "mysql123";
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private Connection conn = null;
	public Connmethod(){
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("«˝∂Øº”‘ÿ ß∞‹£°");
		}
	}
	public Connection createConn(){
		try {
			conn  = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
		}
		return conn;
	}
	public boolean executeUpdate(String sql){
		boolean rs = true;
		if(conn==null){
			createConn();
		}
		try {
			Statement state = (Statement) conn.createStatement();
			state.executeUpdate(sql);
		} catch (SQLException e) {
			rs = false;
		}
		return rs;
	}
	public ResultSet executeQuery(String sql){
		ResultSet rs = null;
		if(conn==null){
			createConn();
		}
		try {
			java.sql.Statement state = conn.createStatement();
			rs = state.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}
	public void closeConn(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn=null;
			}
		}
	}
}
