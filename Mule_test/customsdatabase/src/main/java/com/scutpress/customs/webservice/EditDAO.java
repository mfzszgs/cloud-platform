package com.scutpress.customs.webservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.scutpress.customs.beans.DocBean;



public class EditDAO {

	public LinkedList<DocBean> editGetDocByKCBT(String keyword, int classId,
			String builder, String startBt, String endBt) throws SQLException {
		// 通过传来的关键字keyword或classId或文档起草人或时间段，找到含有该关键字的文档并显示出来,此时文档的状态必须为4：通过
		LinkedList<DocBean> li = new LinkedList<DocBean>();
		Statement stmt = null;
		ResultSet rs = null;
		Connection con = Conn.getConnection();
		String sql = null;
		if (!con.isClosed())
			// select * from basicinfo where state = 4 and BuildTime between
			// '1994-11-02' and '2014-11-02' order by BuildTime asc
			System.out.println("Succeeded connecting to the Database!");
		try {
			if (keyword != null && classId == 0 && builder.equals("")
					&& startBt.equals("") && endBt.equals("")) {// 只填了关键字
				sql = "select * from basicinfo where title like '%" + keyword
						+ "%' and state = 4 order by BuildTime ASC";
			} else if (keyword.equals("") && classId != 0 && builder.equals("")
					&& startBt.equals("") && endBt.equals("")) {// 只填了文档类别
				sql = "select * from basicinfo where classid = " + classId
						+ " and state = 4 order by BuildTime ASC";
			} else if (keyword.equals("") && classId == 0 && builder != null
					&& startBt.equals("") && endBt.equals("")) {// 只填了起草人
				sql = "select * from basicinfo where builder = '" + builder
						+ "'and state = 4 order by BuildTime ASC";
			} else if (keyword.equals("") && classId == 0 && builder.equals("")
					&& startBt != null && endBt != null) {// 只填了时间段
				sql = "select * from basicinfo where BuildTime between '"
						+ startBt + "' and '" + endBt
						+ "' and state = 4 order by BuildTime ASC";
			}

			else if (keyword != null && classId != 0 && builder.equals("")
					&& startBt.equals("") && endBt.equals("")) {// 只填了关键字和文档类别
				sql = "select * from basicinfo where title like '%" + keyword
						+ "%' and classid = " + classId
						+ " and state = 4 order by BuildTime ASC";
			} else if (keyword != null && classId == 0 && builder != null
					&& startBt.equals("") && endBt.equals("")) {// 只填了关键字和起草人
				sql = "select * from basicinfo where title like '%" + keyword
						+ "%' and builder = '" + builder
						+ "' and state = 4 order by BuildTime ASC";
			} else if (keyword != null && classId == 0 && builder.equals("")
					&& startBt != null && endBt != null) {// 只填了关键字和时间段
				sql = "select * from basicinfo where title like '%" + keyword
						+ "%' and BuildTime between '" + startBt + "' and '"
						+ endBt + "'and state = 4 order by BuildTime ASC";
			} else if (keyword.equals("") && classId != 0 && builder != null
					&& startBt.equals("") && endBt.equals("")) {// 只填了起草人和文档类别
				sql = "select * from basicinfo where classid = " + classId
						+ " and builder = '" + builder
						+ "' and state = 4 order by BuildTime ASC";
			} else if (keyword.equals("") && classId == 0 && builder != null
					&& startBt != null && endBt != null) {// 只填了起草人和时间段
				sql = "select * from basicinfo where builder = '" + builder
						+ "'and BuildTime between '" + startBt + "' and '"
						+ endBt + "'and state = 4 order by BuildTime ASC";
			} else if (keyword.equals("") && classId != 0 && builder.equals("")
					&& startBt != null && endBt != null) {// 只填了文档类别和时间段
				sql = "select * from basicinfo where BuildTime between '"
						+ startBt + "' and '" + endBt + "'and classid = "
						+ classId + " and state = 4 order by BuildTime ASC";
			}

			else if (keyword != null && classId != 0 && builder != null
					&& startBt.equals("") && endBt.equals("")) {// 只填了关键字,文档类别,起草人
				sql = "select * from basicinfo where title like '%" + keyword
						+ "%' and classid = " + classId + " and builder = '"
						+ builder + "' and state = 4 order by BuildTime ASC ";
			} else if (keyword != null && classId != 0 && builder.equals("")
					&& startBt != null && endBt != null) {// 只填了关键字,文档类别,时间段
				sql = "select * from basicinfo where title like '%" + keyword
						+ "%' and classid = " + classId
						+ " and BuildTime between '" + startBt + "' and '"
						+ endBt + "' and state = 4 order by BuildTime ASC ";
			} else if (keyword != null && classId == 0 && builder != null
					&& startBt != null && endBt != null) {// 只填了关键字,起草人,时间段
				sql = "select * from basicinfo where title like '%" + keyword
						+ "%' and builder = '" + builder
						+ "'and BuildTime between '" + startBt + "' and '"
						+ endBt + "' and state = 4 order by BuildTime ASC ";
			} else if (keyword.equals("") && classId != 0 && builder != null
					&& startBt != null && endBt != null) {// 文档类别,起草人,时间段
				sql = "select * from basicinfo where classid = " + classId
						+ " and builder = '" + builder
						+ "' and BuildTime between '" + startBt + "' and '"
						+ endBt + "' and state = 4 order by BuildTime ASC ";
			}

			else if (keyword != null && builder != null && startBt != null
					&& endBt != null) {// 如果条件都填了
				sql = "select * from basicinfo where title like '%" + keyword
						+ "%' and classid = " + classId
						+ " and BuildTime between '" + startBt + "' and '"
						+ endBt + "' and builder = '" + builder
						+ "' and state = 4 order by BuildTime ASC ";
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);// 要执行的SQL语句
			while (rs.next()) {
				DocBean docb = new DocBean();
				docb.setID(rs.getInt("ID"));
				docb.setTitle(rs.getString("title"));
				docb.setClassId(rs.getInt("classId"));
				docb.setBuilder(rs.getString("builder"));
				docb.setBuildTime(rs.getString("BuildTime"));
				docb.setCustomsId(rs.getInt("customsId"));
				docb.setRawId(rs.getInt("rawId"));
				docb.setUserId(rs.getInt("userId"));
				li.add(docb);
				// 剩下的还没写
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

	public List<DocBean> getEditorInfo() throws SQLException {
		List<DocBean> li = new ArrayList<DocBean>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		Connection con = Conn.getConnection();
		if (!con.isClosed())
			System.out
					.println("Succeeded connecting to the Database, table basicinfo!");
		try {
			sql = "select * from basicinfo where state = 4 order by BuildTime DESC";
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
