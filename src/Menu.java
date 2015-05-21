import java.util.*;

public class Menu 
{
	Scanner console = new Scanner(System.in);
	SortedListNoDuplicatesInterface<Flight> test = new BstSortedList<Flight>();
	String[] airListing;
	public Menu(SortedListNoDuplicatesInterface<Flight> fList, Vector<String> aList) throws InterruptedException
	{
		test = fList;
		airListing = new String[aList.size()];
		for (int i = 0; i < aList.size(); i++)
			airListing[i] = aList.get(i);
		display(test);
	}
	
	public void display(SortedListNoDuplicatesInterface<Flight> list) throws InterruptedException
	{
		int answer = -1;
		System.out.print("Would you like to:\n\n1) Display All Flights?\n2) View "
				+"A Specific Flight?\n3) Exit?\n\nEntry:\t");
		answer = console.nextInt();
		if (answer > 3 || answer < 1)
		{
			try
			{
				System.out.println("Incorrect Entry, try again.\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				Thread.sleep(2000);
				retry(1);
			}
			catch(InterruptedException e)
			{
				System.out.println("Error regenerating menu! Quitting...");
			}
		}
		
		if (answer == 1)
		{
			displayList(list);
			Thread.sleep(7000);
			retry(1);
		}
		else if (answer == 2)
			findFlight();
		else if (answer == 3)
			retry(3);
	}
	
	
	//Used from BstSortedList in-class example
	 public static void displayList(SortedListNoDuplicatesInterface<Flight> aList)
		{
			Object[] listArray = aList.toArray();
			for (int index = 0; index < listArray.length; index++)
			{
				System.out.print(listArray[index] + " ");
			} // end for

			System.out.println();
		} // e
	 
	 public void findFlight() throws InterruptedException
	 {
		 int fNum, fMon, fDay, fYear, temp = -1;
		 String time, date = "";
		 int res = -1;
		 InputMismatchException error = new InputMismatchException();
		 console.nextLine();
		 
		 try
		 {
		 System.out.println("\nEnter the flight number you wish to search for (3 digits): ");
		 fNum = console.nextInt();
		 System.out.println("\nEnter the month of the flight you wish to search for (i.e. January - 01): ");
		 fMon = console.nextInt();
		 if (fMon < 10)
			 date += "0";
		 date += fMon + "/";
		 System.out.println("\nEnter the day of the flight you wish to search for (i.e. 08): ");
		 fDay = console.nextInt();
		 if (fDay < 10)
			 date += "0";
		 date += fDay + "/";
		 System.out.println("\nEnter the year of the flight you wish to search for (i.e. 2012 - 12): ");
		 fYear = console.nextInt();
		 if (fYear < 10)
			 date += "0";
		 date += fYear + " ";
		 System.out.println("\nEnter the time of the flight you wish to search for (24hr time i.e. 1:30PM - 13:30): ");
		 time = console.next();
		 if (!time.contains(":"))
			 throw error;
		 else
		 {
			 
			 Flight holder = new Flight("", fNum, date.trim(), time);
			 System.out.println(holder.key);
			 temp = airListing.length;
			 for (int i = 0; i < temp; i++)
			 {
				 holder.setAirport(airListing[i]);
				 res = test.getPosition(holder);
				 
				 if (res > -1)
					 i = temp+1;
			 }
			 
			 if (res > -1)
			 {
				 System.out.println("Flight found!\n");
				 System.out.println(test.getEntry(res).toString());
				 Thread.sleep(5000);
				 retry(1);
			 }
			 else
			 {
				 System.out.println("Specified Flight not found! Quitting to main menu...");
				 Thread.sleep(5000);
				 retry(1);
			 }
		 }
		 
		 }
		 catch(InputMismatchException e)
		 {
			System.out.println("Invalid Argument. Retrying....\n");
			Thread.sleep(2000);
			retry(2);
		 }
		 
			 
		 
	 }
	 
	 public void retry(int num) throws InterruptedException
	 {
		 if (num == 1)
			 display(test);
		 else if (num == 2)
		 {
			 findFlight();
		 }
		 else if (num == 3)
		 {
			System.out.println("Goodbye!");
			console.close();
			System.exit(0);
		 }
	 }
}
