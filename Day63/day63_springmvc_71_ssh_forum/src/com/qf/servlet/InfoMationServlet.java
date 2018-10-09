package com.qf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.entity.InfoMation;
import com.qf.entity.User;
import com.qf.service.IInfoMationService;
import com.qf.service.impl.InfoMationServiceImpl;

/**
 * Servlet implementation class InfoMationServlet
 */
@Controller
@RequestMapping(value = "/infoMationController")
public class InfoMationServlet {

	@Autowired
	private IInfoMationService infService;

	@RequestMapping(value = "/getInfoMationCount")
	@ResponseBody
	public String getInfoMationCount(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		int count = infService.getInfoMationCountByUser(user);
		return count + "";
	}

	@RequestMapping(value = "/getInfoMactionList")
	public String getInfoMactionList(HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		// 1.查询所有消息
		List<InfoMation> infoMations = infService.getInfoMactionList(user);

		if (!infoMations.isEmpty()) {
			// 2.更新消息
			infService.updateInfoMation(user, infoMations);
		}
		request.setAttribute("infoMations", infoMations);
		return "infoMationList";
	}

}
