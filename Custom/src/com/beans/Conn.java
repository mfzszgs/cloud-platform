package com.beans;
 
import java.net.URL;
import java.sql.*;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import test.server.*;

public class Conn {

	private static Delegate dele=null;
	private static ConnectionDelegate con=null;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/customsdb";
    /*private static final String URL = "jdbc:mysql://192.168.1.79:3306/customsdb";*/
    private static final String USER = "root";
	private static final String PASSWORD = "s";
	
	public static ConnectionDelegate getConnection() {
		URL url;
		try {
			url = new URL("http://localhost:10101/mysql?wsdl");
		// Qualified name of the service:
		// 1st arg is the service URI
		// 2nd is the service name published in the WSDL
		QName qname = new QName("http://server.test/",
				"DelegateService");
		// Create, in effect, a factory for the service.
		Service service = Service.create(url, qname);
		// Extract the endpoint interface, the service "port".
		dele = service.getPort(Delegate.class);
		con = new ConnectionDelegate(dele);
		con.getConnect(DRIVER, URL, USER, PASSWORD);
		if(con==null)System.out.println("con is NULL!!!!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeCon(ConnectionDelegate con){
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStmt(StatementDelegate stmt){
		try {
			if(stmt!=null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeRs(ResultSetDelegate rs){
		try {
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
