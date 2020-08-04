/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M Hamza Khan
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
            
        MainMenu();
    }
            
    
        


    public static void MainMenu() {
      System.out.println("Welocme to Ecommerce Application\n1. Login\n2. Sign Up\nChoose an Option:");
   try{
      Scanner input = new  Scanner(System.in);
   
      int option = input.nextInt();    
   
      if(option==1){
          logged_in();
      }
      
      else if(option==2) {
            Sign_Up();
             
      }
      else {
            System.out.println("Plz Choose Correct Option\n");
            MainMenu();
            
        
      }
   }
      catch(InputMismatchException ex) {
               System.out.println("InputMismatchException!\nTry Again!");
               MainMenu();
    }
    
    }
public static void logged_in() {
          try{
              
          
          Scanner input = new Scanner(System.in);    
          System.out.println("Enter Name: ");
          String Name = input.next();
          System.out.println("Enter Password: ");
          String password = input.next();
          
          FileOperations.search(Name, password);
          
          if(FileOperations.search(Name, password)==true) {
           User_Menu(Name,password);  
          }
          else {
              
              System.out.print("Wrong Credentials!\n1. Try Again!\n2. Sign Up");
              int a = input.nextInt();
              if(a==1) {
              logged_in();         
}
              if(a==2) {
                  MainMenu();
              }
              else {
                  MainMenu();
              }
          
}
}
          catch(java.lang.NullPointerException ex) {
              System.out.println("java.lang.NullPointerException");
              logged_in();
          }
}

public static void Sign_Up() {
    
            Scanner input = new Scanner(System.in);
                
          
            System.out.println("Enter Name: ");
            String name = input.next();
            System.out.println("Enter PassWord: ");
            String password = input.next();
            System.out.println("Enter Country: ");
            String country = input.next();
            System.out.println("Enter Contact Number: ");
            int no = input.nextInt();
            
            
             User_Login U1 = new User_Login(name,password,country,no);
            
              FileOperations.writeToFile(U1);
              User_Menu(name,password);
          
}

