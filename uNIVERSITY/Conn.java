package uNIVERSITY;

import java.sql.*;
public class Conn {
	Connection c;
	Statement s;
Conn (){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","1234");//Connection string
	s=c.createStatement();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
