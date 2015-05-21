
public class Flight implements Comparable<Flight>
{

	private String airport;
	private int flightNum;
	private String flightDate;
	private String flightTime;
	public String key;
	
	public Flight()
	{
		this(null, -1, null, null);
		key = null;
	}
	
	
	
	public Flight(String air, int num, String date, String time)
	{
		airport = air.trim();
		flightNum = num;
		flightDate = date.trim();
		flightTime = time.trim();
		key = flightNum+flightDate.trim()+flightTime.trim();
	}
	
	public int compareTo(Flight other)
	{
		return this.key.compareTo(other.key);
	}
	
	public boolean equals(Flight other)
	{
		return this.equals(other);
	}
	
	public String toString()
	{
		String str = "";
		
		str += airport + "\t" + flightNum + "\t" + flightDate + "\t" + flightTime + "\n";
	
		return str;
	}
	
	public void setFlightNum(int num)
	{
		flightNum = num;
	}
	
	public void setFlightDate(String date)
	{
		flightDate = date;
	}
	public void setFlightTime(String time)
	{
		flightTime = time;
	}
	public void setFlightKey()
	{
		key = flightNum+flightDate+flightTime;;
	}
	
	public void setAirport(String air)
	{
		airport = air;
	}
}
