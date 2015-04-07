package test.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import test.server.ConnectionDelegate;
import test.server.Delegate;
import test.server.ResultSetDelegate;
import test.server.StatementDelegate;

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
	
		URL url= new URL("http://localhost:10101/mysql?wsdl");
		// Qualified name of the service:
		// 1st arg is the service URI
		// 2nd is the service name published in the WSDL
		QName qname = new QName("http://server.test/",
				"DelegateService");
		// Create, in effect, a factory for the service.
		Service service = Service.create(url, qname);
		// Extract the endpoint interface, the service "port".
		Delegate dele = service.getPort(Delegate.class);
		
		//////////////////////////////////////////////////////
		ConnectionDelegate con = new ConnectionDelegate(dele);
		try {
		con.getConnect(DRIVER, URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con!=null)System.out.println("!NULL");
		//////////////////////////////////////////////////////
		List<String> li = new ArrayList<String>();
		StatementDelegate stmt = null;
		ResultSetDelegate rs = null;
		String sql = null;
		try {
		if (!con.isClosed())
			System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int i=1;
		try {
			if(i == 0){
				sql = "select ColumnName from newscolumn";
			}
			else{
				sql = "select ColumnName from newscolumn where id = '"+i+"'";
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);//要执行的SQL语句

			while(rs.next()){
				li.add(rs.getString("ColumnName"));
						System.out.println("AAA");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			rs.close();
			stmt.close();
			con.close();
			System.out.println(li);
		}
		
	}

	private static ConnectionDelegate ConnectionDelegate(Delegate dele) {
		// TODO Auto-generated method stub
		return null;
	}
}
