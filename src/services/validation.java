
package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {
    private static final String mail_regex = "\"^(.+)@(.+)$\"";
    private static final String phone_regex = "^\\d{10}$";
    
   public static boolean email_validation(String email)
   {
       Pattern pattern = Pattern.compile(mail_regex); 
       Matcher matcher = pattern.matcher(email); 
       return matcher.matches();
   }
   
   public static boolean phone_validation(String phone)
   {
       Pattern pattern = Pattern.compile(phone_regex); 
       Matcher matcher = pattern.matcher(phone); 
       return matcher.matches();
   }
}
