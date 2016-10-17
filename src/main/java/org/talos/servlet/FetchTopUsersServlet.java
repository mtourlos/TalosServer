package org.talos.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.talos.po.User;
import org.talos.queries.FetchTopUsersQuery;

/**
 * Servlet for fetching top {@link User}s
 */
public class FetchTopUsersServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FetchTopUsersQuery q = new FetchTopUsersQuery();
		Set<User> results;
		try {
			results = q.fetchUsers();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		JSONObject j = new JSONObject();
		j.put("users", results);
		
		resp.setContentType("application/json");
		resp.getWriter().println(j);
		resp.getWriter().flush();
	}
	
}
