package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUserValues {
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
			
			System.out.println("Name : ");
			String name = scan.next();
			
			System.out.println("Price : ");
			double price = scan.nextDouble();
			
			System.out.println("Quantity : ");
			int qty = scan.nextInt();
			
			PreparedStatement stmt = con.prepareStatement("insert into product values(?,?,?,?)");
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setDouble(3, price);
			stmt.setInt(4, qty);
			
			int count = stmt.executeUpdate();
			
			
			con.close();
			System.out.println(count + " : rows inserted");

		} catch(Exception ex) {
			ex.printStackTrace();
		} 
	}
}
