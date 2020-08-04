
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
public class User_Login implements Serializable {
    
    public String name;
    public String Password;
    public String CountryName;
    public int ContactNumber;

    public User_Login() {    
        
    }
    
    public User_Login(String User_Name,String password,String Country,int Contact ) {
        this.name = User_Name;
        this.Password = password;
        this.CountryName = Country;
        this.ContactNumber = Contact;
        System.out.print("Congratulation! Account has been Created\n");
             
}
    
    public void setName(String Name) {
        this.name = Name;  
}
    public String getName() {
        return name;
    }
    public void setCountry(String c) {
        
        this.CountryName = c;
}
    public String getCountry() {
        return CountryName;
    }
    public void setContact(int e) {
        this.ContactNumber = e;
    }
    public int getContact() {
        return ContactNumber;
    }
    public void setPassWord(String p) {
        this.Password = p;
    }
    public String getPassword() {
        return Password;
    }
    
}
