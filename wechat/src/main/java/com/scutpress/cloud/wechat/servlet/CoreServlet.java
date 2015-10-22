package com.scutpress.cloud.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.scutpress.cloud.wechat.message.Articles;
import com.scutpress.cloud.wechat.message.Item;
import com.scutpress.cloud.wechat.message.Music;
import com.scutpress.cloud.wechat.message.ReplyMusicMessage;
import com.scutpress.cloud.wechat.message.ReplyTextMessage;
import com.scutpress.cloud.wechat.message.ReplyTuwenMessage;
import com.scutpress.cloud.wechat.message.RequestTextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class CoreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CoreServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 这里没有对发送信息者进行验证，直接返回了，要加验证的话自己去百度吧
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String echo = request.getParameter("echostr");
		echo = new String(echo.getBytes("ISO-8859-1"), "UTF-8");
		pw.println(echo);
		// 当你提交成为开发者的URL和Token时，微信服务器将发送GET请求到填写的URL上，
		// 只有你返回参数echostr时，他才会认为你这个接口是通的，才会提交成功
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 当你用微信给平台发送信息时就会到这里
		// 回复音乐和图文消息，我都写死了，自己可以根据自己的需要加相应的处理
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String wxMsgXml = IOUtils.toString(request.getInputStream(), "utf-8");
		RequestTextMessage textMsg = null;
		try {
			textMsg = getRequestTextMessage(wxMsgXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer replyMsg = new StringBuffer();
		String receive = textMsg.getContent().trim();
		String msgType = textMsg.getMessageType().trim();
		String returnXml = null;
		if (msgType.equals("text")) {
			replyMsg.append("收到了text");
			returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(), textMsg.getToUserName());
		} else if (msgType.equals("event")) {
			String event = textMsg.getEvent().trim();
			replyMsg.append("收到了event");
			returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(), textMsg.getToUserName());
			if (event.equals("subscribe")) {
				replyMsg.append("关注乡愁记忆，开启文化寻根之旅。");
				returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());
			}
		} else if (textMsg != null && !receive.equals("")) {
			if (receive.equals("？") || receive.equals("?")) {

				replyMsg.append("欢迎使用乡愁记忆微信平台！");
				// replyMsg.append("\r\n1、当前时间");
				// replyMsg.append("\r\n2、听音乐");
				// replyMsg.append("\r\n3、看图文");
				// replyMsg.append("\r\n其他、回音壁请直接输入文字信息");

				returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else if (receive.equals("2")) {

				// 回复音乐信息
				returnXml = getReplyMusicMessage(textMsg.getFromUserName(), textMsg.getToUserName());

			} else if (receive.equals("建筑")) {

				// 回复图文
				returnXml = getReplyTuwenMessage(textMsg.getFromUserName(), textMsg.getToUserName());

			} else if (receive.equals("1")) {

				// 回复时间
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				replyMsg.append("当前时间\r\n" + df.format(new Date()));
				returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else {

				replyMsg.append("收到： " + textMsg.getContent());
				returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());

			}
		} else {

			replyMsg.append("别闹了，这谁看得懂啊！");
			returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(), textMsg.getToUserName());

		}
		pw.println(returnXml);
	}

	// 获取推送文本消息
	private RequestTextMessage getRequestTextMessage(String xml) {

		XStream xstream = new XStream(new DomDriver());

		xstream.alias("xml", RequestTextMessage.class);
		xstream.aliasField("ToUserName", RequestTextMessage.class, "toUserName");
		xstream.aliasField("FromUserName", RequestTextMessage.class, "fromUserName");
		xstream.aliasField("CreateTime", RequestTextMessage.class, "createTime");
		xstream.aliasField("MsgType", RequestTextMessage.class, "messageType");
		xstream.aliasField("Content", RequestTextMessage.class, "content");
		xstream.aliasField("MsgId", RequestTextMessage.class, "msgId");

		// add

		xstream.aliasField("Event", RequestTextMessage.class, "event");

		RequestTextMessage requestTextMessage = (RequestTextMessage) xstream.fromXML(xml);
		return requestTextMessage;
	}

	// 回复文本消息
	private String getReplyTextMessage(String content, String fromUserName, String toUserName) {

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

	// 回复音乐消息
	private String getReplyMusicMessage(String fromUserName, String toUserName) {

		ReplyMusicMessage we = new ReplyMusicMessage();
		Music music = new Music();

		we.setMessageType("music");
		we.setCreateTime(new Long(new Date().getTime()).toString());
		we.setToUserName(fromUserName);
		we.setFromUserName(toUserName);
		we.setFuncFlag("0");

		music.setTitle("回家|X-man");
		music.setDescription("萨克斯 回家  勾起你想家的愁思...");

		String url = "http://bcs.duapp.com/yishi-music/%E5%9B%9E%E5%AE%B6.mp3?sign=MBO:97068c69ccb2ab230a497c59d528dcce:LdYZ%2FLXohKa6YCy9gbxL%2B1mZ4Co%3D";
		String url2 = "http://bcs.duapp.com/yishi-music/X-man.mp3?sign=MBO:97068c69ccb2ab230a497c59d528dcce:cYV%2B%2Fq2Tlv2de6gqecZynCyIm3k%3D";
		music.setMusicUrl(url);
		music.setHqMusicUrl(url2);

		we.setMusic(music);

		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", ReplyMusicMessage.class);
		xstream.aliasField("ToUserName", ReplyMusicMessage.class, "toUserName");
		xstream.aliasField("FromUserName", ReplyMusicMessage.class, "fromUserName");
		xstream.aliasField("CreateTime", ReplyMusicMessage.class, "createTime");
		xstream.aliasField("MsgType", ReplyMusicMessage.class, "messageType");
		xstream.aliasField("FuncFlag", ReplyMusicMessage.class, "funcFlag");
		xstream.aliasField("Music", ReplyMusicMessage.class, "Music");

		xstream.aliasField("Title", Music.class, "title");
		xstream.aliasField("Description", Music.class, "description");
		xstream.aliasField("MusicUrl", Music.class, "musicUrl");
		xstream.aliasField("HQMusicUrl", Music.class, "hqMusicUrl");

		String xml = xstream.toXML(we);
		return xml;
	}

	// 回复图文消息
	private String getReplyTuwenMessage(String fromUserName, String toUserName) {

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
