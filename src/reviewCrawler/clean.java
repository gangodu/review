package reviewCrawler;

import java.sql.*;

public class clean {

	public class DB {
		 
		public Connection conn = null;
	 
		public DB() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:8889/review";
				conn = DriverManager.getConnection(url, "root", "root");
				System.out.println("- - - - Local MySQL Connected - - - -");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	 
		public ResultSet runSql(String sql) throws SQLException {
			Statement sta = conn.createStatement();
			return sta.executeQuery(sql);
		}
	 
		public boolean runmySql(String sql) throws SQLException {
			Statement sta = conn.createStatement();
			return sta.execute(sql);
		}
	 
		@Override
		protected void finalize() throws Throwable {
			if (conn != null || !conn.isClosed()) {
				conn.close();
			}
		}
	}
	
	public clean() {
	}
}
