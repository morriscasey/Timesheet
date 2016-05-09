package edu.greenrivertech.timesheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Overtime
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Timesheet ourTimesheet = new Timesheet();
		Scanner stdin = new Scanner(System.in);
		System.out.print("Filename: ");
		String name = stdin.nextLine();
		File file = new File(name);
		Scanner fileIn = new Scanner(file);
		
		// Reads in rows to determine how many weeks to process
		ourTimesheet.setNumberOfWeeks(fileIn.nextInt());
		fileIn.nextLine();

		// System.out.println(numRows);
		for (int i = 0; i < ourTimesheet.getNumberOfWeeks(); i++)
		{
			String line = fileIn.nextLine();
			System.out.println(line);
			Scanner lineIn = new Scanner(line);
			int[] tempArray = new int[Timesheet.DAYS];
			// Load in each day into timesheet array
			for (int j = 0; j < 7; j++)
			{
				tempArray[j] = lineIn.nextInt();
				//ourTimesheet.addHour(j, lineIn.nextInt());
			}
			//ourTimesheet.addWeek(ourTimesheet.getTempWeek());
			ourTimesheet.addWeek(tempArray);
		}
		
		
		ourTimesheet.calculatePay();
	}

}
