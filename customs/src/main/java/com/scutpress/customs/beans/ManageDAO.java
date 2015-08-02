package com.scutpress.customs.beans;

import java.sql.SQLException;
import java.util.List;

import com.scutpress.customs.webservice.ConDele;


public class ManageDAO {
	public List<UsersBean> getProcesserUsers() throws SQLException {
		return ConDele.getDele().getProcesserUsers();
	}

	public List<UsersBean> getManagerUsers() throws SQLException {
		return ConDele.getDele().getManagerUsers();
	}

}
