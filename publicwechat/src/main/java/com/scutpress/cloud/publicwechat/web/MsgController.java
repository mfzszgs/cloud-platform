package com.scutpress.cloud.publicwechat.web;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scutpress.cloud.publicwechat.domain.Msg;
import com.scutpress.cloud.publicwechat.service.MsgService;
import com.scutpress.cloud.publicwechat.service.OfficialService;

@Controller
public class MsgController {
	@Autowired
	private MsgService msgService;
	@Autowired
	private OfficialService officialService;

	@RequestMapping(value = "/msg.html")
	public ModelAndView getMsgTable(HttpServletRequest request, MsgCommand msgCommand) {
		// officialService.syncMsg();
		int typeNum = msgCommand.getType();// 1-7
		List<Msg> list = msgService.getMsgTable(typeNum);
		List<String> typeList = msgService.getAllType();
		String title = typeList.get(typeNum - 1);// 0-6
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("title", title);
		return new ModelAndView("msg");
	}

	// @RequestMapping(value = "/admin.html")
	// public ModelAndView getAdminTable(HttpServletRequest request) {
	//
	// // String path =
	// // request.getSession().getServletContext().getRealPath("");
	// // officialService.syncMsg(path);
	//
	// List<List<Msg>> listList = new LinkedList<List<Msg>>();
	// List<String> typeTable = msgService.getAllType();
	//
	// for (int i = 1; i <= typeTable.size(); i++) {
	// listList.add(msgService.getMsgTable(i));
	// }
	// request.getSession().setAttribute("listList", listList);
	// request.getSession().setAttribute("typeList", typeTable);
	//
	// return new ModelAndView("admin");
	// }

	// @RequestMapping(value = "/submit.html")
	
	@RequestMapping(value = "/admin.html")
	public ModelAndView getSubmitTable(HttpServletRequest request) {

		Enumeration<String> names = request.getParameterNames();
		for (; names.hasMoreElements();) {
			String name = names.nextElement();// ID
			String value = request.getParameter(name);// type
			msgService.changeMsgTypeById(Integer.parseInt(name), Integer.parseInt(value));
		}
		// form

		List<List<Msg>> listList = new LinkedList<List<Msg>>();
		List<String> typeTable = msgService.getAllType();

		for (int i = 1; i <= typeTable.size(); i++) {
			listList.add(msgService.getMsgTable(i));
		}
		request.getSession().setAttribute("listList", listList);
		request.getSession().setAttribute("typeList", typeTable);
		return new ModelAndView("admin");
	}

	@RequestMapping(value = "/sync.html")
	public ModelAndView getSyncTable(HttpServletRequest request) {

		String path = request.getSession().getServletContext().getRealPath("");
		officialService.syncMsg(path);
		//sync

		List<List<Msg>> listList = new LinkedList<List<Msg>>();
		List<String> typeTable = msgService.getAllType();
		for (int i = 1; i <= typeTable.size(); i++) {
			listList.add(msgService.getMsgTable(i));
		}
		request.getSession().setAttribute("listList", listList);
		request.getSession().setAttribute("typeList", typeTable);
		return new ModelAndView("admin");
	}
}
