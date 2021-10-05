package javaIOPractice;

import java.util.Scanner;

public class ErrorCatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ErrorCatching e1 = new ErrorCatching();
	}
	
	
	public ErrorCatching()
	{
		int n = getNum(1,100);
		System.out.println(n);
	}
	
	
	public int getNum(int low, int high)
	{
		Scanner kb = new Scanner(System.in);
		int n=0;
		boolean success = false;
		
		while(!success)
		{
			System.out.println("Please enter a number "+low+" - "+high);
			String ui = kb.nextLine();
			try
			{
				n = Integer.parseInt(ui);
				if (n>=low && n<=high)
				{
					success=true;
				} 
			}
			catch (Exception e)
			{
				System.out.println("You did not enter a number");
			}
		}
		
		return n;
	}

}
