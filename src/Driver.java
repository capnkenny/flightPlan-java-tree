import java.util.*;
import java.io.*;

public class Driver
{
	public static void main(String[] args) throws
		FileNotFoundException, IOException, InterruptedException
	{
		Scanner in = new Scanner(new FileReader("Flights.txt"));
		Vector<Flight> preList = new Vector<Flight>();
		Vector<String> airList = new Vector<String>();
		String airport, flightDate, flightTime;
		int flightNum;
		int mid, mid2, last;
		SortedListNoDuplicatesInterface<Flight> flightList  = new BstSortedList<Flight>();
		
		while(in.hasNext())
		{
			airport = in.next();
			if (!airList.contains(airport))
				airList.add(airport);
			flightNum = in.nextInt();
			flightDate = in.next();
			flightTime = in.nextLine();
			Flight nextFlight = new Flight(airport, flightNum, flightDate, flightTime);
			preList.add(nextFlight);
		}
		in.close();
		
		last = preList.size();
		mid = last / 2;
		mid2 = mid + 1;
		boolean left = false;
		while (mid != -1 && mid2 < last)
		{	
			if (left)
			{
				flightList.add(preList.get(mid));
				mid -= 1;
				left = false;
			}
			else
			{
				flightList.add(preList.get(mid2));
				mid2 += 1;
				left = true;
			}
			
		}
		
		for (int i = 2; i > -1; i--)
		{
			flightList.add(preList.get(i));
		}
		
		new Menu(flightList, airList);
		
	}
	
	
	
}
