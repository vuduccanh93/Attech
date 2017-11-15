/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.attech.sms.database;

import com.attech.sms.database.entities.UserGroups;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author anhth
 */
public class UserGroupsDao extends Base{
    
    public boolean clear() {
        return super.execute("DELETE FROM usergroups;");
    }
    
    public synchronized boolean save(List<UserGroups> groups) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            for (UserGroups group : groups) {
                session.saveOrUpdate(group);
            }
            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }
    }
    
    public synchronized boolean remove(List<UserGroups> groups) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            for (UserGroups group : groups) {
                session.delete(group);
            }
            session.getTransaction().commit();
            return true;
        } finally {
            session.close();
        }
    }
    
}
