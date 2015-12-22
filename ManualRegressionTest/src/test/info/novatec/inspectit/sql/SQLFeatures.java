package test.info.novatec.inspectit.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.info.novatec.inspectit.sql.tools.ConnectionFactory;

/**
 * Providing database-tests (SQL)
 * 
 * @author akr
 * 
 */
public class SQLFeatures {
	
	@DataProvider(name="allConnections")
	public Object[][] provideAllConfiguredConnections () {
		Connection[] connections = ConnectionFactory.getAllAvailableConnections();
		Object[][] returned = new Object[connections.length][1];
		
		int i = 0;
		for (Connection connection : connections) {
			returned[i++][0] = connection;
		}
		
		return returned;
	}

	@Test(dataProvider="allConnections")
	public void unpreparedStatement(Connection con) throws SQLException {
		con.createStatement().executeQuery("SELECT * FROM UNPREPARED");
	}

	@Test(dataProvider="allConnections")
	public void preparedStatement(Connection con) throws SQLException {
		con.prepareStatement("SELECT * FROM PREPARED").execute();
	}

	@Test(dataProvider="allConnections")
	public void preparedStatementWithBindParameters(Connection con) throws SQLException {
		PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM PREPARED_PARAM where id1=? and id2=?");
		preparedStatement.setInt(1, 1);
		preparedStatement.setInt(2, 2);
		preparedStatement.execute();
	}

	@Test(dataProvider="allConnections")
	public void preparedStatementInInvocationSequence(final Connection con) {
		class SQLInInvocation {

			public void start() {
				query();
			}

			public void query() {
				try {
					con.prepareStatement("SELECT * FROM PREPARED").execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		new SQLInInvocation().start();

	}
}
