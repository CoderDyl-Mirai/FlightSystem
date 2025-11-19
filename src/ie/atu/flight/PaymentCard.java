package ie.atu.flight;

public class PaymentCard {
	private long number;
	private Date expiryDate;
	private int securityCode;
	public PaymentCard(long n, Date ed, int sc){
		number = n;
		expiryDate = ed;
		securityCode = sc;
	}
	public String toString(){
		return "Payment Card Number: "+number;
}

	@Override
	public boolean equals(Object obj) {
		PaymentCard pcObj;
		if(obj instanceof PaymentCard)
			pcObj = (PaymentCard)obj;
		else
			return false;
	
		return this.number == pcObj.number && 
				this.expiryDate == pcObj.expiryDate &&
				this.securityCode == pcObj.securityCode;
		}
	public long getNumber() {
		return number;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public int getSecurityCode() {
		return securityCode;
	}
}