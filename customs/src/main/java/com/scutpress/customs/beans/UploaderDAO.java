package com.scutpress.customs.beans;

import java.sql.SQLException;
import java.util.List;

import com.scutpress.customs.webservice.ConDele;


public class UploaderDAO {
	public List<DocBean> getUploaderInfo() throws SQLException {
		return ConDele.getDele().getUploaderInfo();
	}
}
