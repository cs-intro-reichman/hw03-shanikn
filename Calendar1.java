/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0;
		int sundays=2; 
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while(year<2000) 
		{
			month=1;
			while(month<13)//runs on 12 months(a year)
			{
				nDaysInMonth=nDaysInMonth(month, year);//number of days in this month according to year and month
				// while(dayOfMonth<=nDaysInMonth)
				for(int n=0;n<nDaysInMonth;n++)//runs on a given number of days(one month) 
				{
					if(dayOfWeek==1)
					{
						System.out.println(dayOfMonth+"/"+month+"/"+year+" Sunday");
						if(dayOfMonth==1)
						{
							sundays++;
						}
					}
					else
					{
						System.out.println(dayOfMonth+"/"+month+"/"+year);
					}
					
					advance();//advances the day of the week and the day of the month(one day)
					debugDaysCounter++;
				}
				dayOfMonth=1;
				month++;	
			}

			if(debugDaysCounter>36500)
				{
					break;
				}
			year++;
		}
		System.out.println("During the 20th century, "+sundays+" Sundays fell on the first day of the month");
			
		}
	 		
	 		
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		
        
	 	//// Write the necessary ending code here
	 
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		// Replace this comment with your code

		//nDaysInMonth=nDaysInMonth(month, year);
		// if(dayOfMonth<nDaysInMonth)
		// {
			dayOfMonth++;
		// }
		// else
		// {
		// 	dayOfMonth=1;
		// }
		
		if(dayOfWeek<7)
		{
			dayOfWeek++;
		}
		else
		{
			dayOfWeek=1;
		}
		
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    // Replace the following statement with your code
		boolean leapYear=false;
		if(year%4==0)
		{
			leapYear=true;
		}

		return leapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		// Replace the following statement with your code
		int days;
		if(month==4 || month==6 || month==9 || month==11)
			{
				days=30;
			}
			else
			{
				if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
				{
					days=31;
				}
				else
				{
					if(isLeapYear(year))
					{
						days=29;	
					}
					else
					{
						days=28;
					}
				}
			}
		
		return days;
	}
}
