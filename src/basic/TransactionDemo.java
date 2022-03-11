package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","mirdu","Sooraj@nov2013");
			Scanner ip = new Scanner(System.in);
			Statement st = con.createStatement();
		//	float bal = 0.0f;
			System.out.println("Enter the account number of the Withdrawer: ");
			int accno = ip.nextInt();
			System.out.println("Enter the amount to be Withdrawn: ");
			float amt = ip.nextFloat();
			String query = "select balance from accoun where accno="+accno;
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			{
				if(rs.getFloat(1)>=amt)
				{
					con.setAutoCommit(false);
					query = "update accoun set balance = balance - "+amt+ "where accno = "+accno;
					int row = st.executeUpdate(query);
					System.out.println("Are you sure?(0/1):");
					int opt = ip.nextInt();
					if(opt==1 && row==1)
					{
						con.commit();
						System.out.println("Success....");
					}
					else
					{
						con.rollback();
						System.out.println("Failure...");
					}
				}
				else
				{
					System.out.println("Insufficient Balance");
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
