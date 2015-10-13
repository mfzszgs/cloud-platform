import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.sf.json.JSONObject;

public class SetMenu {
	public static void main(String[] args) {
		// JSONObject menu = new JSONObject();
		// JSONArray buttons = new JSONArray();
		// JSONObject[] button = new JSONObject[3];
		// for (int i = 0; i < 3; i++) {
		// button[i] = new JSONObject();
		// }
		// JSONArray subButtons = new JSONArray();
		// JSONObject[] subButton = new JSONObject[5];
		// for (int i = 0; i < 5; i++) {
		// subButton[i] = new JSONObject();
		// }
		//
		// String names[] = { "板块1", "板块2", "板块3", "板块4", "板块5" };
		// for (int i = 0; i < 5; i++) {
		// subButton[i].element("type", "view");
		// subButton[i].element("name", names[i]);
		// subButton[i].element("url",
		// "http://116.57.78.130:8888/publicwechat/msg.html?type=" + (i + 2));
		// subButtons.add(subButton[i]);
		// }
		// button[0].element(key, value)
		String value = "";
		File file = new File("menu.json");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				value = value + tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		System.out.println(value);

		String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
		String para = "grant_type=client_credential&appid=wx70319e81317974eb&secret=46ef2044535f4b7361c6ad8e569512c2";
		String s = HttpRequest.sendGet(tokenUrl, para);
		String token = JSONObject.fromObject(s).getString("access_token");

		System.out.println(token);
		String menuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create";
		JSONObject obj = JSONObject.fromObject(value);
		String realMenuUrl = menuUrl + "?access_token=" + token;
		String result = HttpRequest.sendPost(realMenuUrl, obj);
		System.out.println(result);

	}
}
