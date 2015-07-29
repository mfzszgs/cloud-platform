package com.beans;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.webservice.ConDele;

public class EditDAO {

	public LinkedList<DocBean> editGetDocByKCBT(String keyword, int classId, String builder, String startBt,
			String endBt) throws SQLException {
		// 通过传来的关键字keyword或classId或文档起草人或时间段，找到含有该关键字的文档并显示出来,此时文档的状态必须为4：通过
		return ConDele.getDele().editGetDocByKCBT(keyword, classId, builder, startBt, endBt);
	}

	public List<BasicinfoBean> getEditorInfo() throws SQLException {
		return ConDele.getDele().getEditorInfo();
	}

}
