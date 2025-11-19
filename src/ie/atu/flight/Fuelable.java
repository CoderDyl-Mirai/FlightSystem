package ie.atu.flight;

public interface Fuelable {
	public abstract void refuel(double amount);
	public abstract double getFuelPercentage();
}
