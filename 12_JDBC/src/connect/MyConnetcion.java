package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyConnetcion {

	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String user = "SCOTT";
	private static String password = "TIGER";
	
	public static Connection getConnection() throws Exception{
		Class.forName("");
		return DriverManager.getConnection(url, user, password);
	}
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(con != null) con.close();
			if(ps != null) con.close();
			if(rs != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
