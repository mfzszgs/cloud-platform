import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.sf.json.JSONObject;

public class SetOfficeMenu {
	public static void main(String[] args) {

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
