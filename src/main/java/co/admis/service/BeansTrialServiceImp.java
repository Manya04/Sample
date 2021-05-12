/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.BeansTrialDao;
import co.admis.model.Login;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author manyaagarwal
 */
public class BeansTrialServiceImp implements BeansTrialService{
    @Autowired
    BeansTrialDao beansTrialDao;
    
    @Override
    public int add(int a, int b) {
    return beansTrialDao.add(a,b);
    }

    @Override
    public int subtract(int a, int b) {
    return beansTrialDao.subtract(a,b);
    }    

    @Override
    public Login user(Login login) {
       return beansTrialDao.user(login);
    }

    
}
