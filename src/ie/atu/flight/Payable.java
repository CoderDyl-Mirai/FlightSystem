package ie.atu.flight;

public interface Payable {
	abstract double calculatePay(double taxPercentage);
	abstract double incrementSalary(double incrementAmount);

}
