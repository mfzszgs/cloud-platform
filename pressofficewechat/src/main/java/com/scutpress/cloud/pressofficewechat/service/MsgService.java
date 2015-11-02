package com.scutpress.cloud.pressofficewechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scutpress.cloud.pressofficewechat.dao.MsgDao;
import com.scutpress.cloud.pressofficewechat.dao.OfficialDao;
import com.scutpress.cloud.pressofficewechat.dao.TypeDao;
import com.scutpress.cloud.pressofficewechat.domain.Msg;

@Service
public class MsgService {
	@Autowired
	private MsgDao msgDao;
	@Autowired
	private TypeDao typeDao;

	public List<Msg> getMsgTable(int typeNum) {
		List<Msg> list = msgDao.getMsgByType(typeNum);
		return list;
	}

	public List<String> getAllType() {
		return typeDao.getAllType();
	}

	// public void changeMsgType(List<Msg> list, String[] typeArr) {
	// if (typeArr.length != list.size()) {
	// System.out.println("Error in MsgService.changeMsgType");
	// }
	// for (int i = 0; i < typeArr.length; i++) {
	// msgDao.setType(list.get(i), Integer.parseInt(typeArr[i]));
	// }
	// }
	public void changeMsgTypeById(int msgId, int type) {
		msgDao.setTypeById(msgId, type);
	}
}
