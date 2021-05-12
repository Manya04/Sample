/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Adeep My IT Solution Private Limited
 */
@Entity
@Table(name = "\"admin\"")
public class Admin implements Serializable{
    @Id
    @Column(name = "username", nullable = false, updatable = false, unique = true)
    private String username;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "number", nullable = false, unique = true)
    private String number;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    
    @CreationTimestamp
    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @JsonManagedReference
    @OneToOne(mappedBy="admin", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private AdminPermission adminPermission;
    
    public Admin() {
    }

    public Admin(String username, String name, String email, String number, String password, AdminPermission adminPermission) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
        this.adminPermission = adminPermission;
    }

    public Admin(String username, String name, String email, String number, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AdminPermission getAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(AdminPermission adminPermission) {
        this.adminPermission = adminPermission;
    }

    @Override
    public String toString() {
        return "Admin{" + "username=" + username + ", name=" + name + ", email=" + email + ", number=" + number + ", password=" + password + ", createdAt=" + createdAt + ", adminPermission=" + adminPermission + '}';
    }

    
     
}
