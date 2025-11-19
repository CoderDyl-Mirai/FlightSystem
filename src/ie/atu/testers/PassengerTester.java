package ie.atu.testers;
import java.util.ArrayList;

import ie.atu.flight.Name;
import ie.atu.flight.Passenger;
import ie.atu.flight.PaymentCard;
import ie.atu.flight.Date;
public class PassengerTester {
	public static void main(String[] args) {
		ArrayList <Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(new Passenger(new Name("Mr","Homer","Simpson"),"087 1234567",0, false,new PaymentCard(1111222233334444l, new Date(31,12,2027),111), " homer.simpson@atu.ie"));
		passengers.add(new Passenger(new Name("Mrs","Marge","Simpson"),"086 1234567",1, true,new PaymentCard(5555666677778888l, new Date(31,12,2024),222), " magre.simpson@atu.ie"));
		passengers.add(new Passenger(new Name("Miss","Lisa","Simpson"),"087 9876543",3, true,new PaymentCard(5555666677778888l, new Date(31,3,2024),333), " lisa.simpson@atu.ie"));
		int women = 0;
		System.out.println("List Of Passengers");
		for(Passenger p:passengers)
		{
			System.out.println(p.toString());
			if(p.getName().isFemale()) {
				women++;
			}
		}
		System.out.println("\nMale/Female Passenger Count");
		System.out.println(passengers.size()-women+ " Males(s), "+women+ " Female(s).\n");
		System.out.println("Passengers Payment Cards");

		for(Passenger p:passengers) {
			System.out.println(p.getName()+ ", Card Number: "+p.getCardDetails().getNumber());

		}

	}

}
