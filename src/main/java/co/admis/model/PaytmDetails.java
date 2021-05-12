/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.model;

/**
 *
 * @author manyaagarwal
 */
public class PaytmDetails {
    private String mid;
    private String orderId;
    private String txnToken;

    public PaytmDetails() {
    }

    public PaytmDetails(String mid, String orderId, String txnToken) {
        this.mid = mid;
        this.orderId = orderId;
        this.txnToken = txnToken;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTxnToken() {
        return txnToken;
    }

    public void setTxnToken(String txnToken) {
        this.txnToken = txnToken;
    }
    
}
