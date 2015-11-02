package com.scutpress.cloud.wechat.dao;

import com.scutpress.cloud.wechat.domain.RequestMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class RequestMessageDao {
	public RequestMessage getRequestMessage(String xml) {

		XStream xstream = new XStream(new DomDriver());

		xstream.alias("xml", RequestMessage.class);
		xstream.aliasField("ToUserName", RequestMessage.class, "toUserName");
		xstream.aliasField("FromUserName", RequestMessage.class, "fromUserName");
		xstream.aliasField("CreateTime", RequestMessage.class, "createTime");
		xstream.aliasField("MsgType", RequestMessage.class, "messageType");

		// add
		xstream.aliasField("Event", RequestMessage.class, "event");
		xstream.aliasField("EventKey", RequestMessage.class, "eventKey");

		xstream.aliasField("Content", RequestMessage.class, "content");
		xstream.aliasField("MsgId", RequestMessage.class, "msgId");

		RequestMessage requestTextMessage = (RequestMessage) xstream.fromXML(xml);

		return requestTextMessage;
	}
}
