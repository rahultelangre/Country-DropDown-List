package com.aits.apps;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aits.dao.AjaxAppDao;
import com.google.gson.Gson;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String stateId = request.getParameter("stateId");
		AjaxAppDao dao = new AjaxAppDao();
		Map<Integer, String> citiesMap = dao.getCitiesMap(Integer.parseInt(stateId));
		Gson json = new Gson();
		String citiesString = json.toJson(citiesMap);
		response.setContentType("text/html");
		response.getWriter().write(citiesString);
	}

}
