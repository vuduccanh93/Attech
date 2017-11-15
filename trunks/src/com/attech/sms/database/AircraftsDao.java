/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.database;

import com.attech.sms.database.entities.Aircrafts;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author anhth
 */
public class AircraftsDao extends Base{
    
    public boolean clear() {
        return super.execute("DELETE FROM aircrafts;");
    }
    
    public synchronized boolean save(List<Aircrafts> crafts) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            for (Aircrafts craft : crafts) {
                session.saveOrUpdate(craft);
            }
            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public synchronized boolean remove(List<Aircrafts> crafts) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            for (Aircrafts craft : crafts) {
                session.delete(craft);
            }
            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public List<Aircrafts> listCrafts(){
        String query = "FROM aircrafts";
        List<Aircrafts> list = (List<Aircrafts>) this.find(query);
        if (list == null || list.isEmpty() ) return null;
        return list;
    }
}
