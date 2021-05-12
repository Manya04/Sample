/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.dao;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author AKASH
 */
public class CommonMethodsDaoImpl implements CommonMethodsDao{

    @Override
    public String getCurrentDate() {
        ZonedDateTime d = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        String[] date = d.toString().split("T");
        return date[0];
    }

    @Override
    public String getCurrentTime() {
        ZonedDateTime d = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        String[] date = d.toString().split("T");
        String[] time = date[1].split(("\\."));
        System.out.println(time);
        return time[0];
    }
}
