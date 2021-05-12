   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.database.HibernateUtil;
import co.admis.model.Login;
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
public class BeansTrialDaoImp implements BeansTrialDao {

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        
        return a-b;
        
    }

    @Override
    public Login user(Login login) {
        System.out.println("reach"); 
        System.out.println(login); 
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction;
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Login> criteria =  builder.createQuery(Login.class);
            Root<Login> root = criteria.from(Login.class);
            System.out.println("apple");
            criteria.where(builder.and(builder.equal(root.get("username"), login.getUsername() ),builder.equal(root.get("password"), login.getPassword())));
            TypedQuery<Login> typed = session.createQuery(criteria);
            Login result = typed.getSingleResult();
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

    
    
}
