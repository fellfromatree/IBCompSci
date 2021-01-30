package pizza;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class orders {

	Queue order;
	Scanner kb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		orders o1 = new orders();
	}
	
	public orders()
	{
		order = new LinkedList<String>();
		kb = new Scanner(System.in);
		System.out.println("Welcome to BIS Pizza");
		int choice = 0;
		while(choice !=4)
		{
			System.out.println("Current order total: "+order.size());
			System.out.println("1. Place order");
			System.out.println("2. View next order");
			System.out.println("3. Complete order");
			System.out.println("4. Exit system");
			System.out.print(">> ");
			choice = validChoice(1,4);
			if (choice==1)
			{
				addOrder();
			}
			if (choice==2)
			{
				System.out.println(viewOrder());
			}
			if (choice==3)
			{
				System.out.println(completeOrder());
			}
		}
		
	}

	public void addOrder()
	{
		String c="";
		System.out.println("Please enter size 1. S, 2. M or 3. L");
		c = c+kb.next();
		System.out.println("Please choose toppings");
		c = c+" "+kb.next();
		order.add(c);
	}
	
	public int validChoice(int min, int max)
	{
		int c = kb.nextInt();
		while(c<min || c>max)
		{
			c = kb.nextInt();
		}
		return c;
	}
	
	public String viewOrder()
	{
		if(!order.isEmpty())
		{
			return "Next order to complete\n"+order.peek();
		}
		else
		{
			return "All orders complete";
		}
	}
	
	public String completeOrder()
	{
		if(!order.isEmpty())
		{
			return order.remove()+" completed and delivered";
		}
		else
		{
			return "All orders complete";
		}
	}
	
}
