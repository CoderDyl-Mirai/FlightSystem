package ie.atu.flight;

public class Date {
	private int day;
	private int month;
	private int year;
	public Date()
	{
		this.day = 1;
		this.month = 1;
		this.year = 2000;
	}
	public Date(int d, int m, int y) throws IllegalArgumentException
	{
		if(d<1 || d>31 || m<1 || m>12 || y<1900) 
			throw new IllegalArgumentException("Invalid Dte Values");
		this.day = d;
		this.month = m;
		this.year = y;
		
	}
	
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
	@Override
	   public boolean equals(Object obj){
		   Date dObject;
		   if (obj instanceof Date)
		      dObject = (Date)obj;
		   else
		       return false;
		 
		   return (this.day==dObject.day
	          && this.month==dObject.month
	          && this.year==dObject.year);
	}
		
	public int getDay()
	{
		return day;
	}
	public int getMonth()
	{
		return month;
	}
	public int getYear()
	{
		return year;
	}
	
	public void setDay(int d) throws IllegalArgumentException 
	{
		if(d<1 || d>31) 
			throw new IllegalArgumentException("Invalid Day");
		day = d;
		
		
	}
	public void setMonth(int m) throws IllegalArgumentException
	{
		if(m<1 || m>12)
			throw new IllegalArgumentException("Month must be between int 1 and 12");
		month = m;

		
	}
	public void setYear(int y) throws IllegalArgumentException
	{
		if(y<1900) 
			throw new IllegalArgumentException("Year must be more than 1900");
		year = y;
		
			
		
	}
}
