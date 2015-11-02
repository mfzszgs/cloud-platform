package com.scutpress.cloud.wechat.dao;

import java.util.Date;

import com.scutpress.cloud.wechat.domain.Music;
import com.scutpress.cloud.wechat.domain.ReplyMusicMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ReplyMusicMessageDao {
	public String getReplyMusicMessage(String fromUserName, String toUserName) {

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
}
