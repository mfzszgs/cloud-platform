package com.scutpress.cloud.publicwechat.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Repository;

import com.scutpress.cloud.publicwechat.domain.Msg;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Repository
public class OfficialDao {
	final private String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
	final private String appid = "wx70319e81317974eb&secret";
	final private String secret = "46ef2044535f4b7361c6ad8e569512c2";
	final private String materialTableUrl = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";
	final private String materialUrl = "https://api.weixin.qq.com/cgi-bin/material/get_material";
	final private String summaryReg = "<p>(<.*?>)*\\s*(.*?)(</.*?>.*?)*\\s*</p>";
	final private int MAX = 100000;
	String token;

	void refreshToken() {
		String para = "grant_type=client_credential&appid=" + appid + "&secret=" + secret;
		token = JSONObject.fromObject(HttpRequest.sendGet(tokenUrl, para)).getString("access_token");
	}

	public void msgResolver(MsgCallbackHandler msgCallbakHandler) {
		refreshToken();
		String url = materialTableUrl + "?access_token=" + token;
		JSONObject reqObj, respObj, item, content, news_item;
		JSONArray items, news_items;
		String msgUrl, title, summary, thumbMediaId;
		reqObj = new JSONObject();
		reqObj.element("type", "news");
		int totalCount = MAX;
		Pattern pattern = Pattern.compile(summaryReg);
		Msg msg = new Msg();
		for (int k = 0; k * 20 < totalCount; k++) {
			reqObj.element("offset", k * 20);
			reqObj.element("count", 20);
			respObj = JSONObject.fromObject(HttpRequest.sendPost(url, reqObj));
			if (totalCount == MAX) {
				totalCount = respObj.getInt("total_count");
			}
			items = respObj.getJSONArray("item");
			for (int item_num = 0; item_num < items.size(); item_num++) {
				item = items.getJSONObject(item_num);
				content = item.getJSONObject("content");
				news_items = content.getJSONArray("news_item");
				for (int news_num = 0; news_num < news_items.size(); news_num++) {
					news_item = news_items.getJSONObject(news_num);

					msgUrl = news_item.getString("url");
					title = news_item.getString("title");
					System.out.println(title);
					thumbMediaId = news_item.getString("thumb_media_id");
					summary = news_item.getString("content");
					Matcher matcher = pattern.matcher(summary);
					if (matcher.matches())
						summary = matcher.group(2);
					if (summary.length() > 280)
						summary = summary.substring(0, 280);
					msg.setMsgUrl(msgUrl);
					msg.setTitle(title);
					msg.setThumbMediaId(thumbMediaId);
					msg.setSummary(summary);
					msgCallbakHandler.processMsg(msg);

				}
			}
		}

	}

	public void downloadImg(String thumbMediaId, String path) {
		String url = materialUrl + "?access_token=" + token;
		JSONObject reqObj = new JSONObject();
		reqObj.element("media_id", thumbMediaId);
		PrintWriter out = null;
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.println(reqObj.toString());
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应

			inputStream = conn.getInputStream();
			byte[] data = new byte[1024];
			int len = 0;
			String prefix;
			// prefix =
			// "/Users/wing/Project/cloud-platform/publicwechat/src/main/webapp/msgImg/";//
			// eclipse
			prefix = path + "msgImg\\";// windows
			// prefix = path + "msgImg/";// Linux
			// System.out.println(prefix + thumbMediaId + ".jpeg");
			fileOutputStream = new FileOutputStream(prefix + thumbMediaId + ".jpeg");
			while ((len = inputStream.read(data)) != -1) {
				fileOutputStream.write(data, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
