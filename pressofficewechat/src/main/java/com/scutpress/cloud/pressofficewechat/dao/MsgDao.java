package com.scutpress.cloud.pressofficewechat.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.scutpress.cloud.pressofficewechat.domain.Msg;

@Repository
public class MsgDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Msg> getMsgByType(int type) {
		final List<Msg> list = new LinkedList<Msg>();
		String sqlStr = "SELECT id,title,thumbMediaId,summary,msgUrl FROM msg WHERE msgType=? order by id desc";
		jdbcTemplate.query(sqlStr, new Object[] { type }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				Msg msgTmp = new Msg();
				msgTmp.setId(rs.getInt("id"));
				msgTmp.setTitle(rs.getString("title"));
				msgTmp.setSummary(rs.getString("summary"));
				msgTmp.setMsgUrl(rs.getString("msgUrl"));
				msgTmp.setThumbMediaId(rs.getString("thumbMediaId"));
				list.add(msgTmp);
				while (rs.next()) {
					Msg msg = new Msg();
					msg.setId(rs.getInt("id"));
					msg.setTitle(rs.getString("title"));
					msg.setSummary(rs.getString("summary"));
					msg.setMsgUrl(rs.getString("msgUrl"));
					msg.setThumbMediaId(rs.getString("thumbMediaId"));
					list.add(msg);
				}
			}
		});
		return list;
	}

	public Set<String> getAllMsgUrl() {
		String sqlStr = "SELECT msgUrl FROM msg";
		final Set<String> set = new HashSet<String>();
		jdbcTemplate.query(sqlStr, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				String msgUrl;
				if (rs != null) {
					msgUrl = rs.getString("msgUrl");
					set.add(msgUrl);
				}
				while (rs.next()) {
					msgUrl = rs.getString("msgUrl");
					set.add(msgUrl);
				}
			}
		});
		return set;
	}

	public void delMsg(String msgUrl) {
		String sqlStr = "DELETE FROM msg WHERE msgUrl=?";
		jdbcTemplate.update(sqlStr, new Object[] { msgUrl });
	}

	public void insertMsg(Msg msg) {
		String sqlStr = "INSERT INTO msg(msgUrl,title,summary,thumbMediaId)VALUE(?,?,?,?)";
		Object[] args = { msg.getMsgUrl(), msg.getTitle(), msg.getSummary(), msg.getThumbMediaId() };
		jdbcTemplate.update(sqlStr, args);
		System.out.println(args[1]);
	}

	// To do !!!
	public int getRank(int MsgType) {
		return 0;
	}

	public void setType(Msg msg, int type) {
		msg.setMsgType(type);
		if (msg.getId() != 0) {
			String sqlStr = " UPDATE msg SET msgType=?" + " WHERE id =?";
			jdbcTemplate.update(sqlStr, new Object[] { type, msg.getId() });
		} else if (msg.getMsgUrl() != null) {
			String sqlStr = " UPDATE msg SET msgType=?" + " WHERE msgUrl =?";
			jdbcTemplate.update(sqlStr, new Object[] { type, msg.getMsgUrl() });
		} else {
			System.out.println("Error in setType");
		}
	}

	public void setTypeByUrl(String msgUrl, int type) {
		String sqlStr = " UPDATE msg SET msgType=?" + " WHERE msgUrl =?";
		jdbcTemplate.update(sqlStr, new Object[] { type, msgUrl });

	}
	public void setTypeById(int  msgId, int type) {
		String sqlStr = " UPDATE msg SET msgType=?" + " WHERE id =?";
		jdbcTemplate.update(sqlStr, new Object[] { type, msgId });

	}
}