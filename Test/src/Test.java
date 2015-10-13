import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		// 发送 GET 请求
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		String para = "grant_type=client_credential&appid=wx70319e81317974eb&secret=46ef2044535f4b7361c6ad8e569512c2";
		String s = HttpRequest.sendGet(url, para);
		// System.out.println(s);

		JSONObject jb, item, content, news_item;
		JSONArray items, news_items;
		jb = JSONObject.fromObject(s);
		String token = jb.getString("access_token");
		System.out.println(token);

		// 发送 POST 请求
		url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=" + token;
		JSONObject obj = new JSONObject();
		obj.element("type", "news");
		obj.element("offset", 0);
		obj.element("count", 20);
		String sr = HttpRequest.sendPost(url, obj);
		System.out.println(sr);
		jb = JSONObject.fromObject(sr);
		items = jb.getJSONArray("item");
		String media_id = null;
		for (int item_num = 0; item_num < items.size(); item_num++) {
			item = items.getJSONObject(item_num);
			content = item.getJSONObject("content");
			news_items = content.getJSONArray("news_item");
			for (int news_num = 0; news_num < items.size(); news_num++) {
				news_item = news_items.getJSONObject(news_num);
				url = news_item.getString("url");
				media_id = news_item.getString("thumb_media_id");
				System.out.println(url);
				System.out.println(media_id);
			}
		}

		JSONObject obj2 = new JSONObject();
		obj2.element("media_id", media_id);

		url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=" + token;
		obj = obj2;
		PrintWriter out = null;
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			// MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.println(obj.toString());
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应

			inputStream = conn.getInputStream();
			byte[] data = new byte[1024];
			int len = 0;
			fileOutputStream = new FileOutputStream("./1.jpeg");
			System.out.println(System.getProperty("user.dir"));
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}