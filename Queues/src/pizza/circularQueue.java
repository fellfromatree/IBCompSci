package pizza;

import java.util.Scanner;

public class circularQueue {
	int nums[];
	int count, head, tail;
	
	public static void main(String[] args) {
		circularQueue demo = new circularQueue();

	}

	public circularQueue()
	{
		Scanner kb = new Scanner(System.in);
		nums = new int[20];
		count=0;
		head=0;
		tail=0;
		int more = 1;
		
		while (more!=3)
		{
			if(more==1)
			{
				System.out.println("What do you want to add to the queue?");
				int data = kb.nextInt();
				add(data);
			}
			
			if(more==2)
			{
				System.out.println("Just removed"+remove());
			}
			printQueue();
			
			System.out.println("1. to enter more data");
			System.out.println("2. to remove data");
			System.out.println("3. to quit");
			more = kb.nextInt();
		}
	}
	
	public void add(int data)
	{
		if(count==nums.length)
		{
			System.out.println("Queue full");
		}
		else
		{
			nums[tail]=data;
			tail = (tail+1) % nums.length;
			count++;
		}
	}

	public int remove()
	{
		if(count==0)
		{
			System.out.println("Nothing to remove");
			return -1;
		}
		else
		{
			int t = nums[head];
			nums[head]=0;
			head = (head+1) % nums.length;
			count--;
			return t;
		}
	}
	
	public void printQueue()
	{
		System.out.println("\nCurrent Queue");
		for(int x=0;x<nums.length;x++)
		{
			System.out.print(nums[x]+", ");
		}
		System.out.print("\n");
	}
	
}
