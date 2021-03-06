package org.talos.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.talos.po.Data;
import org.talos.queries.FetchDataQuery;

/**
 * Servlet for fetching data from the database
 */
public class FetchDataServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FetchDataQuery q = new FetchDataQuery();
		Set<Data> results;
		try {
			results = q.fetchData();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		JSONObject j = new JSONObject();
		j.put("datas", results);
		
		resp.setContentType("application/json");
		resp.getWriter().println(j);
		resp.getWriter().flush();
	}
	
}
