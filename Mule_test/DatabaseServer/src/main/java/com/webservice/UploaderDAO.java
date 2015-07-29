package com.webservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.BasicinfoBean;

public class UploaderDAO {
	public List<BasicinfoBean> getUploaderInfo() throws SQLException {
		List<BasicinfoBean> li = new ArrayList<BasicinfoBean>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		Connection con = Conn.getConnection();
		if (!con.isClosed())
			System.out.println("Succeeded connecting to the Database, table basicinfo!");
		try {
			sql = "select * from basicinfo order by InputDate desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);// 要执行的SQL语句
			while (rs.next()) {
				BasicinfoBean bean = new BasicinfoBean();
				bean.setID(rs.getInt("ID"));
				bean.setPublishID(rs.getInt("PublishID"));
				bean.setTitle(rs.getString("Title"));
				bean.setAbstract_(rs.getString("Abstract"));
				bean.setKeyWords(rs.getString("KeyWords"));
				bean.setKeyPersons(rs.getString("KeyPersons"));
				bean.setBuildTime(rs.getString("BuildTime"));
				bean.setFullText(rs.getString("FullText"));
				bean.setCustomsID(rs.getInt("CustomsID"));
				bean.setBuilder(rs.getString("Builder"));
				bean.setClassID(rs.getInt("ClassID"));
				bean.setInputDate(rs.getString("InputDate"));
				bean.setRawFormat(rs.getString("RawFormat"));
				bean.setRawID(rs.getInt("RawID"));
				bean.setSize(rs.getInt("Size"));
				bean.setRawUrl(rs.getString("RawUrl"));
				bean.setReduceUrl(rs.getString("ReduceUrl"));
				bean.setDownCount(rs.getInt("DownCount"));
				bean.setUserID(rs.getInt("UserID"));
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
