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
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author anhth
 */
public class UsersDao extends Base{
    
    public boolean clear() {
        return super.execute("DELETE FROM users;");
    }
    
    public synchronized boolean save(List<Users> users) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            for (Users user : users) {
                session.saveOrUpdate(user);
            }
            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public synchronized boolean remove(List<Users> users) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            for (Users user : users) {
                session.delete(user);
            }
            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public List<Users> getUsers(String sUsername, String sPassword) {
        String query = String.format("FROM Users WHERE Username = :name AND Password = :pass");
        Parameter[] parameters = new Parameter[]{new Parameter("name", sUsername), new Parameter("pass", digest(sPassword))};
        List<Users> list = (List<Users>) this.find(query, parameters);
        if (list == null || list.isEmpty() ) return null;
        return list;
    }
    
    public List<Users> getAllUser() {
        Session session = getSessionFactory().openSession();

        try {
            session.beginTransaction();
            List resultList = session.createQuery("FROM Users").list();

            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException ex) {
            throw ex;
            //e.printStackTrace();
        } finally {
            session.close();
        }
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
