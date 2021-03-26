package iF;
import java.util.Scanner;

public class influencer {

	private String fullName;
	private String country;
	private String userName;
	private boolean instaFamous;
	private String[] posts;
	private int[] likes;
	
	public influencer(String fn, String c, String un)
	{
		this.fullName = fn;
		this.country = c;
		this.userName = un;
		this.instaFamous = false;
		
		posts = new String[10];
		likes = new int[10];
		
		posts();
		
	}
	
	public void posts()
	{
		Scanner kb = new Scanner(System.in);
		for (int x=0; x<10; x++)
		{
			System.out.println("Please enter the description of post " + (x+1));
			posts[x] = kb.nextLine();
			
			System.out.println("How many likes does post " + (x+1)+" have?");
			likes[x] = getValidNum();
		}
	}
	
	public int getValidNum()
	{
		int x =-1;
		boolean valid = false;
		Scanner kb = new Scanner(System.in);
		while (!valid || x<0)
		{
			try
			{
				x = Integer.parseInt(kb.nextLine());
				valid = true;
			}
			catch (Exception e)
			{
				System.out.println("Please enter a valid integer");
			}
		}
		return x;
	}
	
	public void retrieveDetails()
	{
		evaluateProfile();
		System.out.print("User: "+fullName);
		System.out.print("Lives In: "+country);
		System.out.print("Username: @"+userName);
		System.out.print("Instafamous: "+instaFamous);
	}
	
	
	public void evaluateProfile()
	{
		int total = 0;
		for(int x = 0; x<likes.length;x++)
		{
			total += likes[x];
		}
		double ave = total/likes.length;
		if(ave>=1000)
		{
			instaFamous = true;
		}
	}
	
	public void changeUsername(String nun)
	{
		this.userName = nun;
		retrieveDetails();
	}

}
