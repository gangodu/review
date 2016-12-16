package crawl;

import java.sql.*;

/**
 * Created by praveen on 12/14/16.
 */
@SuppressWarnings({"ALL", "unused", "DefaultFileTemplate"})
class DBConnect {
    private final String mysql_port = "3306";
    private final String mysql_host = "localhost";
    private final String jdbc_mysql_URL = "jdbc:mysql://";
    private final String jdbc_mysql_driver = "com.mysql.jdbc.Driver";
    private Connection conn;

    private String mysql_database;
    private String mysql_table;
    private String mysql_username;
    private String mysql_password;

    public DBConnect() {
        mysql_database = "/crawls";
        mysql_table = "/links";
        mysql_username = "user";
        mysql_password = "password";

        String mysql_dbConnect = jdbc_mysql_URL + mysql_host + ":" + mysql_port + mysql_database + mysql_table;

        conn = null;
        try {
            Class.forName(jdbc_mysql_driver);
            conn = DriverManager.getConnection(mysql_dbConnect, mysql_username, mysql_password);
            System.out.println("****** MySQL LocalHost Connected ******");
        } catch (SQLException e) {
            System.out.println("****** MySQL LocalHost SQL-Exception ******" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("****** MySQL LocalHost CNF-Exception ******" + e.getMessage());
        }
    }

    public ResultSet runSql(String sql) throws SQLException {
        Statement sqlStatement = conn.createStatement();
        return sqlStatement.executeQuery(sql);
    }

    public boolean runmySql(String sql) throws SQLException {
        Statement mysqlStatement = conn.createStatement();
        return mysqlStatement.execute(sql);
    }

    @Override
    protected void finalize() throws Throwable {
        if (conn == null) throw new AssertionError();
        if (conn != null || !conn.isClosed()) {
            conn.close();
        }
    }
}
