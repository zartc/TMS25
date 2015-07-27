package zc.study.struts1.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestJNDICnx {
	Logger logger = LogManager.getLogger();


	public void testDBAccess() throws NamingException, SQLException {
		logger.entry();

		Connection connection = null;
		Statement stmt = null;

		try {
			connection = getConnection();
			stmt = connection.createStatement();

			if (stmt.execute("select * from \"TMS1\".\"CADEAUX\"")) {
				dumpData(stmt);
			}
		}
		finally {
			Utils.closeQuietly(stmt);
			Utils.closeQuietly(connection);
		}

		logger.exit();
	}

	private void dumpData(Statement stmt) throws SQLException {
		logger.entry();

		// Get result set
		ResultSet rs = stmt.getResultSet();

		try {
			// call before r.next() see note 4 above in JDBC hints
			ResultSetMetaData rm = rs.getMetaData();

			int count = rm.getColumnCount();
			while (rs.next()) {
				logger.info("data row");
				for (int i = 1; i <= count; i++) {
					logger.info("    [Column {} : {}] = {}", i, rm.getColumnName(i), rs.getString(i));
				}
			}
		}
		finally {
			Utils.closeQuietly(rs);
		}

		logger.exit();
	}

	public Connection getConnection() throws NamingException, SQLException {
		logger.entry();

		// Get DataSource
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/TMS1-database");
		Connection cnx = ds.getConnection();

		return logger.exit(cnx);
	}
}

/* EOF */
