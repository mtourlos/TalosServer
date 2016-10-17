package org.talos.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.talos.po.User;
import org.talos.utils.SqlUtil;

/**
 * Fetches the top {@link User}s ordered by points
 */
public class FetchTopUsersQuery {
	
	/**
	 * Users limit
	 */
	private final int TOP_USERS_LIMIT = 10;
	
	/**
	 * Main method
	 * 
	 * @return a set of {@link User}
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public Set<User> fetchUsers() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		SqlUtil sqlUtil = new SqlUtil();
		String q = "select * from USER order by Points DESC limit "+TOP_USERS_LIMIT+";";
		Connection connection = sqlUtil.connectToDatabase();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(q);
		Set<User> results = new HashSet<User>();
		while(rs.next()){
			User u = new User();
			u.setEmail(rs.getString("EMAIL"));
			u.setFirstName(rs.getString("FIRST_NAME"));
			u.setLastName(rs.getString("LAST_NAME"));
			u.setConnectedDate(rs.getDate("CONNECTED_DATE"));
			u.setPoints(rs.getLong("POINTS"));
			results.add(u);
		}
		sqlUtil.disconnectFromDatabase(connection);
		return results;
	}

}
