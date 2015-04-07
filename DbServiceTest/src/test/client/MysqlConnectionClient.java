package test.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import test.server.ConnectionDelegation;
import test.server.ResultSetDelegation;
import test.server.StatementDelegation;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlConnectionClient {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/customsdb";
	/*
	 * private static final String URL =
	 * "jdbc:mysql://192.168.1.79:3306/customsdb";
	 */
	private static final String USER = "root";
	private static final String PASSWORD = "s";

	public static void main(String args[]) throws Exception {
		
		
//		QName SERVICE_NAME = new QName("http://server.test/", "ConnectionDelegationService");
//		QName PORT_NAME = new QName("http://server.test/", "ConnectionDelegationPort");
//		Service service = Service.create(SERVICE_NAME);
//		// Endpoint Address
//		String endpointAddress = "http://localhost:10101/mysql?wsdl";
//		// Add a port to the Service
//		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
//		ConnectionDelegation conn = service.getPort(ConnectionDelegation.class);
		
		URL url;
		url = new URL("http://localhost:10101/mysql?wsdl");
//		url = new URL("http://172.23.138.10:10101/mysql?wsdl");
		// Qualified name of the service:
		// 1st arg is the service URI
		// 2nd is the service name published in the WSDL
		QName qname = new QName("http://server.test/",
				"ConnectionDelegationService");
		// Create, in effect, a factory for the service.
		Service service = Service.create(url, qname);
		// Extract the endpoint interface, the service "port".
		ConnectionDelegation conn = service.getPort(ConnectionDelegation.class);

		try {
		conn.getConnect(DRIVER, URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(conn!=null)System.out.println("!NULL");
		int i=1;
		List<String> li = new ArrayList<String>();
		StatementDelegation stmt = null;
		ResultSetDelegation rs = null;
		String sql = null;
		try {
		if (!conn.isClosed())
			System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(i == 0){
				sql = "select ColumnName from newscolumn";
			}
			else{
				sql = "select ColumnName from newscolumn where id = '"+i+"'";
			}
			stmt = conn.createStatement();
			stmt.setConn(conn);//将conn捆绑到stmt上，使得stmt能够直接调用conn，从而实现远程调用
			rs = stmt.executeQuery(sql);//要执行的SQL语句
			rs.setConn(conn);

			while(rs.next()){
				li.add(rs.getString("ColumnName"));
						System.out.println("AAA");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//  			conn.closeRs();
//			conn.closeStmt();
//			conn.close();

			rs.close();
			stmt.close();
			conn.close();
			System.out.println(li);
		}
		
	}
}
