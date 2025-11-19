package ie.atu.flight;

import java.io.Serializable;

public class Name implements Serializable {
	private String title;
	private String firstName;
	private String surname;
	public Name() {
		title = null;
		firstName = null;
		surname = null;
	}
	public Name(String t, String fN, String sN) {
		title = t;
		firstName = fN;
		surname = sN;
	}
	public String toString()
	{
		return title+" "+firstName+" "+surname;
	}
	public boolean equals(Name n)
	{
		if(n.getTitle() == title &&
				n.getFirstName()== firstName &&
				n.getSurname() ==surname)
		{
			return true;
		}
		else {
			return false;
		}
	}
	public String getTitle()
	{
		return title;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getSurname()
	{
		return surname;
	}
	public void setTitle(String t)
	{
		title = t;
	}
	public void setFirstName(String fN)
	{
		firstName = fN;
	}
	public void setSurname(String sN)
	{
		surname = sN;
	}
	public boolean isFemale() {
		if(title == "Miss"|| title == "Ms"|| title=="Mrs")
		{
			return true;
		}
		else {
			return false;
		}
	}
}
