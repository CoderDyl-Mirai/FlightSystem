package ie.atu.testers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.atu.flight.Date;
import ie.atu.flight.Employee;
import ie.atu.flight.Name;
import ie.atu.flight.Passenger;
import ie.atu.flight.PaymentCard;
import ie.atu.flight.person;

public class ExceptionHandlerDemo {

	public static void main(String[] args) {
		ArrayList<person> vipList = new ArrayList<person>();
		vipList.add(new Employee(new Name("Mr","Ben","Carson"),"0861234567",new Date(20,10,1980),new Date(10,10,2012),42000.00));
		vipList.add(new Employee(new Name("Mr","Mark","Logan"),"0879876543",new Date(1,1,1994),new Date(2,8,2018),28000.00));
		vipList.add(new Passenger(new Name("Mrs","Marge","Simpson"),"086 1234567",1, true,new PaymentCard(5555666677778888l, new Date(31,12,2024),222), " magre.simpson@atu.ie"));
		vipList.add(new Passenger(new Name("Miss","Lisa","Simpson"),"087 9876543",3, true,new PaymentCard(5555666677778888l, new Date(31,3,2024),333), " lisa.simpson@atu.ie"));
		for(person p: vipList) {
			System.out.println(p.toString());
		}
		int vipNumber=0;
		boolean inputCorrect = false;
		do
		{
			try {
				String vipNumberAsString=JOptionPane.showInputDialog(null,
						"Enter VIP Person to View ("+1+" to "+ vipList.size()+")");
				vipNumber = Integer.parseInt(vipNumberAsString)-1;
				System.out.println(vipList.get(vipNumber).toString());
				inputCorrect = true;
			}
			catch(IndexOutOfBoundsException e){
				 JOptionPane.showMessageDialog(null,"An Integer in range is required!");
			}
			catch(NumberFormatException u){
				 JOptionPane.showMessageDialog(null,"An Integer is required!");
			}
		}
		while(!inputCorrect);
		
	}

}
