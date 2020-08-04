
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M Hamza Khan
 */
public class Order implements Serializable {
    
    public String OwnerName; 
    public String UserName;
    public String Product;
    public String Address;
    
    public Order(String a, String b,String c,String d) {
        this.OwnerName = a;
        this.UserName = b;
        this.Product = c;
        this.Address =d;
        
    }
    
    public void setUser(String a) {
        this.UserName = a;
    }
    
    public String getUser() {
        return UserName;
    }
    
    public void setProduct(String a) {
        this.Product = a;
    }
    
    public String getProduct() {
        return Product;
    }
    
    public void setOwner(String a) {
        this.OwnerName = a;
    }
    
    public String getOwner() {
        return OwnerName;
    }
    
    
    
    
    
    public void setAddress(String a) {
        this.Address= a;
    }
    
    public String getAddress() {
        return Address;
    }
    
    
    
}
