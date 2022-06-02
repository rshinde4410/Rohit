package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUserValues {
	public static void main(String[] args) {
		String driver = PropertyLoader.getValue("driver");
		String url = PropertyLoader.getValue("url");
		String userName = PropertyLoader.getValue("user");
		String pass = PropertyLoader.getValue("password");
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, userName, pass);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Id : ");
			int id = scan.nextInt();
			
			PreparedStatement stmt = con.prepareStatement("delete from product where id=?");
			stmt.setInt(1, id);
			
			int count = stmt.executeUpdate();
			
			
			con.close();
			System.out.println(count + " : rows Deleted");

		} catch(Exception ex) {
			ex.printStackTrace();
		} 
	}
}
