package com.beans;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.webservice.ConDele;

public class ChDAO {

	public List<UsersBean> getProId_Name() throws SQLException {// 拿到众包用户的名称列表
		return ConDele.getDele().getProId_Name();
	}

	public LinkedList<DocBean> cheGetDocByKCN(String keyword, int classId, int userId) throws SQLException {// 通过传来的关键字keyword或classId或nameId(众包人员)，找到含有该关键字的文档并显示出来,此时文档的状态必须为3：校审
		return ConDele.getDele().cheGetDocByKCN(keyword, classId, userId);
	}

	public List<BasicinfoBean> getCheckerInfo() throws SQLException {
		return ConDele.getDele().getCheckerInfo();
	}
}
