package com.aits.apps;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aits.dao.AjaxAppDao;
import com.google.gson.Gson;

@WebServlet("/StateServlet")
public class StateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String countryId = request.getParameter("countryId");
		AjaxAppDao dao = new AjaxAppDao();
		Map<Integer, String> statesMap = dao.getStatesMap(Integer.parseInt(countryId));
		System.out.println(statesMap);
		Gson json = new Gson();
		String statesString = json.toJson(statesMap);
		response.setContentType("text/html");
		response.getWriter().write(statesString);
	}

}
