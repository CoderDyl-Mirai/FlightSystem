package ie.atu.flight;

import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employee extends person implements Payable, Serializable{
	//private Date dateOfBirth;
	//private Date startDate;
	private double salary;
	private static int nextNumber = 10000;
	private int number;
	private final double maxSalary = 150000;
	
	public Employee()
	{
		super();
		//dateOfBirth = new Date(1,1,1);
		//startDate = new Date(1,1,1);
		salary = 0;
		number=nextNumber++;

	}
	public Employee(int currentNextNum)
	{
		nextNumber=currentNextNum+1;
	}
	public Employee(Name n, String pn, Date db, Date sd, double s)
	{
		super(n, pn);
		//dateOfBirth = db;
		//startDate = sd;
		salary = s;
		number=nextNumber++;
	}
	public String toString()
	{
		return number+" "+name+"\t€"+String.format("%.2f", salary);
	}
	public void setDateOfBirth(Date db)
	{
		//dateOfBirth = db;
	}
	public void setStartDate(Date sd)
	{
		//startDate = sd;
	}
	public void setSalary(double s)
	{
		salary = s;
	}
	/*public Date getDateOfBirth()
	{
		return dateOfBirth;
	}
	public Date getStartDate()
	{
		return startDate;
	}*/
	public double getSalary()
	{
		return salary;
	}
	public int getNumber()
	{
		return number;
	}
	public double calculatePay(double taxPercentage)
	{
		double pay=this.salary/12;
		pay -= (pay*(taxPercentage/100));
		return pay;
	}
	public double incrementSalary(double incrementAmount)
	{
		salary+=incrementAmount;
		if(salary<=maxSalary){
			return salary;
		}
		else {
			salary=maxSalary;
			return salary;
		}
		
	}
	@Override  // Overrides Object equals()
	   public boolean equals(Object obj) {
	      Employee pObj;
	      if(obj instanceof Employee)
	         pObj=(Employee)obj;
	      else
	         return false;
			
	      return number == pObj.number;		
	   }
	// read() method – add to Employee class and finish it!
	public boolean read() {
		 JTextField txtEmployeeNumber = new JTextField();
		 String [] a = {"Mr","Mrs","Miss"};
		 JComboBox txtTitle = new JComboBox(a);
		 
		 txtEmployeeNumber.setText(""+number);
		 JTextField txtFirstName = new JTextField();
		 JTextField txtSurname = new JTextField();
		 JTextField txtPhoneNumber = new JTextField();
		 JTextField txtSalary = new JTextField();
	
		 Object[] message = {
		 "Employee Number",txtEmployeeNumber,
		 "Title",txtTitle,
		 "First Name:", txtFirstName,
		 "Surname:", txtSurname,
		 "Phone Number:", txtPhoneNumber,
		 "Salary",txtSalary
		 };
		 
		 JDialog dialog = new JDialog();
		 dialog.setAlwaysOnTop(true);
		 int option = JOptionPane.showConfirmDialog(dialog, message,
		 "ENTER EMPLOYEE DETAILS", JOptionPane.OK_CANCEL_OPTION);
		 if (option == JOptionPane.OK_OPTION){
			this.name.setTitle(txtTitle.getSelectedItem().toString());
			this.name.setFirstName(txtFirstName.getText());
			this.name.setSurname(txtSurname.getText());
			this.phoneNumber=txtPhoneNumber.getText();
			this.salary=Integer.parseInt(txtSalary.getText());
			return true;
		 }
		 else // CANCEL_OPTION
			 return false;
		}	
}
