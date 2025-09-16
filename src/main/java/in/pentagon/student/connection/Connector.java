package in.pentagon.student.connection;

//Factory class which delivers con ref Object
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public static Connection requestConnection() {
		Connection con=null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return con;
	}
}
