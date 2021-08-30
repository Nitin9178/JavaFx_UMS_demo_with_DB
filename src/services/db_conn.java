
package services;
import java.sql.*;
public class db_conn {
  private static Connection con;
  public static Connection getConnection() throws ClassNotFoundException
  {
      try
     {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info", "root", "Nitin@123");
     }
     catch(SQLException es){}
      return con;
  }
}
