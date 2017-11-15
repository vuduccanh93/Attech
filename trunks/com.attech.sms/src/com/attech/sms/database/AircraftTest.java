/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.database;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.attech.sms.database.entities.Aircrafts;
/**
 *
 * @author anhth
 */
public class AircraftTest {
    
    private static SessionFactory factory; 
    
    public static void main(String[] args) {
        try {
            factory = new Configuration().configure(new File("test.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        AircraftTest ME = new AircraftTest();
        
        ME.listAll();
    }
    
    public void listAll( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List crafts = session.createQuery("FROM Aircrafts").list(); 
         for (Iterator iterator = 
                           crafts.iterator(); iterator.hasNext();){
            Aircrafts craft = (Aircrafts) iterator.next(); 
            System.out.print("Icao24Address: " + craft.getIcao24Address()); 
            System.out.print("  AircraftType: " + craft.getAircraftType()); 
            System.out.println("  RegistrationNo: " + craft.getRegistrationNo()); 
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}
