package com.webservice;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ConDele {
	private static Delegate dele;

	static {
		try {
			URL url = new URL("http://localhost:10101/mysql?wsdl");
			// Qualified name of the service:
			// 1st arg is the service URI
			// 2nd is the service name published in the WSDL
			QName qname = new QName("http://webservice.com/", "DelegateService");
			// Create, in effect, a factory for the service.
			Service service = Service.create(url, qname);
			// Extract the endpoint interface, the service "port".
			dele = service.getPort(Delegate.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Delegate getDele() {
		return dele;
	}

}
