package edu.greenrivertech.timesheet;

import java.util.ArrayList;
import java.util.List;

public class Timesheet
{
	
	private static final int DAYS = 7;
	private static final int MAX_HOURS = 40;

	private class Week
	{
		private int totalHours;
		private int totalPay;
		int[] days = new int[DAYS];
	}
	
	//fields
	private int numberOfWeeks;
	private Week tempWeek;
	List<Week> listOfWeeks = new ArrayList<>();
	

	/**
	 * Constructor
	 */
	public Timesheet()
	{
		this.numberOfWeeks = 0;
		// this.totalHours = 0;
		// this.totalPay = 0;
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
	 * 
	 * @param day
	 * @param hours
	 */
	public void addHour(int day, int hours)
	{
		this.tempWeek.days[day] = hours;
	}

	/**
	 * 
	 * @param newWeek
	 */
	public void addWeek(Week newWeek)
	{
		this.listOfWeeks.add(newWeek);
	}


	public Week getTempWeek()
	{
		return tempWeek;
	}





	
	

}
