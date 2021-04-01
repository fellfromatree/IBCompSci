package iF;
import java.util.Scanner;

public class instagram {

	public static void main(String[] args) {
		influencer i1 = new influencer("Paul","Vietnam","mrc");

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
		influencer i1 = new influencer(n,c,un);
		i1.retrieveDetails();
		i1.evaluateProfile();
	}

}
