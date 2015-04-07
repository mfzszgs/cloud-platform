package test.server;

import java.sql.SQLException;

public class ConnectionDelegate{

	private Delegate dele;

	ConnectionDelegate() {
	}

	public ConnectionDelegate(Delegate dele) {
		this.dele = dele;
	}


	public void getConnect(String dbdriver, String dburl, String dbuser,
			String dbpassword) throws SQLException {
		dele.conGetConnect(dbdriver, dburl, dbuser, dbpassword);
	}

	public boolean isClosed() throws SQLException {
		return dele.conIsClosed();
	};

	public StatementDelegate createStatement() throws SQLException {
		dele.conCreateStatement();
		return new StatementDelegate(dele);
	}

	public void close() throws SQLException {
		dele.conClose();
	}

}
