package test.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.jws.WebService;


@WebService(endpointInterface = "test.server.Delegate")
public class DelegateImpl implements Delegate {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;


	DelegateImpl() {
	}

	@Override
	public void conGetConnect(String dbdriver, String dburl, String dbuser,
			String dbpassword) throws SQLException {
		try {
			Class.forName(dbdriver);
			System.out.println("驱动加载！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
			System.out.println("连接成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean conIsClosed() throws SQLException {
		return con.isClosed();
	};

	@Override
	public void conCreateStatement() throws SQLException {
		stmt = con.createStatement();
	}

	@Override
	public void conClose() throws SQLException {
		con.close();
	}

	@Override
	public void stmtExecuteQuery(String sql) throws SQLException {
		rs = stmt.executeQuery(sql);
	}

	@Override
	public void stmtClose() throws SQLException {
		stmt.close();
	}

	@Override
	public boolean rsNext() throws SQLException {
		return rs.next();
	}

	@Override
	public void rsClose() throws SQLException {
		rs.close();
	}

	@Override
	public String rsGetString(String string) throws SQLException {
		return rs.getString(string);
	}
	@Override
	public int rsGetIntByString(String string) throws SQLException {
		return rs.getInt(string);
	}
	@Override
	public int rsGetIntByInt(int i) throws SQLException {
		return rs.getInt(i);
	}
	@Override
	public int rsGetRow() throws SQLException {
		return rs.getRow();
	}
	@Override
	public boolean rsLast() throws SQLException {
		return rs.last();
	}
	@Override
	public void rsBeforeFirst() throws SQLException {
		rs.beforeFirst();
	}

	@Override
	public int stmtExecuteUpdate(String sql) throws SQLException {
		return stmt.executeUpdate(sql);
	}
}
