package iF;
import java.util.ArrayList;
import java.util.Scanner;


public class instagram {

	ArrayList<influencer> users = new ArrayList<influencer>();
	
	
	public static void main(String[] args) {
		instagram caseygram = new instagram();
		
		caseygram.newUser();
		caseygram.newUser();
		
		caseygram.retrieveUserInfo();
		
	}
	
	
	public void newUser()
	{
		System.out.println("Instagram Signup");
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter your full name");
		String n = kb.nextLine();
		System.out.println("Which country do you live in?");
		String c = kb.nextLine();
		System.out.println("Please choose your username");
		String un = kb.nextLine();
		
		users.add(new influencer(n,c,un));
		
		
	}
	
	public void retrieveUserInfo()
	{
		if(users.isEmpty())
		{
			System.out.println("No one has signed up to your platform yet :(");
		}
		else
		{
			for(int x = 0; x< users.size(); x++)
			{
				influencer i = users.get(x);
				i.retrieveDetails();
				i.evaluateProfile();
			}
		}
	}
	
	
	

}
