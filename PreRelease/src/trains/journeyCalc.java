package trains;
import java.util.Scanner;

public class journeyCalc {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		journeyCalc c1 = new journeyCalc();
	}
	
	
	public journeyCalc()
	{
		int trips[] = {9,11,13,15,10,12,14,16};
		int up=0;
		int down=0;
		int capacity[]= {480,480,480,480,480,480,480,640};
		int seatsSold[]= {0,0,0,0,0,0,0,0};
		double income[] = {0,0,0,0,0,0,0,0};
		int moreInputs = 1;
		boolean space = false;
		int tickets=0;
		while(moreInputs==1)
		{
			displayBoard(trips,capacity,seatsSold);
			space=false;
			while (!space)
			{
				System.out.println("Number of tickets required");
				tickets = getValidJourney(1,80);
				
				System.out.println("Select outbound train");
				up = getValidJourney(1,4);
				
				System.out.println("Select return train");
				down = getValidJourney(up+4,8);
				
				up--;
				down--;
				
				space = checkSpace(seatsSold,capacity,tickets,up,down);
				
			}
			
			updateData(seatsSold, income, tickets, up, down, freeSeats(tickets));
			
			System.out.println("Enter 1 to buy more tickets, or 2 to exit");
			moreInputs = getValidJourney(1,2);
		}
		
		outputs(trips, seatsSold, income);
	}
	
	public void displayBoard(int t[],int c[],int s[])
	{
		System.out.println("Outbound Journeys");
		for(int x=0;x<4;x++)
		{
			System.out.print("Train "+(x+1));
			System.out.print(" Departs "+t[x]);
			if(c[x]==s[x])
			{
				System.out.print(":00 - Closed\n");
			}
			else
			{
				System.out.print(":00 - "+(c[x]-s[x])+" seats available\n");
			}
		}
		
		System.out.println("\nReturn Journeys");
		for(int x=4;x<8;x++)
		{
			System.out.print("Train "+(x+1));
			System.out.print(" Departs "+t[x]);
			if(c[x]==s[x])
			{
				System.out.print(":00 - Closed\n");
			}
			else
			{
				System.out.print(":00 - "+(c[x]-s[x])+" seats available\n");
			}
		}
		
	}
	
	public int getValidJourney(int min, int max)
	{
		String in;
		int num=0;
		boolean valid=false;
		Scanner kb = new Scanner(System.in);
		while (!valid)
		{
			try 
			{
				System.out.println("Please enter a number "+min+"-"+max);
				in = kb.nextLine();
				num = Integer.parseInt(in);
				if(num>=min && num<=max)
				{
					valid=true;
				}
			}
			catch(Exception e)
			{
				System.out.println("Please enter a valid number");
			}
		}
		
		return num;	
		
	}
	
	
	public boolean checkSpace(int s[], int c[], int t, int u, int d)
	{
		if(s[u]+t<c[u] && s[d]+t<c[d])
		{
			return true;
		}
		else
		{
			System.out.println("\n***Unable to fulfil request, please try again***\n");
			return false;
		}
	}
	

	public int freeSeats(int t)
	{
		return t/10;
	}

	public void updateData(int s[], double i[], int t, int u, int d, int f)
	{
		// Update seats sold
		s[u] = s[u]+t;
		s[d] = s[d]+t;
		
		// Update income
		int cost = (t-f)*25;
		i[u] = i[u] + cost;
		i[d] = i[d] + cost;
	}
	
	public void outputs(int[] t, int s[], double i[])
	{
		int high = 0;
		int totalPass = 0;
		int totalMoney = 0;
		System.out.println("End of day");
		for(int x=0;x<t.length;x++)
		{
			System.out.println(t[x]+":00 departure sold "+s[x]+" seats, earning $"+i[x]);
			
			totalPass += s[x];
			totalMoney += i[x];
			if(s[x]>s[high])
			{
				high = x;
			}
		}
		
		System.out.print("\nThe busiest train was the "+t[high]+":00 ");
		System.out.print("which sold "+s[high]+" tickets ");
		System.out.print("and earned $"+i[high]);
		
		System.out.println("\nTotal income today was $"+totalMoney+" from "+totalPass+" passengers");
	}
	
}
