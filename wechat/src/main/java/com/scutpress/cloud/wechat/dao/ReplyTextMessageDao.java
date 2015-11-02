package com.scutpress.cloud.wechat.dao;

import java.util.Date;

import com.scutpress.cloud.wechat.domain.ReplyTextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ReplyTextMessageDao {

	public String getReplyTextMessage(String content, String fromUserName, String toUserName) {

		ReplyTextMessage we = new ReplyTextMessage();
		we.setMessageType("text");
		we.setFuncFlag("0");
		we.setCreateTime(new Long(new Date().getTime()).toString());
		we.setContent(content);
		we.setToUserName(fromUserName);
		we.setFromUserName(toUserName);
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", ReplyTextMessage.class);
		xstream.aliasField("ToUserName", ReplyTextMessage.class, "toUserName");
		xstream.aliasField("FromUserName", ReplyTextMessage.class, "fromUserName");
		xstream.aliasField("CreateTime", ReplyTextMessage.class, "createTime");
		xstream.aliasField("MsgType", ReplyTextMessage.class, "messageType");
		xstream.aliasField("Content", ReplyTextMessage.class, "content");
		xstream.aliasField("FuncFlag", ReplyTextMessage.class, "funcFlag");
		String xml = xstream.toXML(we);
		return xml;
	}
}
