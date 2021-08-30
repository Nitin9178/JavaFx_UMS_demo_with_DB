/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ums;

import java.sql.SQLException;
import java.util.*;
import services.admin_action;
import services.db_conn;
import services.user;


public class demo {
    public static void main(String[] args) throws SQLException , ClassNotFoundException
    {
        List<user> list = new ArrayList();
        admin_action admin_obj = new admin_action(db_conn.getConnection());
        list = admin_obj.get_all_user();
        
        if(!list.isEmpty())
        {
            for(user user:list)
            {
                System.out.println(user.getName()+" "+user.getMail()+" "+user.getContact());
            }
        }
        
    }
}
