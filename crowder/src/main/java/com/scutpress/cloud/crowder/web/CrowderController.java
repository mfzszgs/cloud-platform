package com.scutpress.cloud.crowder.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.scutpress.cloud.crowder.domain.Crowder;
import com.scutpress.cloud.crowder.service.CrowderSerivce;

@Controller
public class CrowderController {
	@Autowired
	private CrowderSerivce crowderService;

	@RequestMapping(value = "/regist.html")
	public ModelAndView getTable(HttpServletRequest request) {

		return new ModelAndView("regist");
	}

	@RequestMapping(value = "/admin.html")
	public ModelAndView getAdminTable(HttpServletRequest request) {

		Crowder crowder = new Crowder();
		crowder.setName((String) request.getParameter("name"));
		crowder.setSex((String) request.getParameter("sex"));
		crowder.setAge(Integer.parseInt(request.getParameter("age")));
		crowder.setOccupation((String) request.getParameter("occupation"));
		crowder.setPhone((String) request.getParameter("phone"));
		crowder.setEmail((String) request.getParameter("email"));
		crowder.setProvice((String) request.getParameter("provice"));
		crowder.setCity((String) request.getParameter("city"));
		crowder.setAddress((String) request.getParameter("address"));
		crowderService.insertCrowder(crowder);
		return new ModelAndView("succeed");
	}
}
