/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.orders;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author manyaagarwal
 */
@Entity
@Table(name="\"OrderRecord\"")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private int id;
    @Column(name = "latestShipDate")
    private String LatestShipDate;
    @Column(name = "orderType")
    private String OrderType;
    @Column(name = "purchasedate")
    private String PurchaseDate;
    
    @Column(name = "status")
    private String EasyShipShipmentStatus;
    @Column(name = "buyerEmail")
    private String BuyerEmail;
    
    public Order()
    {
        
    }
    public Order(int id, String LatestShipDate, String OrderType, String PurchaseDate, String EasyShipShipmentStatus, String BuyerEmail )
    {
        this.id = id;
        this.LatestShipDate = LatestShipDate;
        this.OrderType = OrderType;
        this.PurchaseDate = PurchaseDate;
        this.EasyShipShipmentStatus = EasyShipShipmentStatus;
        this.BuyerEmail = BuyerEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatestShipDate() {
        return LatestShipDate;
    }

    public void setLatestShipDate(String LatestShipDate) {
        this.LatestShipDate = LatestShipDate;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String OrderType) {
        this.OrderType = OrderType;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(String PurchaseDate) {
        this.PurchaseDate = PurchaseDate;
    }

    public String getEasyShipShipmentStatus() {
        return EasyShipShipmentStatus;
    }

    public void setEasyShipShipmentStatus(String EasyShipShipmentStatus) {
        this.EasyShipShipmentStatus = EasyShipShipmentStatus;
    }

    public String getBuyerEmail() {
        return BuyerEmail;
    }

    public void setBuyerEmail(String BuyerEmail) {
        this.BuyerEmail = BuyerEmail;
    }
    

}
