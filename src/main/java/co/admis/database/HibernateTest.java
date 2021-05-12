/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.database;

import co.admis.model.Admin;
import co.admis.model.AdminPermission;
import co.admis.model.Log;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author manyaagarwal
 */
public class HibernateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getAdmin();
        // TODO code application logic here
    }
    
    private static Admin addAdmin()
    {
     Session session = HibernateUtil.getSessionFactory().openSession();
        Admin admin = new Admin("manyaa", "manya", "xyz@gmail.com", "98975432345", "xyz");
        AdminPermission adminPermission = new AdminPermission(admin, "N");
        admin.setAdminPermission(adminPermission);
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        session.close();
        return admin;   
    }
    
    private static List<Admin> getAdmin()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Admin> criteria =  builder.createQuery(Admin.class);
            Root<Admin> root = criteria.from(Admin.class);
            criteria.where(builder.equal(root.get("username"), "manyaa"));
            TypedQuery<Admin> typed = session.createQuery(criteria);
            List<Admin> result = typed.getResultList();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println(result);
            return result;
        }catch(Exception e){
            session.close();
            return null;
        } 
        
    }
    private static Log readRecords()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Log log1 = session.get(Log.class , 1);
        Hibernate.initialize(log1);
        session.close();
        return log1;
    }
    private static List<Log> getLogList()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Log> list = session.createCriteria(Log.class).list();
        System.out.println(list);
        return list;
        //@SuppressWarnings("unchecked")
        
    }
    private static List<Log> getLogListAdvance()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Log> criteria =  builder.createQuery(Log.class);
            Root<Log> root = criteria.from(Log.class);
            criteria.where(builder.equal(root.get("status"), "act"));
            TypedQuery<Log> typed = session.createQuery(criteria);
            List<Log> result = typed.getResultList();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println(result);
            return result;
        }catch(Exception e){
            session.close();
            return null;
        } 
        
    }
    private static Log addRecord(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Log log = new Log(0, "sample", "active", 1);
        session.beginTransaction();
        session.save(log);
        session.getTransaction().commit();
        session.close();
        return log;
    }
    
}
