/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapotek.Model;

import java.util.Date;

/**
 *
 * @author nicol
 */
public class MainModel {        
    public String name;
    public String address;
    public String price;
    public String code;
    public String totalq;
    public String totalp;
    public String type;
    public String expired_date;
    public String stock;
    public String product_name;
    public String id_obat;
    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setName (String name){
        this.name = name;
    }
    
     public String getName () {
        return name;
    }
     
     public void setAddress (String address){
        this.address = address;
    }   
    
     public String getAddress () {
        return address;
    }
     
     public void setPrice (String price){
        this.price = price;
    }
    
     public String getPrice () {
        return price;
    }
     
     public void setCode (String code){
        this.code = code;
    }   
    
     public String getCode () {
        return code;
    }
     
     public void setTotalq (String totalq){
        this.totalq = totalq;
    }
    
     public String getTotalq () {
        return totalq;
    }
     
     public void setTotalp (String totalp){
        this.totalp = totalp;
    }
    
     public String getTotalp () {
        return totalp;
    }
     
     public void setType (String type){
        this.type = type;
    }
    
     public String getType () {
        return type;
    }
     
      public void setExpired_date (String expired_date){
        this.expired_date =expired_date ;
    }
    
     public String getExpired_date () {
        return expired_date;
    }
     
      public void setStock (String stock){
        this.stock = stock;
    }
    
     public String getStock () {
        return stock;
    }
     
     public void setProduct_Name (String product_name){
         this.product_name = product_name;
     }
     
     public String getProduct_Name () {
         return product_name;
     }
     
     public void setId_obat (String id_obat){
        this.id_obat = id_obat;
    }
    
     public String getId_obat () {
        return id_obat;
     }
}
