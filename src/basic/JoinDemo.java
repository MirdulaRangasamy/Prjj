package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JoinDemo {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","mirdu","Sooraj@nov2013");
			Statement st = con.createStatement();
			//String query = "select * from student left join course on course.course_id = student.course_id;";
			//String query = "select * from student right join course on course.course_id = student.course_id;";
			//String query = "select * from student full join course on course.course_id = student.course_id;";
			//String query = "select * from student inner join course on course.course_id = student.course_id;";
			String query = " select * from student cross join course;"; 
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
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
