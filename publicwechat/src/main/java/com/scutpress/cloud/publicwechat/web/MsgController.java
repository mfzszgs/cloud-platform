package com.scutpress.cloud.publicwechat.web;

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

	@RequestMapping(value = "/admin.html")
	public ModelAndView getAdminTable(HttpServletRequest request, MsgCommand msgCommand) {

		String path = request.getSession().getServletContext().getRealPath("");
		officialService.syncMsg(path);

		List<Msg> list;
		list = (List<Msg>) request.getSession().getAttribute("list");
		String[] typeArr = request.getParameterValues("choose");
		if (typeArr != null && list != null)
			msgService.changeMsgType(list, typeArr);

		list = msgService.getMsgTable(1);
		request.getSession().setAttribute("list", msgService.getMsgTable(1));
		request.getSession().setAttribute("typeList", msgService.getAllType());
		return new ModelAndView("admin");
	}
}
