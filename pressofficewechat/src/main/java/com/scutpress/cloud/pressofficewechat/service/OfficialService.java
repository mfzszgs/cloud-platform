package com.scutpress.cloud.pressofficewechat.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scutpress.cloud.pressofficewechat.dao.MsgCallbackHandler;
import com.scutpress.cloud.pressofficewechat.dao.MsgDao;
import com.scutpress.cloud.pressofficewechat.dao.OfficialDao;
import com.scutpress.cloud.pressofficewechat.domain.Msg;

@Service
public class OfficialService {
	@Autowired
	private MsgDao msgDao;

	@Autowired
	private OfficialDao officialDao;

	public void syncMsg(final String path) {
		final Set<String> localMsgUrlSet = msgDao.getAllMsgUrl();
		officialDao.msgResolver(new MsgCallbackHandler() {
			public void processMsg(Msg msg) {
				if (localMsgUrlSet.contains(msg.getMsgUrl())) {
					localMsgUrlSet.remove(msg.getMsgUrl());
				} else {
					msgDao.insertMsg(msg);
					msgDao.setType(msg, 1);// 默认设置为未分类板块
					// log
					officialDao.downloadImg(msg.getThumbMediaId(), path);
				}
			}
		});
		for (String str : localMsgUrlSet) {
			msgDao.delMsg(str);
		}
	}

}
