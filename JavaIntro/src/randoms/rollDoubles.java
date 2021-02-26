package randoms;
import java.util.Random;
import java.util.Scanner;

public class rollDoubles 
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("How many times should the dice roll?");
		int t = kb.nextInt();
		rollDoubles game1 = new rollDoubles(t);
		rollDoubles game2 = new rollDoubles();
	}
	
	
	
	public rollDoubles(int tries)
	{
		int num1;
		int num2;
		int doubles = 0;
		Random r = new Random();
		for(int i=0;i<tries;i++)
		{
			num1 = getNum(1,6);
			num2 = getNum(1,6);
			System.out.println("Rolled "+num1+","+num2);
			if(matching(num1,num2))
			{
				doubles++;
			}
		}
		System.out.println("Number of doubles "+ doubles);
	}
	
	public rollDoubles()
	{
		int num1;
		int num2;
		int doubles = 0;
		Random r = new Random();
		for(int i=0;i<10;i++)
		{
			num1 = getNum(1,6);
			num2 = getNum(1,6);
			System.out.println("Rolled "+num1+","+num2);
			if(matching(num1,num2))
			{
				doubles++;
			}
		}
		System.out.println("Number of doubles "+ doubles);
	}
	
	public int getNum(int low, int high)
	{
		Random r = new Random();
		return r.nextInt((high+1)-low)+low;
	}
	
	public boolean matching(int a, int b)
	{
		if(a==b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
