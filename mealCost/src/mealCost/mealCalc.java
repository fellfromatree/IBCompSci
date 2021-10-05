package mealCost;

import java.text.DecimalFormat;
import java.util.Scanner;

public class mealCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mealCalc m1 = new mealCalc();
	}
	
	
	public mealCalc()
	{
		int dailyMeal = 0;
		int dailyDrinks = 0;
		int dayCount = 0;
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the cost of each meal");
		double mc = kb.nextDouble();
		
		System.out.println("Please enter the cost of each drink");
		double dc = kb.nextDouble();
		
		while(dayCount<5)
		{
			System.out.println("How many meals did you have on day " + (dayCount+1) );
			int mealsToday = kb.nextInt();
			
			System.out.println("How many drinks did you have on day " + (dayCount+1) );
			int drinksToday = kb.nextInt();
			dailyMeal = dailyMeal + mealsToday;
			dailyDrinks += drinksToday;
			
			dayCount++;
			// dayCount +=1;
			// dayCount = dayCount+1;
		}
		double weeklyTotal = ((mc*dailyMeal) + (dc*dailyDrinks));
		
		DecimalFormat f = new DecimalFormat("##.00");
		System.out.println("Your lunch cost this week is $" + f.format(weeklyTotal));
	}

}
