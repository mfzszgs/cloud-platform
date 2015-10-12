package com.scutpress.cloud.crowder.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scutpress.cloud.crowder.domain.Crowder;

@Repository
public class CrowderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertCrowder(Crowder crowder) {
		String sqlStr = "INSERT INTO crowderTable(name,sex,age,occupation,phone,email,provice,city,address)VALUE(?,?,?,?,?,?,?,?,?)";
		Object[] args = { crowder.getName(), crowder.getSex(), crowder.getAge(), crowder.getOccupation(),
				crowder.getPhone(), crowder.getEmail(), crowder.getProvice(), crowder.getCity(), crowder.getAddress() };
		jdbcTemplate.update(sqlStr, args);
	}

}