package services;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class admin_action {
    Connection con;
    public admin_action(Connection con)
    {
        this.con = con;
    }
    
    public boolean login_admin(String mail, String pass) throws SQLException 
    {
        boolean bool = false;
        String query = "select * from admin where admin_email = ? and admin_pass = ?";
        PreparedStatement pt = this.con.prepareStatement(query);
        pt.setString(1,mail);
        pt.setString(2,pass);
        ResultSet rs =  pt.executeQuery();
        if(rs.next())
        {
            bool = true;
        }
        return bool;
    }
    
    public int create_admin_user(user user) throws SQLException
    {
        int i = 0;
        String query = "insert into admin(admin_name,admin_email,admin_contact,admin_pass)values(?,?,?,?)";
        PreparedStatement pt = this.con.prepareStatement(query);
        pt.setString(1,user.getName());
        pt.setString(2,user.getMail());
        pt.setString(3,user.getContact());
        pt.setString(4,user.getPassword());
        i = pt.executeUpdate();
        return i;
    }
  
    
    public boolean check_user_exist(String mail, String phone) throws SQLException
    {
        boolean bool = false;
        String query = "select * from admin where admin_email = ? and admin_contact = ?";
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
        String query = "select * from admin where admin_email = ?";
        PreparedStatement pt = this.con.prepareStatement(query);
        pt.setString(1, mail);
        ResultSet rs = pt.executeQuery();
        if(rs.next())
        {
            user = new user();
            String name = rs.getString("admin_name");
            String email = rs.getString("admin_email");
            String phone = rs.getString("admin_contact");
            user.setName(name);
            user.setEmail(mail);
            user.setPhone(phone);
        }
        return user;
    }
 
    public int delete_user(String mail) throws SQLException
    {
        boolean bool = false;
        String query = "delete from users where mail = ?";
        PreparedStatement pt = this.con.prepareStatement(query);
        pt.setString(1,mail);
        int i = pt.executeUpdate();
        return i;
    }
    
    public int delete_admin(String mail) throws SQLException
    {
        boolean bool = false;
        String query = "delete from admin where admin_email = ?";
        PreparedStatement pt = this.con.prepareStatement(query);
        pt.setString(1,mail);
        int i = pt.executeUpdate();
        return i;
    }
    
    public List get_all_user() throws SQLException
    {
        List<user> list = new ArrayList();
        user user = null;
        String query = "select * from users";
        PreparedStatement pt = this.con.prepareStatement(query);
        ResultSet rs = pt.executeQuery();
        while(rs.next())
        {
            String name = rs.getString("name");
            String mail = rs.getString("mail");
            String number = rs.getString("phone");
            user = new user();
            user.setName(name);
            user.setEmail(mail);
            user.setPhone(number);
            list.add(user);
        }
        
        return list;
    }
}
