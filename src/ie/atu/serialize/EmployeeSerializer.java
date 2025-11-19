package ie.atu.serialize;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.atu.flight.Employee;

public class EmployeeSerializer {
   private ArrayList<Employee> employees;
	
   private final String FILENAME = "employees.bin";	
   private File employeesFile;	
	
   // Default Constructor
   public EmployeeSerializer(){
      // Construct EmployeeList ArrayList
      employees = new ArrayList<Employee>();

      // TODO Construct employeesFile and physically create the File
      employeesFile = new File(FILENAME);
      try {
          employeesFile.createNewFile();
      }
      catch(IOException e)
      {
    	  System.out.println("Could Not Create File");
      }
   }	

   /////////////////////////////////////////////////////////////
   // Method Name : add()                                     //
   // Return Type : void                                      //
   // Parameters : None                                       //
   // Purpose : Reads one Employee record from the user       //
   //           and adds it to the ArrayList called employees //
   /////////////////////////////////////////////////////////////
   public void add(){ 
      // Create an Employee object
      Employee employee = new Employee();
 
      // TODO - Update add() so it checks if Cancel was clicked when reading Employee
       
      // Read its details
      boolean readReturn = employee.read();
      // And add it to the employees ArrayList
      if(readReturn)
    	  employees.add(employee);	
   }

   ///////////////////////////////////////////////////////
   // Method Name : list()                              //
   // Return Type : void                                //
   // Parameters : None                                 //
   // Purpose : Lists all Employee records in employees //
   ///////////////////////////////////////////////////////		
   public void list(){
      String employeesToList="";

      if(!employees.isEmpty()) {
         // for every Employee object in employees
         for(Employee tmpEmployee : employees) {
            // add it to employeesToList and
            employeesToList+=tmpEmployee;
            // add a newline
            employeesToList+="\n";
         }
			
         // Display employeesToList in a messageDialog
         JOptionPane.showMessageDialog(null, employeesToList, "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
      }
      else
         // Display "No Employees stored..." in messageDialog
         JOptionPane.showMessageDialog(null, "No Employees to list.", "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
   }	

   ////////////////////////////////////////////////////////////////
   // Method Name : view()                                       //
   // Return Type : Employee                                     //
   // Parameters : None                                          //
   // Purpose : Displays the required Employee record on screen  //
   //         : And returns it, or null if not found             //   
   ////////////////////////////////////////////////////////////////	
   public Employee view(){
      // TODO - Write the code for view()		 
		 JTextField txtNumber = new JTextField();
	
		 Object[] message = {
		 "Input Employee Number",txtNumber,
		 };
		 JDialog dialog = new JDialog();
		 dialog.setAlwaysOnTop(true);
		 int option = JOptionPane.showConfirmDialog(dialog, message,
		 "ENTER EMPLOYEE DETAILS", JOptionPane.OK_CANCEL_OPTION);
		 if (option == JOptionPane.OK_OPTION){
			 int emNum = Integer.parseInt(txtNumber.getText());
			 for(Employee e: employees)
			 {
				 if(e.getNumber()==emNum)
				 {
					 System.out.println(e.toString());
					 return e;
				 }
			 }
		 }
      return null;		
   }
	
   ///////////////////////////////////////////////////////////////////
   // Method Name : delete()                                        //
   // Return Type : void                                            //
   // Parameters : None                                             //
   // Purpose : Deletes the required Employee record from employees //
   ///////////////////////////////////////////////////////////////////	
   public void delete(){
      // TODO - Write the code for delete()
	   Employee employee = view();
	   if(employee!=null)
	   {
		   employees.remove(employee);
	   }
   }

   ///////////////////////////////////////////////////////////////
   // Method Name : edit()                                      //
   // Return Type : void                                        //
   // Parameters : None                                         //
   // Purpose : Edits the required Employee record in employees //
   ///////////////////////////////////////////////////////////////	
   public void edit(){
      // TODO - Write the code for edit()
	   Employee employee = view();
	   if(employee!=null)
	   {
		   int index = employees.indexOf(employee);
		   employee.read();
		   employees.set(index, employee);
	   }
   }
	
   // This method will serialize the employees ArrayList when called, 
   // i.e. it will write employees to a file called employees.bin
   public void serializeEmployees(){
      // TODO - Write the code for serializeEmployees()
	   ObjectOutputStream os=null;
	   try {
           // Serialize the ArrayList...
           FileOutputStream fileStream = new FileOutputStream(employeesFile);
				
           os = new ObjectOutputStream(fileStream);
						
           os.writeObject(employees);
         
           os.close();
        }
        catch(FileNotFoundException e){
           System.out.println("Cannot open file " + employeesFile.getName() + ".");
        }
        catch(IOException e){
           System.out.println("Cannot read from " + employeesFile.getName() + ".");
        }
   }

   // This method will deserialize the Employees ArrayList when called, 
   // i.e. it will restore the employees ArrayList from the file employees.bin
   public void deserializeEmployees(){
      ObjectInputStream is=null;

      if( employeesFile.length() != 0) {	   // if there employeesFile is not empty	
         try {
            // Deserialize the ArrayList...
            FileInputStream fileStream = new FileInputStream(employeesFile);
				
            is = new ObjectInputStream(fileStream);
						
            employees = (ArrayList<Employee>)is.readObject();
            if(employees.size()!=0)
            {
                Employee e = new Employee(employees.get(employees.size()-1).getNumber());
            }
            is.close();
         }
         catch(FileNotFoundException e){
            System.out.println("Cannot open file " + employeesFile.getName() + ".");
         }
         catch(IOException e){
            System.out.println("Cannot read from " + employeesFile.getName() + ".");
         }
         catch(ClassNotFoundException e){
            System.out.println("Employee class not found during deserialization.");
         }
      }
      else
      {
    	  System.out.println("Empty");
      }
   }
}