package org.talos.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.talos.po.Data;
import org.talos.utils.SqlUtil;

/**
 * Fetches all the {@link Data} from the database
 */
public class FetchDataQuery {
	
	/**
	 * Main method
	 * 
	 * @return a set of {@link Data}
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public Set<Data> fetchData() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		SqlUtil sqlUtil = new SqlUtil();
		String q = "SELECT * FROM DATA;";
		Connection connection = sqlUtil.connectToDatabase();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(q);
		Set<Data> results = new HashSet<Data>();
		while(rs.next()){
			Data d = new Data();
			d.setCinr(rs.getInt("CINR"));
			d.setId(rs.getInt("ID"));
			d.setLatitude(rs.getFloat("LATITUDE"));
			d.setLongitude(rs.getFloat("LONGITUDE"));
			d.setNetworkType(rs.getString("NETWORK_TYPE"));
			d.setOperator(rs.getString("OPERATOR"));
			d.setTimestamp(rs.getTimestamp("TIME_STAMP"));
			d.setEmail(rs.getString("EMAIL"));
			results.add(d);
		}
		sqlUtil.disconnectFromDatabase(connection);
		return results;
	}

}
