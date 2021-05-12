/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.database;

import co.admis.orders.Order;
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
public class HibernateOrderRecord {


    public static void main(String[] args) {
        getLogListAdvance();
        
        
        
        // TODO code application logic here
    }
    
    private static Order readRecords()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Order log1 = session.get(Order.class , 1);
        Hibernate.initialize(log1);
        session.close();
        System.out.println(log1);
        return log1;
    }
    /*
    private static List<Log> getLogList()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Log> list = session.createCriteria(Log.class).list();
        System.out.println(list);
        return list;
        //@SuppressWarnings("unchecked")
        
    }
*/
    private static List<Order> getLogListAdvance()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Order> criteria =  builder.createQuery(Order.class);
            Root<Order> root = criteria.from(Order.class);
            criteria.where(builder.equal(root.get("EasyShipShipmentStatus"), "not delivered"));
            TypedQuery<Order> typed = session.createQuery(criteria);
            List<Order> result = typed.getResultList();
            Hibernate.initialize(result);
            transaction.commit();
            session.close();
            System.out.println("result: "+result);
            return result;
        }catch(Exception e){
            System.out.println(e);
            session.close();
            return null;
        } 
        
    }

    private static Order addRecord(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Order order = new Order(2, "20-02-2021" , "StandarOrder", "2021-02-04T12:09:53.600Z" , "not delivered", "abc@gmail.com" );
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        System.out.println(order);
        return order;
    }
    
}

    

