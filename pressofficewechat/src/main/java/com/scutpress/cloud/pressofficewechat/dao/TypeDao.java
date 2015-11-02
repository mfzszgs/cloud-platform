package com.scutpress.cloud.pressofficewechat.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public class TypeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<String> getAllType() {
		final List<String> list = new LinkedList<String>();
		String sqlStr = "select typeName from typeTable order by typeNum";
		jdbcTemplate.query(sqlStr, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				list.add(rs.getString("typeName"));
				while (rs.next()) {
					list.add(rs.getString("typeName"));
				}
			}
		});
		return list;
	}
}
