package edu.greenrivertech.timesheet;

import java.util.ArrayList;
import java.util.List;

public class Timesheet
{
	
	public static final int DAYS = 7;
	private static final int MAX_HOURS = 40;

	private class Week
	{
		private int totalHours;
		private int totalPay;
		int[] days;
		
		public Week(int totalHours, int totalPay, int[] days)
		{
			super();
			this.totalHours = totalHours;
			this.totalPay = totalPay;
			this.days = days;
		}
		
		public Week()
		{
			this(0, 0, new int[DAYS]);
		}

	}
	
	//fields
	private int numberOfWeeks;
	private Week tempWeek;
	private List<Week> listOfWeeks;

	/**
	 * Constructor
	 */
	public Timesheet()
	{
		this.numberOfWeeks = 0;
		this.tempWeek = new Week();
		this.listOfWeeks = new ArrayList<>();
	}

	
	//main methods
	
	/**
	 * For each week inside the timesheet object, it calculates what the total
	 * pay for that week is
	 */
	public void calculatePay()
	{
		for (Week singleWeek : this.listOfWeeks)
		{
			int maxHrs = MAX_HOURS;
			for (int i = 0; i < singleWeek.days.length; i++)
			{
				double tempDailyPay = 0;
				
				singleWeek.totalHours += singleWeek.days[i];
				
				// Checks if worked and calculates base pay
				if (singleWeek.days[i] > 0)
				{
					tempDailyPay = singleWeek.days[i] * 10;
				}

				// If work over 8 hours and calc additional 2 dollars
				if (singleWeek.days[i] > 8)
				{
					tempDailyPay += (singleWeek.days[i] - 8) * 2;
				}

				// Starts with 40 hour and then sets max hours to hours already
				// calculated.
				if (singleWeek.totalHours > maxHrs)
				{
					tempDailyPay += (singleWeek.totalHours - maxHrs) * 4;
					maxHrs = singleWeek.totalHours;
				}

				// Calculated time and a half for Sunday
				if (i == 0)
				{
					tempDailyPay *= 1.5;
				}

				// Calculated double time for Saturday
				if (i == 6)
				{
					tempDailyPay *= 2.0;
				}

				singleWeek.totalPay += tempDailyPay;
			}
			
			System.out.println(singleWeek.totalPay);

			
		}
	}
	
	
	
	//Getters and Setters

	/**
	 * 
	 * @param numberOfWeeks
	 */
	public void setNumberOfWeeks(int numberOfWeeks)
	{
		this.numberOfWeeks = numberOfWeeks;
	}

	/**
	 * 
	 * @return
	 */
	public int getNumberOfWeeks()
	{
		return this.numberOfWeeks;
	}

	/**
	 * depracated
	 * @param day
	 * @param hours
	 */
	public void addHour(int day, int hours)
	{
		this.tempWeek.days[day] = hours;
	}

	/**
	 * Depracated
	 * @param newWeek
	 */
	public void addWeek(Week newWeek)
	{
		this.listOfWeeks.add(new Week(newWeek.totalHours, newWeek.totalPay, newWeek.days));
	}

	public void addWeek(int[] newWeek)
	{
		this.listOfWeeks.add(new Week(0, 0, newWeek));
	}

	public Week getTempWeek()
	{
		return tempWeek;
	}





	
	

}
