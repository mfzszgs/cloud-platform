import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class JSONToXml {
	private static final String STR_JSON = "{\"name\":\"Michael\",\"address\":{\"city\":\"shanghai\",\"street\":\" Changjiang Road \",\"postcode\":100025},\"blog\":\"http://cross.withiter.com\"}";

	public static String xml2JSON(String xml) {
		return new XMLSerializer().read(xml).toString();
	}

	public static String json2XML(String json) {
		JSONObject jobj = JSONObject.fromObject(json);
		String xml = new XMLSerializer().write(jobj);
		return xml;
	}

	public static void main(String[] args) {
		String xmlStr = "<zone-policy><zone class=\"dmz\"><from>private<firewall><name>1</name></firewall></from><interface>eth1</interface></zone><zone class=\"private\"><interface>eth0</interface></zone></zone-policy>";
		;
		String json = xml2JSON(xmlStr);
		System.out.println("json=" + json);
		// String xml = json2XML(STR_JSON);
		// System.out.println("xml = "+xml);
		// String json = xml2JSON(xml);
		// System.out.println("json="+json);
	}
}