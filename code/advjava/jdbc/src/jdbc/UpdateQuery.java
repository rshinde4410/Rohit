package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateQuery {
	public static void main(String[] args) {
		
		String driver = PropertyLoader.getValue("driver");
		String url = PropertyLoader.getValue("url");
		String userName = PropertyLoader.getValue("user");
		String pass = PropertyLoader.getValue("password");
		
		String updateQuery = "update product set qty=qty-2 where id = 212";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, userName, pass);
			PreparedStatement stmt = con.prepareStatement(updateQuery);
			int result = stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println(result + " : rows updated");

		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
