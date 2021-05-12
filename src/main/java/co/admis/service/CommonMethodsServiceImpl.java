/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.service;

import co.admis.dao.CommonMethodsDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author AKASH
 */
public class CommonMethodsServiceImpl implements CommonMethodsService{

    @Autowired
    CommonMethodsDao commonMethodsDao;
    
   
    @Override
    public String getCurrentDate() {
        return commonMethodsDao.getCurrentDate();
    }

    @Override
    public String getCurrentTime() {
        return commonMethodsDao.getCurrentTime();
    }
    
    
}
