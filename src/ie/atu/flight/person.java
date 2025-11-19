package ie.atu.flight;

import java.io.Serializable;

public abstract class person implements Serializable{
	protected Name name;
	protected String phoneNumber;
	public person(){
		name = new Name();
		phoneNumber = "";
	}
	public person(Name n, String pn){
		name = n;
		phoneNumber = pn;
	}
	public String toString()
	{
		return name +"\t" + phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String pn) {
		phoneNumber = pn;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name n) {
		name = n;
	}
	 @Override  // Overrides Object equals()
	   public boolean equals(Object obj) {
	      person pObj;
	      if(obj instanceof person)
	         pObj=(person)obj;
	      else
	         return false;
			
	      return name.equals(pObj.name) && phoneNumber.equals(pObj.phoneNumber);		
	   }
}
