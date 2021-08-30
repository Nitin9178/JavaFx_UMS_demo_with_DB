package services;
import java.sql.*;
public class user_action {
   Connection con;
   
   public user_action(Connection con)
   {
       this.con = con;
   }
   
   public user login_user(String mail, String pass) throws SQLException
   {
       user user = null;
       String query =  "select * from users where mail = ? and pass = ?";
       PreparedStatement pt = this.con.prepareStatement(query);
       pt.setString(1,mail);
       pt.setString(2,pass);
       ResultSet rs = pt.executeQuery();
       if(rs.next())
       {
          String name = rs.getString("name");
          String email = rs.getString("mail");
          String phone = rs.getString("phone");
          
          user = new user(name,email,phone);
       }
       return user;
   }
   
   public int create_logs(String name, String mail) throws SQLException
   {
       int i = 0;
       String query = "insert into user_logs(user_name,user_mail)values(?,?)";
       PreparedStatement pt = this.con.prepareStatement(query);
       pt.setString(1, name);
       pt.setString(2,mail);
       i = pt.executeUpdate();
       return i;
   }
   
   
   public int register_user(user user) throws SQLException
   {
       int i = 0;
       String query =  "insert into users(name,mail,pass,phone)values(?,?,?,?)";
       PreparedStatement pt = this.con.prepareStatement(query);
       String name = user.getName();
       String mail = user.getMail();
       String pass = user.getPassword();
       String phone = user.getContact();
       pt.setString(1,name);
       pt.setString(2,mail);
       pt.setString(3,pass);
       pt.setString(4,phone);
       i =  pt.executeUpdate();
       return i;
   }
   
    public boolean check_user(String mail, String phone) throws SQLException
   {
       boolean bool = false;
       String query =  "select * from users where mail = ? or phone = ?";
       PreparedStatement pt = this.con.prepareStatement(query);
       pt.setString(1,mail);
       pt.setString(2,phone);
       ResultSet rs = pt.executeQuery();
       if(rs.next())
       {
           bool = true;
       }
       return bool;
   }
    
    public user get_user_detail(String mail) throws SQLException
    {
        user user = null;
        String query = "select * from users where mail = ?";
        PreparedStatement pt = this.con.prepareStatement(query);
        pt.setString(1, mail);
        ResultSet rs = pt.executeQuery();
        if(rs.next())
        {
            user = new user();
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("mail"));
            user.setPhone(rs.getString("phone"));  
        }
        return user;
    }
    
    public int change_password(String mail, String pass) throws SQLException
    {
        String query = "update users set pass = ? where mail = ?";
        PreparedStatement pt = this.con.prepareStatement(query);
        pt.setString(1,pass);
        pt.setString(2,mail);
        int i =  pt.executeUpdate();
        return i;
    }
    
    public int update_basic(String name , String mail , String contact) throws SQLException
    {
        String query = "update users set name = ? , phone = ? where mail = ?";
        PreparedStatement pt = this.con.prepareStatement(query);
        pt.setString(1,name);
        pt.setString(2,contact);
        pt.setString(3,mail);
        int i =  pt.executeUpdate();
        return i;
    }
}
