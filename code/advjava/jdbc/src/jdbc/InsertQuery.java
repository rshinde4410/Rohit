package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertQuery {
	public static void main(String[] args) {
		
		String query = "insert into product values(101, 'A', 23423.3, 5),(102, 'C', 565.3, 4),(212, 'D', 7543.3, 10);";
		
		try {
			// 1. Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");// oracle.jdbc.driver.OracleDriver
			// 2. Create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava1june","root","root");
			// 3. create Statement
			Statement stmt = con.createStatement();
			// 4. Execute Statement
			//int count = stmt.executeUpdate("create table product(id int, name varchar(20), price double, qty int)");
			int count = stmt.executeUpdate(query);
			// 5. close connection
			stmt.close();
			con.close();
			
			System.out.println(count + " : rows Affected...");	
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
