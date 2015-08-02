package com.scutpress.customs.webservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scutpress.customs.beans.DocBean;


public class UploaderDAO {
	public List<DocBean> getUploaderInfo() throws SQLException {
		List<DocBean> li = new ArrayList<DocBean>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		Connection con = Conn.getConnection();
		if (!con.isClosed())
			System.out.println("Succeeded connecting, select * from basicinfo order by InputDate desc");
		try {
			sql = "select * from basicinfo order by InputDate desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);// 要执行的SQL语句
			while (rs.next()) {
				DocBean bean = new DocBean();
				bean.setID(rs.getInt("ID"));
				bean.setPublishId(rs.getInt("PublishID"));
				bean.setTitle(rs.getString("Title"));
				bean.setDocAbstract(rs.getString("Abstract"));
				bean.setKeyWords(rs.getString("KeyWords"));
				bean.setKeyPersons(rs.getString("KeyPersons"));
				bean.setBuildTime(rs.getString("BuildTime"));
				bean.setFullText(rs.getString("FullText"));
				bean.setCustomsId(rs.getInt("CustomsID"));
				bean.setBuilder(rs.getString("Builder"));
				bean.setClassId(rs.getInt("ClassID"));
				bean.setInputDate(rs.getString("InputDate"));
				bean.setRawFormat(rs.getString("RawFormat"));
				bean.setRawId(rs.getInt("RawID"));
				bean.setSize(rs.getInt("Size"));
				bean.setRawUrl(rs.getString("RawUrl"));
				bean.setReduceUrl(rs.getString("ReduceUrl"));
				bean.setDownCount(rs.getInt("DownCount"));
				bean.setUserId(rs.getInt("UserID"));
				bean.setState(rs.getInt("State"));
				bean.setTranslateText(rs.getString("TranslateText"));
				bean.setSuggestion(rs.getString("Suggestion"));
				li.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conn.closeRs(rs);
			Conn.closeStmt(stmt);
			Conn.closeCon(con);
		}
		return li;
	}
}
