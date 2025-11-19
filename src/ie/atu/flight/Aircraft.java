/**
 * Class: Software Implementation
 * Instructor: Maria Boyle
 * Description: Class Aircraft - Developed for the Flight Booking System
 * Date: 15/10/2025
 * @author Dylan Greene
 * @version 1.0
 */
package ie.atu.flight;

public class Aircraft implements Fuelable{
    /* 
     * An Aircraft has a regNumber, a model such as Boeing 737, a passengerCapacity,
     * a fuelCapacity, and a fuelLevel which is the current fuel amount in the Aircraft.
     * 
     * SAMPLE AIRCRAFT INCLUDE : IE-AA1, Boeing 737, 152 passengers, fuel capacity is 26000.0 litres.
     *                           IE-AA7, Airbus A03, 180 passengers, fuel capacity is 60000.0 litres.
    */
    private String regNumber; 
    private String model;      
    private int passengerCapacity; 
    private double fuelCapacity; 
    private double fuelLevel;   
    private static int nextNumber = 1;
    private int uniqueNumber;

    public Aircraft(String model, int pCapacity, double fuelCapacity) throws IllegalArgumentException{
    	if(model==null||model==""||pCapacity<4||pCapacity>180||fuelCapacity<5000||fuelCapacity>62000)
    	{
    		throw new IllegalArgumentException("Invalid Aircraft");
    	}
        this.model=model;
        this.passengerCapacity=pCapacity;
        this.fuelCapacity=fuelCapacity;
        this.fuelLevel=0.0;
        this.uniqueNumber = nextNumber++;
        this.regNumber = "EI-AA"+uniqueNumber;

    }
			
    @Override
    public String toString(){
        return regNumber+"  " + model + " capacity " + passengerCapacity + " passengers.";
    }	

    @Override  
    public boolean equals(Object obj){
        Aircraft aObject;
        if (obj instanceof Aircraft)
            aObject = (Aircraft)obj;
        else
            return false;

        return this.regNumber.equals(aObject.regNumber) &&
            this.model.equals(aObject.model) ;							
    }

    // NO setRegNumber() method, regNumber is set using static
    public void setModel(String model) {
        this.model = model;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }	
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getRegNumber() {
        return regNumber;
    }	
    public String getModel() {
        return model;
    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public double getFuelCapacity() {
        return fuelCapacity;
    }
    public double getFuelLevel() {
        return fuelLevel;
    } 
    public void refuel(double amount) throws IllegalArgumentException{
    	if(amount<=0||amount+fuelLevel>fuelCapacity)
    	{
    		throw new IllegalArgumentException("Refuel amount is invalid");
    	}
    	fuelLevel = fuelLevel+amount;
    }
    public double getFuelPercentage() {
    	return fuelLevel / fuelCapacity * 100;
    }
}