package tda;
import java.util.Stack; 
import java.util.Scanner; 

public class escapefromBIS {
	static int currentRoom;
	
	static Stack moves; 
	
	public static void main(String[] args) {
		// 
		currentRoom=0;
		
		int maze[][] = {
			{-1, 1, -1, -1}, //0
			{-1, 2, 5, 0}, //1
			{-1, 3, -1, 1}, //2
			{-1, -1, 7, 2}, //3
			{-1, 5, 8, -1}, //4
			{1, -1, -1, 4}, //5
			{-1, 7, -1, -1}, //6
			{3, -1, -1, 6}, //7
			{4, 9, 12, -1}, //8
			{-1, -1, -1, 8}, //9 
			{-1, 11, 14, -1}, //10
			{-1, -1, 15, 10}, //11 
			{8, 13, -1, -1}, //12
			{-1, 14, -1, 12}, //13
			{10, -1, -1, 13}, //14
			{11, -1, -1, -1} //15 
		};
		
		boolean wantsToExit = false; 
		int dir=0;
		while (currentRoom != 15 || wantsToExit == true) {
			System.out.println("You are in room "+currentRoom+". Enter N, E, S or W to move:");
			dir=chooseDirection();
			System.out.println(dir);
			currentRoom = goOrNot(dir, maze);
		}
	
	//escapefromBIS b1 = new escapefromBIS(); 
	//b1.goBack();
	}
	
	public escapefromBIS() {
		Stack moves = new Stack();
	}
	
	public static int chooseDirection()
	{
		Scanner sc = new Scanner(System.in); 
		String d = sc.nextLine();
	
		while (!"N".equals(d) && !"S".equals(d) && !"E".equals(d) && !"W".equals(d)) {
			System.out.println("This is not valid. Re-enter with N, E, S or W:"); 
			Scanner sc2 = new Scanner(System.in); 
			d = sc2.nextLine();
		
		}
	if (d.equals ("N")) {
		return 0; 
	}
	else if (d.equals("S")) {
		return 2; 
	}
	else if (d.equals("E")) {
		return 1; 
	}
	else if (d.equals("W")) {
		return 3; 
	}
		return currentRoom; 
	}
	
	public static boolean checkDirection() {
		Scanner sc = new Scanner(System.in); 
		String d = sc.nextLine(); 
		
		if (d.equals("N") || d.equals("E") || d.equals("S") || d.equals("W")) {
			return true; 
		}
		else {
			return false; 
		}
	}
	
	public static int goOrNot(int dir, int[][] m) {
		if(m[currentRoom][dir]!=-1)
		{
			currentRoom = m[currentRoom][dir]; 
			System.out.println("You are in room" +currentRoom); 
		}
		return currentRoom;
	
	}
	
	public static void goBack() {
		Scanner kb = new Scanner(System.in);
		String m = "";
		while(m.equals("quit")) {
			System.out.println("Enter N, E, S or W to move:"); 
			m = kb.nextLine();
			
			if(m.equals("undo") && !moves.isEmpty()) {
				System.out.println(moves.pop());
			}
			else if(m.equals("undo") && moves.isEmpty()) {
				System.out.println("Stack is empty"); 
			}
			else if(!m.equals("quit")) {
				moves.push(m); 
			}
		}
	
		System.out.println("Quitting\nItems left on stack"); 
		while(!moves.isEmpty()) {
				System.out.println(moves.pop() + ", "); 
		}
	}
}