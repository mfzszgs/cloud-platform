package com.scutpress.cloud.wechat.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;

import com.scutpress.cloud.wechat.dao.ReplyMusicMessageDao;
import com.scutpress.cloud.wechat.dao.ReplyTextMessageDao;
import com.scutpress.cloud.wechat.dao.ReplyTuwenMessageDao;
import com.scutpress.cloud.wechat.dao.RequestMessageDao;
import com.scutpress.cloud.wechat.domain.Articles;
import com.scutpress.cloud.wechat.domain.Item;
import com.scutpress.cloud.wechat.domain.Music;
import com.scutpress.cloud.wechat.domain.ReplyMusicMessage;
import com.scutpress.cloud.wechat.domain.ReplyTextMessage;
import com.scutpress.cloud.wechat.domain.ReplyTuwenMessage;
import com.scutpress.cloud.wechat.domain.RequestMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class CoreService {
	public String getResponse(HttpServletRequest request) throws ServletException, IOException {

		String wxMsgXml = IOUtils.toString(request.getInputStream(), "utf-8");
		RequestMessageDao requestMessageDao = new RequestMessageDao();
		ReplyMusicMessageDao replyMusicMessageDao = new ReplyMusicMessageDao();
		ReplyTextMessageDao replyTextMessageDao = new ReplyTextMessageDao();
		ReplyTuwenMessageDao replyTuwenMessageDao = new ReplyTuwenMessageDao();

		System.out.println("收到的xml为：" + wxMsgXml);
		RequestMessage textMsg = null;
		try {
			textMsg = requestMessageDao.getRequestMessage(wxMsgXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer replyMsg = new StringBuffer();
		String returnXml = null;

		String msgType = textMsg.getMessageType().trim();
//		System.out.println("msgType is " + msgType);

		if (msgType.equals("event")) {
//			System.out.println("收到了event");
			String event = textMsg.getEvent().trim();
			if (event.equals("subscribe")) {
				replyMsg.append("关注乡愁记忆，开启文化寻根之旅。");
				returnXml = replyTextMessageDao.getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());
			}
		}

		else if (msgType.equals("text")) {
//			System.out.println("收到了text");
			String content = textMsg.getContent().trim();
			if (content.equals("2")) {

				// 回复音乐信息
				returnXml = replyMusicMessageDao.getReplyMusicMessage(textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else if (content.equals("建筑")) {

				// 回复图文
				returnXml = replyTuwenMessageDao.getReplyTuwenMessage(textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else if (content.equals("1")) {

				// 回复时间
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				replyMsg.append("当前时间\r\n" + df.format(new Date()));
				returnXml = replyTextMessageDao.getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else {

				replyMsg.append("收到： " + textMsg.getContent());
				returnXml = replyTextMessageDao.getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());

			}
		} else {

			replyMsg.append("别闹了，这谁看得懂啊！");
			returnXml = replyTextMessageDao.getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
					textMsg.getToUserName());

		}

		return returnXml;
	}

}
