package com.beans;

import java.sql.SQLException;
import java.util.List;

import com.beans.BasicinfoBean;
import com.webservice.ConDele;

public class UploaderDAO {
	public List<BasicinfoBean> getUploaderInfo() throws SQLException {
		return ConDele.getDele().getUploaderInfo();
	}
}
