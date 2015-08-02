package com.scutpress.customs.beans;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.scutpress.customs.webservice.ConDele;


public class ProDAO {

	// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public void updateAllDoc(int id, String retitle, String keywords, String keypersons, String buildtime,
			String builder, String abstracts, String fulltext, String translatetext) throws SQLException {// 众包人员补全文档信息
		ConDele.getDele().updateAllDoc(id, retitle, keywords, keypersons, buildtime, builder, abstracts, fulltext,
				translatetext);
	}

	public void updateDocSuggestion(int id, String suggestion)
			throws SQLException {/* 通过文档id 设置用户id和文档状态 */
		ConDele.getDele().updateDocSuggestion(id, suggestion);
	}

	public boolean statexToy(int id, int x, int y) throws SQLException {/* 通过文档id将文档状态改为校审 */
		return ConDele.getDele().statexToy(id, x, y);
	}

	public void updateDoc(int id, int uid)
			throws SQLException {/* 通过文档id 设置用户id和文档状态 */
		ConDele.getDele().updateDocByProDAO(id, uid);
	}

	public List<String> getDocState(int i) throws SQLException {// 拿到数据库里档案的状态id，返回String型的列表
		return ConDele.getDele().getDocState(i);
	}

	public LinkedList<DocBean> proGetDocByKS(String keyword, int stateId, int uid) throws SQLException {// 通过keyword和文档状态，查找指定用户的文档
		return ConDele.getDele().proGetDocByKS(keyword, stateId, uid);
	}

	public void delFromProFile(int id)
			throws SQLException {/* 通过文档id修改文档状态：从被包改成可包 */
		ConDele.getDele().delFromProFile(id);
	}

	public List<DocBean> getProcesserInfo() throws SQLException {
		return ConDele.getDele().getProcesserInfo();
	}

	public List<DocBean> getProFileInfo(int uid) throws SQLException {
		return ConDele.getDele().getProFileInfo(uid);
	}
}
