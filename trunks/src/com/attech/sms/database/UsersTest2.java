/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.database;

import static com.attech.sms.database.UsersTest.digest;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.attech.sms.database.entities.Users;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
/**
 *
 * @author anhth
 */
public class UsersTest2 {
    private static SessionFactory factory; 
    
    public static void main(String[] args) {
        try {
            factory = new Configuration().configure(new File("database.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
        UsersTest2 ME = new UsersTest2();
        
        //Integer i = ME.addEmployee("huanpv", "", "Phạm Văn Huấn", 2);
        //System.out.println(i);
       // ME.listAll();
       
       Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List listUsers = session.createQuery("FROM Users").list(); 
         for (Iterator iterator = 
                           listUsers.iterator(); iterator.hasNext();){
            Users user = (Users) iterator.next(); 
            System.out.print("Id: " + user.getId()); 
            System.out.print("  Username: " + user.getUsername()); 
            System.out.print("  Password: " + user.getPassword()); 
            System.out.println("  Fullname: " + user.getFullname()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
    }
    
    public void listAll( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List listUsers = session.createQuery("from users").list(); 
         for (Iterator iterator = 
                           listUsers.iterator(); iterator.hasNext();){
            Users user = (Users) iterator.next(); 
            System.out.print("Id: " + user.getId()); 
            System.out.print("  Username: " + user.getUsername()); 
            System.out.print("  Password: " + user.getPassword()); 
            System.out.println("  Fullname: " + user.getFullname()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
    
    public Integer addEmployee(int id, String name, String pass, String fname, int groupid){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer UserId = null;
      try{
         tx = session.beginTransaction();
         Users employee = new Users(id, name, pass, fname, groupid);
         UserId = (Integer) session.save(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return UserId;
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
