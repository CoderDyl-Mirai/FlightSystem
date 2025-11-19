package ie.atu.testers;
import java.util.ArrayList;

import ie.atu.flight.Date;
import ie.atu.flight.Employee;
import ie.atu.flight.Name;

public class EmployeeTester {

	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		System.out.println("List Of Employees");
		employeeList.add(new Employee(new Name("Ms","Faye","McGuire"),"0871234567",new Date(7,12,2000),new Date(12,10,2020),24000.00));
		employeeList.add(new Employee(new Name("Mr","Ben","Carson"),"0861234567",new Date(20,10,1980),new Date(10,10,2012),42000.00));
		employeeList.add(new Employee(new Name("Mr","Mark","Logan"),"0879876543",new Date(1,1,1994),new Date(2,8,2018),28000.00));
		for(Employee e:employeeList) {
			System.out.println(e.toString());
		}
		for(Employee e:employeeList) {
			if(e.getSalary()<30000) {
				e.incrementSalary(1000);
			}
		}
		System.out.println("List Of Employees After Salary Increment");
		for(Employee e:employeeList) {
			System.out.println(e.toString());
		}
		System.out.println("Employees Take Home Pay");

		for(Employee e:employeeList) {
			System.out.print(e.getNumber()+" "+e.getName()+"\t€");
			if(e.getSalary()<35000) {
				System.out.println(String.format("%.2f",e.calculatePay(20)));
			}
			else {
				System.out.println(String.format("%.2f",e.calculatePay(40)));
				
			}
		}
		

	}

}
