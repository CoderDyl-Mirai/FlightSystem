package ie.atu.testers;

import java.util.ArrayList;

import ie.atu.flight.Aircraft;

public class AircraftTester {

	public static void main(String[] args) {
		ArrayList<Aircraft> ourFleet = new ArrayList<Aircraft>();
		try {
			ourFleet.add(new Aircraft("Boeing 737",152,26000));
			ourFleet.add(new Aircraft("Boeing 737",152,26000));
			ourFleet.add(new Aircraft("Boeing 737",152,26000));
			ourFleet.add(new Aircraft("Boeing 737",152,26000));
			ourFleet.add(new Aircraft("Boeing 737",152,26000));
			ourFleet.add(new Aircraft("Airbus A3",180,60000));
			ourFleet.add(new Aircraft("Airbus A3",180,60000));
			ourFleet.add(new Aircraft("Airbus A3",180,60000));
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage()+"(s)");
		}
		System.out.println("--Available Aircrafts--");
		for(Aircraft a:ourFleet){
			System.out.println(a.toString());
		}
		
		System.out.println("\n--Boeing List--");
		int BoeingAmount = 0;
		for(Aircraft a:ourFleet){
			if(a.getModel()=="Boeing 737")
			{
				System.out.println(a.toString());
				BoeingAmount++;
			}
		}
		System.out.println(BoeingAmount+" Boeing 737(s)");
		
		for(Aircraft a:ourFleet){
			try{
				a.refuel(10000);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("\n--After Refueling--");
		for(Aircraft a:ourFleet){
			System.out.println(a.getRegNumber()+" "+a.getModel()+" "+a.getFuelLevel()+" litres.");
		}




	}

}
