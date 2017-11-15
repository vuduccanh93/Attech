package com.attech.sms.database;

import java.io.File;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Base {
    
    // private static final Logger logger = Logger.getLogger(Base.class);
    private static SessionFactory sessionFactory ;
    // private static String configFile = "";
    protected static Configuration configuration;

    /**
     * Set configure to connect to DB
     * @param file 
     */
    public static void configure(String file) {
        // final File configFile = file;
        configuration = new Configuration();
        configuration.configure(new File(file));
        // getSessionFactory(true);
    }
   
    /**
     * Open session factory
     * @return 
     */
    public synchronized Session openSession() {
        // if (sessionFactory == null) {
        // System.out.println("Session null");
        // sessionFactory = getSessionFactory(true);
        // }
        //try {
        return getSessionFactory(false).openSession();
        //return session;
        // } catch (HibernateException ex) {
        // ExceptionHandler.handle(ex);
        // sessionFactory = getSessionFactory(true);
        // Session session = sessionFactory.openSession();
        // return session;
        // }
    }
    
    /**
     * Create session factory to connect to DB
     * @param refresh to create a new connection
     * @return 
     */
    protected synchronized static SessionFactory getSessionFactory(boolean refresh) {
        if (refresh || sessionFactory == null) {
            if (sessionFactory != null && !sessionFactory.isClosed()) { sessionFactory.close(); }
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            /*
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();// buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
            */
        }
        
        return sessionFactory;
    }
    
    /**
     * Create session factory
     * @return 
     */
    protected synchronized SessionFactory getSessionFactory() {
        return getSessionFactory(false);
    }
    
    /**
     * Fetching database
     * @param sql query clause
     * @return 
     */
    protected List find(String sql) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery(sql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;

        } catch (HibernateException ex) {
            throw ex;
            // ExceptionHandler.handle(ex);
            // logger.error(ex);
            // return null;
        } finally {
            session.close();
        }
    }
    
    protected boolean execute(String sql) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createSQLQuery(sql);
            q.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (HibernateException ex) {
            throw ex;
            // ExceptionHandler.handle(ex);
            // logger.error(ex);
            // return null;
        } finally {
            session.close();
        }
    }
    
    /*
    protected List find2(String sql) {
        try {
            Session session = openSession();
            session.beginTransaction();
            Query q = session.createQuery(sql);
            List resultList = q.list();
            session.getTransaction().commit();
            session.close();
            return resultList;
            
        } catch (HibernateException ex) {
            ExceptionHandler.handle(ex);
            logger.error(ex);
            return null;
        }
    }
    */
    
    /**
     * Fetching with limited result
     *
     * @param sql
     * @param maxResult
     * @return
     */
    protected List find(String sql, int maxResult) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery(sql);
            query.setMaxResults(maxResult);
            List resultList = query.list();
            session.getTransaction().commit();
            return resultList;

        } catch (HibernateException ex) {
            throw ex;
            // ExceptionHandler.handle(ex);
            // logger.error(ex);
            // return null;
        } finally {
            session.close();
        }
    }

    /**
     * Fetching with parameter
     * @param sql
     * @param parameters
     * @return 
     */
    protected List find(String sql, Parameter[] parameters) {
        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery(sql);

            if (parameters != null && parameters.length > 0) {
                for (Parameter p : parameters) {
                    q.setParameter(p.getKey(), p.getValue());
                }
            }

            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
            
        } catch (HibernateException ex) {
            // ExceptionHandler.handle(ex);
            // logger.error(ex);
            // return null;
            throw ex;
        } finally {
            session.close();
        }
    }
    
    /**
     * Query database with share session
     * @param sql
     * @param session
     * @return 
     */
    /*
    protected List find(String sql, Session session) {
        try {
            Query q = session.createQuery(sql);
            List resultList = q.list();
            return resultList;
        } catch (HibernateException ex) {
            ExceptionHandler.handle(ex);
            logger.error(ex);
            return null;
        }
    }
    */
    
    /**
     * Write object to database
     * @param object 
     * @return  
     */
    protected boolean save(Object object) {
        Session session = getSessionFactory().openSession();
        try {
            
            session.beginTransaction();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
            return true;
            
        } finally {
            session.close();
        }
    }
    
    /**
     * Update object in database
     * @param object 
     */
    /*
    protected void udpate(Object object) {
        try {
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            ExceptionHandler.handle(ex);
            logger.error(ex);
        }
    }
    */

    /**
     * Delete object from database
     * @param object 
     */
    protected boolean delete(Object object) {
        Session session = getSessionFactory().openSession();
        try {

            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            session.close();
        }
    }

    /**
     * Insert or delete object
     * @param object 
     */
    /*
    protected void saveOrUpdate(Object object) {
        try {
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException ex) {
            ExceptionHandler.handle(ex);
            logger.error(ex);
        }
    }
    */
}