public static void User_Menu(String name,String password) {
    
    
    System.out.println("1. User Profile\n2. Posts Option\n3. Orders Option\n4. Log out\n");
    System.out.println("Choose any Option: ");
    Scanner input = new Scanner(System.in);
    ArrayList<User_Login> Userlist =   FileOperations.readAllData();
    try{
    int s = input.nextInt();
    
    
    if(s==1) {
       for (int i=0 ;i< Userlist.size();i++)
     {
         
     
         if(Userlist.get(i).equals(name)) {
             
             System.out.println("Name = "+Userlist.get(i).getName());
             System.out.println("Contact No = "+Userlist.get(i).getContact());
             System.out.println("Living Country = "+Userlist.get(i).getCountry());
             User_Menu(name,password);
         }
         else{
             System.out.println("UnKnown Error!");
             User_Menu(name,password);
       
       
         }
         
     }
    }
         
    
         
             
    
    if(s==2) {
        System.out.print("1. Add Your Post\n2. View Your Post\n3 Others Posts\n4. Main Menu\n");
        System.out.println("Choose an Option!");
            try{
            int o = input.nextInt();
            if(o==1){
               
                System.out.println("Enter Name of Product: ");
                String n = input.next();
                System.out.println("Enter Price of Produt: ");
                int p = input.nextInt();
                System.out.println("Enter Quantity of Product: ");
                int q = input.nextInt();
                System.out.println("Enter Location: ");
                String L = input.next();
                
                
                Product P = new Product(n,p,q,L,name);
                
                
                FileOperations.writeProductToFile(P);
                System.out.println("Back to Main Menu: ");
                User_Menu(name,password);
            }
            else if(o==2) {
      
                 ArrayList<Product> Productlist =   FileOperations.readPostsData();
                 
                 for(int k =0;k<Productlist.size();k++) {
                 if(Productlist.get(k).getName().equals(name)) {
                 
                System.out.println("Name of Product: "+Productlist.get(k).getname());
                
                System.out.println("Price of Produt: "+Productlist.get(k).getPrice());
               
                System.out.println("Quantity of Product: "+Productlist.get(k).getQuantity());
                
                System.out.println("Location: "+Productlist.get(k).getQuantity());        
                 } 
                 }
                 System.out.println("Back To Main Menu!");
                 User_Menu(name,password);
            }
    
            else if(o==3) {
                
                ArrayList<Product> Productlist =   FileOperations.readPostsData();
                 
                 for(int t =0;t<Productlist.size();t++) {
                  {if(Productlist.get(t).getName().equals(name)==false) {
                 System.out.print("Product: "+t);
                
                System.out.println("Name of Owner: "+Productlist.get(t).getName());
                System.out.println("Name of Product: "+Productlist.get(t).getname());
                
                System.out.println("Price of Produt: "+Productlist.get(t).getPrice());
               
                System.out.println("Quantity of Product: "+Productlist.get(t).getQuantity());
                
                System.out.println("Location: "+Productlist.get(t).getQuantity()+"\n");
                
                if(t==Productlist.size()) {
                 System.out.println("Back To Main Menu!");
                 User_Menu(name,password);

                 }  
            }
            
            }
            }
            }
            else if(o==4){
                       User_Menu(name,password); 
                        }
            else {
                System.out.println("Wrong Option! Back to Main Menu");
                User_Menu(name,password);
            }
            }
            catch(InputMismatchException ex) {
               System.out.println("InputMismatchException!\nTry Again!");
               User_Menu(name,password);
    
    }
    }
    
       if(s==3) {
               
           System.out.println("1. Place Order\n2. View your Placed Order\n3. View Placed Orders from others to your post\n4.Main Menu");
           try{
               
           
           int q = input.nextInt();
           
           if(q==1) {
               
               ArrayList<Product> Productlist = FileOperations.readPostsData();
                 
                 for(int h =0;h<Productlist.size();h++) 
                  {
                      
                     System.out.println("Product No: "+h);
                
                     System.out.println("Name of Owner: "+Productlist.get(h).getName());
                     System.out.println("Name of Product: "+Productlist.get(h).getname());
                
                     System.out.println("Price of Produt: "+Productlist.get(h).getPrice());
               
                     System.out.println("Quantity of Product: "+Productlist.get(h).getQuantity());
                
                     System.out.println("Location: "+Productlist.get(h).getQuantity()+"\n");
                
                  }
                      
                      
       
                  
                System.out.println("Enter Product Owner Name: ");
                String a = input.next();
                System.out.println("Enter Product Name: ");
                String b = input.next();
                 
                 
                System.out.println("Enter Your Shipping Address: ");
                String d = input.next();
                
                
              
                         
               Order O1 = new Order(a,name,b,d);
              
               FileOperations.writeOrderToFile(O1);
                        
               System.out.println("Order Successfully Placed!");
                     
                    
                 
                User_Menu(name,password);  
                 }
           if(q==2) {
               
               ArrayList<Order> OrderList =   FileOperations.readOrderData();
              boolean found = false;
               for(int j =0;j<OrderList.size();j++) {
                     if(OrderList.get(j).getUser().equals(name)) {
                         System.out.println("You have Placed this order");
                         System.out.println("Owner Name:" +FileOperations.readOrderData().get(j).getOwner());
                         System.out.println("Product Name:" +FileOperations.readOrderData().get(j).getProduct());
                         found=true;
                     }      
                    
               }
               if(!found){
                   System.out.println("Not Order added Yet!");
               }
                System.out.println("Back to Main Menu: ");
                User_Menu(name,password);
           }
           
           if(q==3) {
               ArrayList<Order> OrderList =   FileOperations.readOrderData();
               boolean found=false;
               for(int j =0;j<OrderList.size();j++) {
                   if(OrderList.get(j).getOwner().equals(name)) {
                       System.out.println("This Order Placed by Customer");
                       System.out.println("Customer Name:" +FileOperations.readOrderData().get(j).getUser());
                       System.out.println("Product Name:" +FileOperations.readOrderData().get(j).getProduct());
                       found = true; 
                       
                   }
                   
                   
           }
               if(!found){
                   System.out.println("Not Order Placed Yet!");
               }
                System.out.println("Back to Main Menu: ");
                User_Menu(name,password);
           }
               
            if(q==4) {
                User_Menu(name,password);
                
            }
               
            else {
                System.out.print("Wrong Option! Back to Main Menu: ");
                User_Menu(name,password);
            }
    
                
                 }
              catch(InputMismatchException ex) {
               System.out.println("InputMismatchException!\nTry Again!");
               User_Menu(name,password);
              }
       }
         if(s==4) {
             System.out.println("Thanks!");
             System.exit(0);
         }
    }
     catch(InputMismatchException ex) {
               System.out.println("InputMismatchException!\nTry Again!");    
               User_Menu(name,password);
    }
}
    
    
    
    
    
    
      
      //if name and password match in file then login
          
          //if doesnt match input display wrong credentials .
          //if name not found display no account found on this name.
          //if logged in display User Menu.
          
         /* 
           1. User menu after loggin
           a. add post // adds object in file with owner name & password match
           b. View your Post // reads objects from file with that user name &password match
           c. View other post owner profile details
           d. Ordering product with customer details and shipping address   
           e. Canceling order/deleting/editing shipping address
           1. Receiving order by other users
           f. View Your Account Information
           g. Edit your information
           h. deleting your account
           i. deleting your post.
           j. Log out


 /* for searching of user name
     
     for (int i=0 ;i< Userlist.size();i++)
     {
         System.out.println(Userlist.get(i).getName());
     }  
        System.out.println(FileOperations.search("Ali"));
        
        
      */ 
          
           
          
          
          
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
            
        
        
        
        
        
        
        
        
        
        
    }
    

