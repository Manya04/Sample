/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.database;

import co.admis.model.Login;
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
public class HibernateUserAuth {


    public static void main(String[] args) {
        getLogListAdvance();
    }
    

    private static List<Login> getLogListAdvance()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Login> criteria =  builder.createQuery(Login.class);
            Root<Login> root = criteria.from(Login.class);
            criteria.where(builder.and(builder.equal(root.get("username"), "Admin" ),builder.equal(root.get("password"), "Admin")));
            TypedQuery<Login> typed = session.createQuery(criteria);
            List<Login> result = typed.getResultList();
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


    private static Login addRecord(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Login order = new Login(1, "Admin" , "Admin");
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        System.out.println(order);
        return order;
    }
    
}
