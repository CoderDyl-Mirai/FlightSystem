package ie.atu.testers;
import ie.atu.flight.Name;
import java.util.ArrayList;
public class NameTester {
	public static void main(String[] args)
	{
		Name name1 = new Name("Mr","Dylan","Greene");
		Name name2 = new Name("Miss", "Kelly", "Donnolly");
		System.out.println(name1.toString());
		System.out.println(name2.toString());
		name1.setFirstName("Charlie");
		name2.setTitle("Mrs");
		System.out.println(name1.toString());
		System.out.println(name2.toString());
		Name same1 = new Name("Mr","Bob","O'Duffy");
		Name same2 = new Name("Mr","Bob","O'Duffy");
		System.out.println(same1.equals(same2));
		
		ArrayList <Name> nameList = new ArrayList<Name>();
		nameList.add(new Name("Miss","Kate","Turnip"));
		nameList.add(new Name("Mr","Harry","Carrot"));
		nameList.add(new Name("Ms","Karin","Onion"));

		for(Name name: nameList)
		{
			System.out.println(name.toString());

		}
	}
}
