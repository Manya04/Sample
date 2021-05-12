/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import co.admis.model.Login;

/**
 *
 * @author manyaagarwal
 */
public interface BeansTrialDao {
    public int add(int a, int b);
    public int subtract(int a, int b);
    public Login user(Login login);
}


