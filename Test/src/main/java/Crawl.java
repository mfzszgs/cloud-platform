import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawl {
	public static void main(String args[]) {
		String url, file, save;
		url = "http://mmbiz.qpic.cn/mmbiz/tJicBErDG76mPaLPM9ibiaFIccgrNsXEGoaJmSuCvE6ZeT3uibrYdgwGrYF0HJooJjxDL1OJy3ib092gQbSZA7ibwOBQ/0?wx_fmt=jpeg";
		file = "picccc.jpeg";
		save = "./";
		new Crawl().imgDownload(url, file, save);
		System.out.println("OK");
		String pageUrl[] = new String[3];
		pageUrl[0] = "http://mp.weixin.qq.com/s?__biz=MzAwMjMzNzIwMw==&mid=209609840&idx=1&sn=09f3813c2ad3485e0c3b7852a60b748a#rd";
		pageUrl[1] = "http://mp.weixin.qq.com/s?__biz=MzAwMjMzNzIwMw==&mid=209592188&idx=1&sn=bd9ef8aed69ef7dcde7e68d277461454#rd";
		pageUrl[2] = "http://mp.weixin.qq.com/s?__biz=MzAwMjMzNzIwMw==&mid=209578950&idx=1&sn=c32c1f583604924bbdb3ab203a4713c5#rd";
		String imgReg = "<img.*?src=\"(http://mmbiz.qpic.cn/mmbiz/.*?)\"";
		String titleReg = "<title>(.*?)</title>";
		String summaryReg = "<div class=\"rich_media_content\" id=\"js_content\">\\s*?<p>(<.*?>)*\\s*(.*?)(<.*?>)*</p>";
		for (int i = 0; i < 3; i++) {
			System.out.println(new Crawl().getMatched(pageUrl[i], imgReg, 1));
			System.out.println(new Crawl().getMatched(pageUrl[i], titleReg, 1));
			System.out.println(new Crawl().getMatched(pageUrl[i], summaryReg, 2));
		}
	}

	public void imgDownload(String imgUrl, String filename, String savePath) {
		// 构造URL
		URL url;
		try {
			url = new URL(imgUrl);
			// 打开连接
			URLConnection con = url.openConnection();
			// 设置请求的路径
			con.setConnectTimeout(5 * 1000);
			// 输入流
			InputStream is = con.getInputStream();

			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			File sf = new File(savePath);
			if (!sf.exists()) {
				sf.mkdirs();
			}
			OutputStream os = new FileOutputStream(sf.getPath() + "/" + filename);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();

			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getMatched(String pageUrl, String reg, int groupNum) {
		StringBuffer sb = new StringBuffer();
		try {
			// 构建一URL对象
			URL url = new URL(pageUrl);
			// 使用openStream得到一输入流并由此构造一个BufferedReader对象
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			String line;
			// 读取www资源
			while ((line = in.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			in.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		String htmls = sb.toString();
		Matcher matcher = Pattern.compile(reg).matcher(htmls);
		if (matcher.find()) {
			return matcher.group(groupNum);
		} else {
			System.out.println(htmls);
			return null;
		}

	}
}
