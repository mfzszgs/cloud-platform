package com.scutpress.cloud.wechat.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scutpress.cloud.wechat.service.CoreService;

public class CoreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CoreServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 这里没有对发送信息者进行验证，直接返回了，要加验证的话自己去百度吧
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String echo = request.getParameter("echostr");
		echo = new String(echo.getBytes("ISO-8859-1"), "UTF-8");
		pw.println(echo);
		// 当你提交成为开发者的URL和Token时，微信服务器将发送GET请求到填写的URL上，
		// 只有你返回参数echostr时，他才会认为你这个接口是通的，才会提交成功
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("收到了东西");
		// 当你用微信给平台发送信息时就会到这里
		CoreService coreService = new CoreService();
		String returnXml = coreService.getResponse(request);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(returnXml);
	}

}
