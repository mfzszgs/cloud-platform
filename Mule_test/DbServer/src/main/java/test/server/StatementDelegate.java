package test.server;

import java.sql.SQLException;

public class StatementDelegate {
	private Delegate dele;

	public StatementDelegate() {
	}

	public StatementDelegate(Delegate dele) {
		this.dele = dele;
	}

	public ResultSetDelegate executeQuery(String sql) throws SQLException {
		ResultSetDelegate rs=new ResultSetDelegate(dele);
		dele.stmtExecuteQuery(sql);
		return rs;
	}

	public void close() throws SQLException {
		dele.stmtClose();
	}


	public int executeUpdate(String sql) throws SQLException{
		return dele.stmtExecuteUpdate(sql);
	}
}
