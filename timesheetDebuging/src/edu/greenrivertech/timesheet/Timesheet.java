package edu.greenrivertech.timesheet;

import java.util.ArrayList;
import java.util.List;

public class Timesheet
{
	private static final int DAYS = 7;
	private static final int MAX_HOURS = 40;
	
	private int numberOfWeeks;
	private int totalHours;
	private int totalPay;
	
	int[] week = new int[DAYS];
	List<int[]> listOfTimesheets = new ArrayList<>();
	
	/**
	 * Constructor 
	 */
	public Timesheet(){
		this.numberOfWeeks = 0;
		this.totalHours = 0;
		this.totalPay = 0;
	}
	
	public void setListofTimesheets(int[] newTimesheet){
		this.listOfTimesheets.add(newTimesheet);
	}
	
	public void calculatePay(){
		for(int[] singleWeek: this.listOfTimesheets){
			int maxHrs = MAX_HOURS;
			for (int i = 0; i < singleWeek.length; i++)
			{
				double tempDailyPay = 0;
				// Checks if worked and calculates base pay
		        if(singleWeek[i] > 0)
		        {
		            tempDailyPay = singleWeek[i]*10;
		        }

		        // If work over 8 hours and calc additional 2 dollars
		        if(singleWeek[i]> 8)
		        {
		            tempDailyPay += (singleWeek[i] - 8) * 2;
		        }

		        // Starts with 40 hour and then sets max hours to hours already calculated.
		        if(this.totalHours > maxHrs)
		        {
		            tempDailyPay += (totalHours - maxHrs)*4;
		            maxHrs = totalHours;
		        }

		        // Calculated time and a half for Sunday
		        if(i == 0)
		        {
		            tempDailyPay *= 1.5;
		        }

		        // Calculated double time for Saturday
		        if(i == 6)
		        {
		            tempDailyPay *= 2.0;
		        }
		        this.totalPay += tempDailyPay;
			}
		}
	}
	
	/**
	 * 
	 * @param numberOfWeeks
	 */
	public void setNumberOfWeeks(int numberOfWeeks){
		this.numberOfWeeks = numberOfWeeks;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumberOfWeeks(){
		return this.numberOfWeeks;
	}
	
	public void addHour(int day, int hours){
		this.week[day] = hours;
	}
	
	public int[] getWeek(){
		return this.week;
	}
	
}
