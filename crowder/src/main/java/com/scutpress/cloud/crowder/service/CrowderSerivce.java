package com.scutpress.cloud.crowder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scutpress.cloud.crowder.dao.CrowderDao;
import com.scutpress.cloud.crowder.domain.Crowder;

@Service
public class CrowderSerivce {
	@Autowired
	private CrowderDao crowderDao;
	public void insertCrowder(Crowder crowder){
		crowderDao.insertCrowder(crowder);
	}
}
