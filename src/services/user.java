package services;

public class user {
   private int user_id;
   private String username;
   private String mail;
   private String contact;
   private String password;
   
   public user(){}
   
   public user(int user_id,String username,String mail,String contact,String password)
   {
       this.user_id = user_id;
       this.username = username;
       this.mail = mail;
       this.contact = contact;
       this.password = password;
   }
   
    public user(String username,String mail,String contact,String password)
   {
       
       this.username = username;
       this.mail = mail;
       this.contact = contact;
       this.password = password;
   }
   
   public user(String username,String mail,String contact)
   {
       this.username = username;
       this.mail = mail;
       this.contact = contact;
   }
   
   public user(String mail,String contact)
   {
       this.mail = mail;
       this.contact = contact;
   }
   
   public int getId()
   {
       return user_id;
   }
   
   public String getName()
   {
       return username;
   }
   
   public String getMail()
   {
       return mail;
   }
   
   public String getContact()
   {
       return contact;
   }
   
   public String getPassword()
   {
       return password;
   }
   
   public void setId(int user_id)
   {
       this.user_id = user_id;
   }
   
   public void setName(String username)
   {
       this.username = username;
   }
   
   public void setEmail(String mail)
   {
       this.mail = mail;
   }
   
   public void setPhone(String contact)
   {
       this.contact = contact;
   } 
   
   public void setPassword(String password)
   {
       this.password = password;
   }
}
