/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M Hamza Khan
 */


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

 class FileOperations {
    
     public static void writeToFile (User_Login U)
     {
         ObjectOutputStream outputStream = null;

		try {
                    // Read old objects
			ArrayList<User_Login> UserList = readAllData();
			// Append new object into existing list
			UserList.add(U); //AAdding into Array list
			// Open Stream for writing
	    outputStream = new ObjectOutputStream(new FileOutputStream("UserList.ser"));
			
			// Write all objects (old and new one) into the file
			for(int i = 0 ; i < UserList.size() ; i++) {
				outputStream.writeObject(UserList.get(i));
			}
		} catch(IOException e) {
			System.out.println("IO Exception while opening file");
		} finally { // cleanup code which closes output stream if its object was created
			try {
				if(outputStream != null) {
					outputStream.close();								
				}

			} catch (IOException e) {
				System.out.println("IO Exception while closing file");
			}
		}		
	}


  
    
    public static ArrayList <User_Login>  readAllData ()
                        {
                          //  ArrayList initialized with size 0
		ArrayList<User_Login> UserList = new ArrayList<User_Login>(0);
		// Input stream
		ObjectInputStream inputStream = null;
		try
		{
			// open file for reading
		inputStream = new ObjectInputStream(new FileInputStream("UserList.ser"));
			// End Of File flag
			boolean EOF = false;
			// Keep reading file until file ends
			while(!EOF) {
				try {
					// read object and type cast into CarDetails object
					User_Login myObj = (User_Login) inputStream.readObject();
					// add object into ArrayList
					UserList.add(myObj);
					//System.out.println("Read: " + myObj.getName());
				} catch (ClassNotFoundException e) {
					//System.out.println("Class not found");
				} catch (EOFException end) {
					// EOFException is raised when file ends
					// set End Of File flag to true so that loop exits
					EOF = true;
				}
                        }
                }
		 catch(FileNotFoundException e) {
			//System.out.println("Cannot find file");
		} catch (IOException e) {
			//System.out.println("IO Exception while opening stream");
			//e.printStackTrace();
		} finally { // cleanup code to close stream if it was opened
			try {
				if(inputStream != null)
					inputStream.close( );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO Exception while closing file");
			}
		}
                
		// returns ArrayList
		return UserList;
	}
    
    public static boolean search (String name,String Password)
    {
        ArrayList<User_Login> list = readAllData();
        
        boolean found = false;
        
        for( int i=0; i< list.size();i++)
        {
          
            if (list.get(i).getName().equalsIgnoreCase(name) && list.get(i).getPassword().equals(Password))
              
            {
                
                found = true;
           
                break;
            }
        }
        return found; 
    }
        
    
  
    
//Writing Product to a file

public static void writeProductToFile (Product U)
     {
         ObjectOutputStream outputStream = null;

		try {
                    // Read old objects
			ArrayList<Product> ProductList = readPostsData();
			// Append new object into existing list
			ProductList.add(U); //Adding into Array list
			// Open Stream for writing
	    outputStream = new ObjectOutputStream(new FileOutputStream("ProductList.ser"));
			
			// Write all objects (old and new one) into the file
			for(int i = 0 ; i < ProductList.size() ; i++) {
				outputStream.writeObject(ProductList.get(i));
			}
		} catch(IOException e) {
			System.out.println("IO Exception while opening file");
		} finally { // cleanup code which closes output stream if its object was created
			try {
				if(outputStream != null) {
					outputStream.close();								
				}

			} catch (IOException e) {
				System.out.println("IO Exception while closing file");
			}
		}		
	}


  
    
    public static ArrayList <Product>  readPostsData ()
                        {
                          //  ArrayList initialized with size 0
		ArrayList<Product> ProductList = new ArrayList<Product>(0);
		// Input stream
		ObjectInputStream inputStream = null;
		try
		{
			// open file for reading
		inputStream = new ObjectInputStream(new FileInputStream("ProductList.ser"));
			// End Of File flag
			boolean EOF = false;
			// Keep reading file until file ends
			while(!EOF) {
				try {
					// read object and type cast into CarDetails object
					Product myObj = (Product) inputStream.readObject();
					// add object into ArrayList
					ProductList.add(myObj);
					//System.out.println("Read: " + myObj.getName());
				} catch (ClassNotFoundException e) {
					//System.out.println("Class not found");
				} catch (EOFException end) {
					// EOFException is raised when file ends
					// set End Of File flag to true so that loop exits
					EOF = true;
				}
                        }
                }
		 catch(FileNotFoundException e) {
			//System.out.println("Cannot find file");
		} catch (IOException e) {
			//System.out.println("IO Exception while opening stream");
			//e.printStackTrace();
		} finally { // cleanup code to close stream if it was opened
			try {
				if(inputStream != null)
					inputStream.close( );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO Exception while closing file");
			}
		}
                
		// returns ArrayList
		return ProductList;
	}
    
   
    
//Write Order to file


public static void writeOrderToFile (Order U)
     {
         ObjectOutputStream outputStream = null;

		try {
                    // Read old objects
			ArrayList<Order> OrderList = readOrderData();
			// Append new object into existing list
			OrderList.add(U); //Adding into Array list
			// Open Stream for writing
	    outputStream = new ObjectOutputStream(new FileOutputStream("OrderList.ser"));
			
			// Write all objects (old and new one) into the file
			for(int i = 0 ; i < OrderList.size() ; i++) {
				outputStream.writeObject(OrderList.get(i));
			}
		} catch(IOException e) {
			System.out.println("IO Exception while opening file");
		} finally { // cleanup code which closes output stream if its object was created
			try {
				if(outputStream != null) {
					outputStream.close();								
				}

			} catch (IOException e) {
				System.out.println("IO Exception while closing file");
			}
		}		
	}


  
    
    public static ArrayList <Order>  readOrderData()
                        {
                          //  ArrayList initialized with size 0
		ArrayList<Order> OrderList = new ArrayList<Order>(0);
		// Input stream
		ObjectInputStream inputStream = null;
		try
		{
			// open file for reading
		inputStream = new ObjectInputStream(new FileInputStream("OrderList.ser"));
			// End Of File flag
			boolean EOF = false;
			// Keep reading file until file ends
			while(!EOF) {
				try {
					// read object and type cast into CarDetails object
					Order myObj = (Order) inputStream.readObject();
					// add object into ArrayList
					OrderList.add(myObj);
					//System.out.println("Read: " + myObj.getName());
				} catch (ClassNotFoundException e) {
					//System.out.println("Class not found");
				} catch (EOFException end) {
					// EOFException is raised when file ends
					// set End Of File flag to true so that loop exits
					EOF = true;
				}
                        }
                }
		 catch(FileNotFoundException e) {
			//System.out.println("Cannot find file");
		} catch (IOException e) {
			//System.out.println("IO Exception while opening stream");
			//e.printStackTrace();
		} finally { // cleanup code to close stream if it was opened
			try {
				if(inputStream != null)
					inputStream.close( );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO Exception while closing file");
			}
		}
                
		// returns ArrayList
		return OrderList;
	}
    
   
    
    






















    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
