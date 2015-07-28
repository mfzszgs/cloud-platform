package test.server;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface Delegate {

	@WebMethod
	public void conGetConnect(String dbdriver, String dburl,
			String dbuser, String dbpassword) throws SQLException;
	@WebMethod
	public boolean conIsClosed() throws SQLException ;
	@WebMethod
	public void conCreateStatement() throws SQLException;
	@WebMethod
    public void conClose() throws SQLException;
	@WebMethod
    public void stmtExecuteQuery(String sql) throws SQLException;
	@WebMethod
	public void stmtClose() throws SQLException;
	@WebMethod	
	public boolean rsNext() throws SQLException;
	@WebMethod
	public void rsClose() throws SQLException;
	@WebMethod
	public String rsGetString(String string) throws SQLException;
	@WebMethod
	public int rsGetIntByString(String string) throws SQLException;
	@WebMethod
	public int rsGetIntByInt(int i) throws SQLException;
	@WebMethod
	public int rsGetRow() throws SQLException;
	@WebMethod
	public boolean rsLast() throws SQLException;
	@WebMethod
	public int stmtExecuteUpdate(String sql) throws SQLException;
}
