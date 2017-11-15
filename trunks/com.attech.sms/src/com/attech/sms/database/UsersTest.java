/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.database;

import com.attech.sms.database.entities.Users;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
/**
 *
 * @author anhth
 */
public class UsersTest {
    
    private final static String LOG_FILE = "log4j.properties.xml";
    static final Logger logger = Logger.getLogger(UsersTest.class);
    
    public static void main(String args[]){
//        DOMConfigurator.configure(LOG_FILE);
//        
//        logger.debug("Sample debug message");
//        logger.info("Sample info message");
//        logger.warn("Sample warn message");
//        logger.error("Sample error message");
//        logger.fatal("Sample fatal message");
        
        Base.configure("database.xml");
        SelectUser("anhth","anhth");
    }
    
    private static void SelectUser(String s1, String s2){
        UsersDao dao = new UsersDao();
        List<Users> list = dao.getUsers(s1, s2);
        //List<Users> list = dao.getAllUser();
        if (list !=null && list.size() > 0)
            for (Users user: list)
                System.out.println(user.toString());
        else
            System.out.println("No data!");
    }
    
    
    
    private void InsertUser(){
        Users user = new Users();
        
        user.setId(3);
        user.setUsername("andh");
        String txtPassword = "andh";
        String encodePass = digest(txtPassword);
        user.setPassword(encodePass);
        
        user.setFullname("Đỗ Hoàng An");
        user.setUserGroupId(2);
        user.setLastLogin(new Date());
        user.setUserStatus(1);
        
        UsersDao dao = new UsersDao();
        dao.save(user);
        
        System.out.println("Insert OK");
    }
    
    private static String encodeHex(byte[] digest) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static String digest(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] buffer = input.getBytes("UTF-8");
            md.update(buffer);
            byte[] digest = md.digest();
            return encodeHex(digest);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return e.getMessage();
        }   
    }
}
