package com.scutpress.customs.beans;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.scutpress.customs.webservice.ConDele;


public class PubDAO {
	public List<String> getNewCol(int i) throws SQLException {// 拿到数据库里新闻的栏目返回String型的列表，i=0时返回所有栏目
		return ConDele.getDele().getNewCol(i);
	}

	public LinkedList<NewsBean> pubGetNewsByKC(String keyword, int columnId) throws SQLException {// 通过传来的关键字keyword或columnId，找到含有该关键字的文档并显示出来
		return ConDele.getDele().pubGetNewsByKC(keyword, columnId);
	}

	public boolean addNews(String title, int authorId, String keywords, String inputDate, int columnId, String fullText)
			throws SQLException {// 针对新闻人员：添加一则新闻
		return ConDele.getDele().addNews(title, authorId, keywords, inputDate, columnId, fullText);
	}

	public void editNews(int id, String title, String keywords, int columnId, String fullText) throws SQLException {// 修改一则新闻
		ConDele.getDele().editNews(id, title, keywords, columnId, fullText);
	}

	public List<NewsBean> getNews(int i) throws SQLException {// 通过新闻id拿到数据库里新闻信息返回NewsBean型的列表,i=0时取所有信息
		return ConDele.getDele().getNews(i);
	}

	public List<String> getNewsClass(int i) throws SQLException {// 拿到数据库里新闻的种类返回String型的列表
		return ConDele.getDele().getNewsClass(i);
	}

	public void updateNewsClass(int id, String className) throws SQLException {// 改变对应档案类别的名字
		ConDele.getDele().updateNewsClass(id, className);
	}

	public void delFromNews(int id) throws SQLException {// 删除news表里的一行数据
		ConDele.getDele().delFromNews(id);
	}

	public List<NewsBean> getPublisherInfo(int uid) throws SQLException {
		return ConDele.getDele().getPublisherInfo(uid);
	}

	public List<DocBean> getPubNewInfo() throws SQLException {
		return ConDele.getDele().getPubNewInfo();
	}
}
