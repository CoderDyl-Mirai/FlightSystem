package ie.atu.flight;

public class Passenger extends person{
	private int noBags;
	private boolean priorityBoarding;
	private PaymentCard cardDetails;
	private String emailAddress;
	public Passenger() {
		super();
		noBags = 0;
		priorityBoarding = false;
		cardDetails = null;
	}
	public Passenger(Name n, String pn, int nb, boolean pb, PaymentCard cd, String ea) {
		super(n, pn);
		noBags = nb;
		priorityBoarding = pb;
		cardDetails = cd;
		emailAddress = ea;
	}
	public String toString() {
		String nb;
		if(priorityBoarding) {
			nb = "Has Priority Boarding";
		}
		else
			nb = "No Priority Boarding";
		return name+"\t"+emailAddress+"\t Bags: "+noBags+", "+nb;
	}
	public int getNoBags()
	{
		return noBags;
	}
	public boolean getPriorityBoarding()
	{
		return priorityBoarding;
	}
	public PaymentCard getCardDetails()
	{
		return cardDetails;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public void setNoBags(int nb)
	{
		noBags = nb;
	}
	public void setPriorityBoarding(boolean pb)
	{
		priorityBoarding = pb;
	}
	public void setCardDetails(PaymentCard cd)
	{
		cardDetails = cd;
	}
	public void setEmailAddress(String ea) {
		emailAddress = ea;
	}
	
}
