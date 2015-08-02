package com.scutpress.customs.webservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scutpress.customs.beans.UsersBean;



public class ManageDAO {
	public List<UsersBean> getProcesserUsers() throws SQLException {
		List<UsersBean> li = new ArrayList<UsersBean>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		Connection con = Conn.getConnection();
		if (!con.isClosed())
			System.out.println("Succeeded connecting to the Database, to get processers' usersdata!");
		try {
			sql = "select * from users where Authority = 0 and UserClass = 3";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);// 要执行的SQL语句
			while (rs.next()) {
				UsersBean bean = new UsersBean();
				bean.setLoginName(rs.getString("LoginName"));
				bean.setName(rs.getString("Name"));
				bean.setId(rs.getInt("ID"));
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

	public List<UsersBean> getManagerUsers() throws SQLException {
		List<UsersBean> li = new ArrayList<UsersBean>();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		Connection con = Conn.getConnection();
		if (!con.isClosed())
			System.out.println("Succeeded connecting to the Database, to get Managers' usersdata!");
		try {
			sql = "select * from users where userclass!=1";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);// 要执行的SQL语句
			while (rs.next()) {
				UsersBean bean = new UsersBean();
				bean.setLoginName(rs.getString("LoginName"));
				bean.setName(rs.getString("Name"));
				bean.setId(rs.getInt("ID"));
				bean.setUserClass(rs.getInt("UserClass"));
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
