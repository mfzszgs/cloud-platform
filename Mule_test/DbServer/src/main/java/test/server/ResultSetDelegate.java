package test.server;

import java.sql.SQLException;

public class ResultSetDelegate {
	Delegate dele;

	ResultSetDelegate() {
	}

	ResultSetDelegate(Delegate dele) {
		this.dele = dele;
	}

	public boolean next() throws SQLException {
		return dele.rsNext();
	};

	public void close() throws SQLException {
		dele.rsClose();
	}

	public String getString(String string) throws SQLException {
		return dele.rsGetString(string);
	};

	public int getInt(String string) throws SQLException {
		return dele.rsGetIntByString(string);
	};

	public int getInt(int i) throws SQLException {
		return dele.rsGetIntByInt(i);
	};

	public int getRow() throws SQLException {
		return dele.rsGetRow();
	};

	public boolean last() throws SQLException {
		return dele.rsLast();
	};

	public void beforeFirst() throws SQLException {
		dele.rsBeforeFirst();
	}

}
