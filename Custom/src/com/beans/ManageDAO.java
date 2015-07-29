package com.beans;

import java.sql.SQLException;
import java.util.List;

import com.webservice.ConDele;

public class ManageDAO {
	public List<UsersBean> getProcesserUsers() throws SQLException {
		return ConDele.getDele().getProcesserUsers();
	}

	public List<UsersBean> getManagerUsers() throws SQLException {
		return ConDele.getDele().getManagerUsers();
	}

}
