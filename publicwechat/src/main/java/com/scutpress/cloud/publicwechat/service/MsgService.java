package com.scutpress.cloud.publicwechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scutpress.cloud.publicwechat.dao.MsgDao;
import com.scutpress.cloud.publicwechat.dao.OfficialDao;
import com.scutpress.cloud.publicwechat.dao.TypeDao;
import com.scutpress.cloud.publicwechat.domain.Msg;

@Service
public class MsgService {
	@Autowired
	private MsgDao msgDao;
	@Autowired
	private TypeDao typeDao;

	public List<Msg> getMsgTable(int type) {
		List<Msg> list = msgDao.getMsgByType(type);
		return list;
	}

	public List<String> getAllType() {
		return typeDao.getAllType();
	}

	public void changeMsgType(List<Msg> list, String[] typeArr) {
		if (typeArr.length != list.size()) {
			System.out.println("Error in MsgService.changeMsgType");
		}
		for (int i = 0; i < typeArr.length; i++) {
			msgDao.setType(list.get(i), Integer.parseInt(typeArr[i]));
		}
	}
}
