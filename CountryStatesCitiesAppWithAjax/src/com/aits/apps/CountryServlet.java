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

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AjaxAppDao dao = new AjaxAppDao();
		Map<Integer, String> countryMap = dao.getCountriesMap();
		Gson json = new Gson();
		String countriesString = json.toJson(countryMap);
		response.setContentType("text/html");
		response.getWriter().write(countriesString);

	}
}
