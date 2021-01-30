package gameDemo;
import java.util.Stack;
import java.util.Scanner;

public class game {
	private Stack moves;

	public static void main(String[] args) {
		game g1 = new game();
		g1.play();

	}
	
	public game()
	{
		moves = new Stack();
	}
	
	public void play()
	{
		Scanner kb = new Scanner(System.in);
		String m="";
		while(!m.equals("quit"))
		{
			System.out.println("Enter move:");
			m = kb.nextLine();
			
			if(m.equals("undo") && !moves.isEmpty())
			{
				System.out.println(moves.pop());
			}
			else if(m.equals("undo") && moves.isEmpty())
			{
				System.out.println("Stack is empty");
			}
			else if(!m.equals("quit"))
			{
				moves.push(m);
			}
		}
		
		System.out.println("Quitting\nItems left on stack:");
		while(!moves.isEmpty())
		{
			System.out.print(moves.pop()+", ");
		}	
	}

}
