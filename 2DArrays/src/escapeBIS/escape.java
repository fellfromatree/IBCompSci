package escapeBIS;
import java.util.Scanner;
import java.util.Stack;

public class escape {
	
	 // Declare variables that are needed for the whole program
	 int currentRoom;
	 int direction;
	 int[][] rooms;
	 static Stack<Integer> moves;
	 
	
	public static void main(String[] args) 
	{
		escape game1 = new escape();
		//moves = new Stack();
		
	}
	
	public escape() 
	{
		rooms = new int[16][4];
		for(int i=0;i<16;i++)
		{
			for(int j=0;j<4;j++)
			{
				rooms[i][j] = -1;
			}
			
		}
		
		
		
		// Print welcome message
		System.out.println("Welcome");
		currentRoom=0;
		
		// Loop until the user has escaped
		while (currentRoom != 15)
		{
			System.out.println("Now in room "+currentRoom);
			// Get direction
			Scanner kb = new Scanner(System.in);
			String t = kb.nextLine();
			
			if(t.equals("U"))
			{
				if(!moves.isEmpty())
				{
					currentRoom = (int)moves.pop();
				}
			}
			else
			{
			
				if(t.equals("N"))
				{
					direction = 0;
				}
				else if (t.equals("E"))
				{
					direction = 1;
				}
				else if (t.equals("S"))
				{
					direction = 2;
				}
				else if (t.equals("W"))
				{
					direction = 3;
				}
				
				// Decide if that's valid
				if(rooms[currentRoom][direction]!=-1)
				{
					// Move
					moves.push(currentRoom);
					currentRoom = rooms[currentRoom][direction];
				}
			}
			
		}
		
	}
	
	
}
