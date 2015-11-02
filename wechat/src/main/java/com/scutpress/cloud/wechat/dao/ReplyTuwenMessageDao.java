package com.scutpress.cloud.wechat.dao;

import java.util.Date;

import com.scutpress.cloud.wechat.domain.Articles;
import com.scutpress.cloud.wechat.domain.Item;
import com.scutpress.cloud.wechat.domain.ReplyTuwenMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ReplyTuwenMessageDao {
	public String getReplyTuwenMessage(String fromUserName, String toUserName) {

		ReplyTuwenMessage we = new ReplyTuwenMessage();

		Articles articles = new Articles();

		Item item = new Item();

		we.setMessageType("news");
		we.setCreateTime(new Long(new Date().getTime()).toString());
		we.setToUserName(fromUserName);
		we.setFromUserName(toUserName);
		we.setFuncFlag("0");
		we.setArticleCount(1);

		item.setTitle("纸币上的建筑答案");
		item.setDescription("这就是你想要的答案。");
		item.setPicUrl(
				"http://mmbiz.qpic.cn/mmbiz/vytfmsJO2Baj4aXT0dClr3ia7C6BibjGu7icaKiaZS3dCI1BbRs0icTYFx4yrX4HwcmW8lkxqFzbKjbK3WgU0IhQUlQ/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1");
		item.setUrl(
				"http://mp.weixin.qq.com/s?__biz=MzIwNzAzNzc0OQ==&mid=400074297&idx=1&sn=3f5474c65dfec075800a5f00b947db00#rd");

		articles.setItem(item);
		we.setArticles(articles);

		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", ReplyTuwenMessage.class);
		xstream.aliasField("ToUserName", ReplyTuwenMessage.class, "toUserName");
		xstream.aliasField("FromUserName", ReplyTuwenMessage.class, "fromUserName");
		xstream.aliasField("CreateTime", ReplyTuwenMessage.class, "createTime");
		xstream.aliasField("MsgType", ReplyTuwenMessage.class, "messageType");
		xstream.aliasField("Articles", ReplyTuwenMessage.class, "Articles");

		xstream.aliasField("ArticleCount", ReplyTuwenMessage.class, "articleCount");
		xstream.aliasField("FuncFlag", ReplyTuwenMessage.class, "funcFlag");

		xstream.aliasField("item", Articles.class, "item");

		xstream.aliasField("Title", Item.class, "title");
		xstream.aliasField("Description", Item.class, "description");
		xstream.aliasField("PicUrl", Item.class, "picUrl");
		xstream.aliasField("Url", Item.class, "url");

		String xml = xstream.toXML(we);
		return xml;
	}
}
