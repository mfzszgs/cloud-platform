import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import net.sf.json.xml.XMLSerializer;

public class Sh2XML {
	public static void main(String[] args) {
		String value = "";
		File file = new File("shell");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				value = value + tempString + " ";
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
		System.out.println("*******************");

		String xmlStr = sh2Xml(value);
		System.out.println(xmlStr);

		String json = new XMLSerializer().read(xmlStr).toString();
		System.out.println(json);

	}

	static String sh2Xml(String shStr) {
		tokens = shStr.split("\\s+");

		String rootValue = "zone-policy";
		Element root = new Element(rootValue);
		i = 0;
		setSh2Xml(root);
		Document doc = new Document(root);
		// 使用JDOM提供的XMLOutputter类输出
		XMLOutputter out = new XMLOutputter();
		// 设置xml文件的Encoding
		out.setFormat(Format.getCompactFormat().setEncoding("gb2312"));
		// 我这里先打印查看一下生成的字符串
		String xmlStr = out.outputString(doc);
		return xmlStr;
	}

	static int i;
	static String tokens[];

	static void setSh2Xml(Element root) {
		Element now = null;
		while (i < tokens.length) {
			if (tokens[i].equals("{")) {
				i++;
				setSh2Xml(now);
				if (i == tokens.length)
					return;
			} else if (tokens[i].equals("}")) {
				i++;
				return;
			} else {
				now = new Element(tokens[i]);
				root.addContent(now);
				i++;
				if (tokens[i].equals("{") || tokens[i].equals("}"))
					continue;
				now.addContent(tokens[i]);
				i++;
			}
		}

	}

}
