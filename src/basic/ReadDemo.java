package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","mirdu","Sooraj@nov2013");
			Statement st = con.createStatement();
			//String query = "select * from purchase;";
			//String query = "select pid,prd_id from purchase;";
			String query = "select pname from product where prd_id=304;";
			ResultSet rs = st.executeQuery(query);
			System.out.println("Purchase Table Details:");
			while(rs.next())
			{
				/*System.out.println("Purchase id: "+rs.getInt(1)+" Product id: "+rs.getInt(2)+ 
						" Quantity: "+rs.getInt(3)+ " Price: "+rs.getFloat(4)+" Purchase Date: "+rs.getDate(5)+" Total Amount: "+(rs.getInt(3)*rs.getFloat(4)));*/
				/*System.out.println("Purchase id: "+rs.getInt(1)+" Product id: "+rs.getInt(2)+ " Total Amount: "+(rs.getInt(3)*rs.getFloat(4)));*/
				System.out.println(rs.getString(1).toUpperCase());
			}
			System.out.println("Completed..");
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
