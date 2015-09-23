package com.scutpress.cloud.publicwechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scutpress.cloud.publicwechat.dao.CrowderDao;
import com.scutpress.cloud.publicwechat.dao.MsgDao;
import com.scutpress.cloud.publicwechat.dao.OfficialDao;
import com.scutpress.cloud.publicwechat.dao.TypeDao;
import com.scutpress.cloud.publicwechat.domain.Crowder;
import com.scutpress.cloud.publicwechat.domain.Msg;

@Service
public class CrowderSerivce {
	@Autowired
	private CrowderDao crowderDao;
	public void insertCrowder(Crowder crowder){
		crowderDao.insertCrowder(crowder);
	}
}
