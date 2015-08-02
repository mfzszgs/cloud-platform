package com.scutpress.customs.beans;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.scutpress.customs.webservice.ConDele;


public class ChDAO {
	/**
	 * 获取众包用户的Id和登录名 "select id,loginname from users where userclass=3"
	 */
	public List<UsersBean> getProId_Name() throws SQLException {// 拿到众包用户的名称列表
		return ConDele.getDele().getProId_Name();
	}

	/**
	 * 通过传来的关键字keyword或classId或nameId(众包人员)，找到含有该关键字的文档并显示出来,此时文档的状态必须为3：校审
	 * 
	 * @param keyword
	 *            basic表中的title包含了keyword
	 * @param classId
	 *            classify表中的ID
	 * @param userId
	 *            用户在user表里的ID
	 */
	public LinkedList<DocBean> cheGetDocByKCN(String keyword, int classId, int userId) throws SQLException {// 通过传来的关键字keyword或classId或nameId(众包人员)，找到含有该关键字的文档并显示出来,此时文档的状态必须为3：校审
		return ConDele.getDele().cheGetDocByKCN(keyword, classId, userId);
	}

	/**
	 * 查找全部待审核的文档
	 */
	public List<DocBean> getCheckerInfo() throws SQLException {
		return ConDele.getDele().getCheckerInfo();
	}
}
