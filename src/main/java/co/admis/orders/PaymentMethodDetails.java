/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.orders;

/**
 *
 * @author manyaagarwal
 */
public class PaymentMethodDetails {
    private String paymentMethodDetail;

    public PaymentMethodDetails(String paymentMethodDetail) {
        this.paymentMethodDetail = paymentMethodDetail;
    }

    public String getPaymentMethodDetail() {
        return paymentMethodDetail;
    }

    public void setPaymentMethodDetail(String paymentMethodDetail) {
        this.paymentMethodDetail = paymentMethodDetail;
    }
    
}
