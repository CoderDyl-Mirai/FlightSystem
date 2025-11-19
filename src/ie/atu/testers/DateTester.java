package ie.atu.testers;
import java.util.Scanner;

import ie.atu.flight.Date;
public class DateTester {
	public static void main(String[] args)
	{
		Date date1 = new Date(01, 02, 2004);
		Date date2 = new Date(01, 02, 2005);
		System.out.println(date1.toString());
		System.out.println(date2.toString());
		date1.setDay(12);
		date2.setMonth(07);
		System.out.println(date1.toString());
		System.out.println(date2.toString());
		
		Date date3 = new Date(01, 02, 2004);
		Date date4 = new Date(01, 02, 2004);
		System.out.println(date3.equals(date4));
		
		Date dateA = new Date();
		boolean setCorrect = false;
		int dayNumber = 55;
		int monthNumber = 13;
		int yearNumber = 200;

		Scanner sc = new Scanner(System.in);
		do {
			try {
				

				dateA.setDay(dayNumber);
				dateA.setMonth(monthNumber);
				dateA.setYear(yearNumber);

				setCorrect = true;
				
			}
			catch(java.lang.IllegalArgumentException e){
				 System.out.println("Invalid Date");
				 System.out.println("Input Day between 1 and 31: ");
				 dayNumber = sc.nextInt();
				 System.out.println("Input Month between 1 and 12: ");
				 monthNumber = sc.nextInt();
				 System.out.println("Input Year more than 1900: ");
				 yearNumber = sc.nextInt();
			}
			
			
		}while(!setCorrect);
		setCorrect = false;
		dayNumber = 65;
		monthNumber = 15;
		yearNumber = 10;

		do {
			try {
				Date dateB = new Date(dayNumber, monthNumber, yearNumber);
				setCorrect = true;
				System.out.println(dateB);
			}
			catch(java.lang.IllegalArgumentException e){
				 System.out.println("Invalid Date");
				 System.out.println("Input Day between 1 and 31: ");
				 dayNumber = sc.nextInt();
				 System.out.println("Input Month between 1 and 12: ");
				 monthNumber = sc.nextInt();
				 System.out.println("Input Year more than 1900: ");
				 yearNumber = sc.nextInt();
			}
			
			
		}while(!setCorrect);
		
		sc.close();
	}
}
